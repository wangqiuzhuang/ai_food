package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.VO.LoginVO;
import com.example.entity.SwUser;
import com.example.returns.R;
import com.example.service.SwUserService;
import com.example.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author qiuzhuang.wang
 * @since 2026-05-09
 */
@Slf4j
@RestController
@RequestMapping("/swUser")
public class SwUserController {

    @Autowired
    private SwUserService swUserService;
    // 在 Service 或工具类中初始化，也可以注入 Bean
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RedisUtils redisUtils;
    @Value("${token.expire:600}")
    private long tokenExpire;

    /**
     * 注册
     */
    @PostMapping("/register")
    public R<String> register(@RequestBody SwUser entity) {
        log.info("请求参数：{}", JSON.toJSONString(entity));
        try {
            Assert.notNull(entity,"入参不能为空");
            Assert.notNull(entity.getUserName(),"用户名不能为空");
            Assert.notNull(entity.getPassword(),"密码不能为空");
            SwUser swUser = swUserService.queryByName(entity.getUserName());
            if(Objects.nonNull(swUser)){
                throw new RuntimeException("用户已存在");
            }
            //2. 密码加密 rawPassword: 原始明文密码  encodedPassword: 加密后的哈希值
            String encodedPassword = passwordEncoder.encode(entity.getPassword());
            entity.setPassword(encodedPassword);
            swUserService.save(entity);
            return R.ok("注册成功");
        }catch(Exception e){
            return R.error(e.getMessage());
        }
    }


    /**
     * 登录
     */
    @PostMapping("/login")
    public R<LoginVO> login(@RequestBody SwUser entity, HttpServletRequest request) {
        log.info("请求参数：{}", JSON.toJSONString(entity));
        try {
            Assert.notNull(entity,"入参不能为空");
            Assert.notNull(entity.getUserName(),"用户名不能为空");
            Assert.notNull(entity.getPassword(),"密码不能为空");
            SwUser swUser = swUserService.queryByName(entity.getUserName());
            Assert.notNull(swUser,"用户不存在");
            String token = StringUtils.isEmpty(request.getHeader("Authorization")) ? "" : request.getHeader("Authorization").trim();
            String userInfo = redisUtils.getJson("LOGIN_TOKEN:" + token);
            if(!StringUtils.isEmpty(userInfo)){
                return R.ok(new LoginVO(swUser.getUserId(), token));
            }
            token = UUID.randomUUID().toString();
            if(passwordEncoder.matches(entity.getPassword(),swUser.getPassword())){
                // 登录成功，生成一个随机 UUID 作为 Token
                // 存入 Redis，设置过期时间为 10 分钟
                redisUtils.setJson("LOGIN_TOKEN:" + token, swUser, tokenExpire);
            }else{
                throw new RuntimeException("密码错误");
            }
            return R.ok(new LoginVO(swUser.getUserId(), token));
        }catch(Exception e){
            return R.error(e.getMessage());
        }
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (Objects.nonNull(token)) {
            // 【核心配合】登出即销毁，拦截器下次校验就会失败
            redisUtils.delete("LOGIN_TOKEN:" + token);
        }
        return R.ok("登出成功");
    }
}