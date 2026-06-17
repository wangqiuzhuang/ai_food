package com.example.interceptor;

import com.example.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Value("${token.expire:600}")
    private long tokenExpire;

    private final RedisUtils redisUtils;

    public LoginInterceptor(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String token = request.getHeader("Authorization");
        log.info("token={}", token);
        token = StringUtils.isEmpty(token) ? "" : token.trim();
        String userInfo = redisUtils.getJson("LOGIN_TOKEN:" + token);
        log.info("userInfo={}", userInfo);
        if (userInfo != null) {
            redisUtils.expire("LOGIN_TOKEN:" + token, tokenExpire);
            return true;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("{\"code\":401,\"msg\":\"未登录或登录已过期\"}");
        return false;
    }
}
