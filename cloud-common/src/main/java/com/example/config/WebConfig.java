package com.example.config;

import com.example.interceptor.LoginInterceptor;
import com.example.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 1. 这里 Spring 会自动从 RedisCommonConfig 中找到你定义的 redisUtils Bean
    @Autowired
    private RedisUtils redisUtils;

    // 2. 注入拦截器 Bean
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor(redisUtils);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**") // 拦截所有
                .excludePathPatterns(
                        "/swUser/login",    // 登录放行
                        "/swUser/register", // 注册放行
                        "/static/**",
                        "/error"            // SpringBoot 默认错误页也建议放行
                );
    }
}