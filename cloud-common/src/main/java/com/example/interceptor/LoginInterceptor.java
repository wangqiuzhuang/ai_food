package com.example.interceptor;

import com.example.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${token.expire:600}")
    private long tokenExpire;

    private final RedisUtils redisUtils;

    // 通过构造函数优雅注入工具类
    public LoginInterceptor(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = request.getHeader("Authorization");
        log.info("token={}",token);
        token = StringUtils.isEmpty(token) ? "" : token.trim();
        // 使用你的工具类进行校验
        String userInfo = redisUtils.getJson("LOGIN_TOKEN:" + token);
        log.info("userInfo={}",userInfo);
        if (userInfo != null) {
            // 优雅点：自动续期（滑动过期），直接调用你的 expire 方法
             redisUtils.expire("LOGIN_TOKEN:" + token, tokenExpire);
            return true;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"code\":401,\"msg\":\"未登录或登录已过期\"}");
        return false;
    }
}