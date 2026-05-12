package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 可以传入强度参数 (4-31)，默认为 10
        // 强度越高，计算越慢，防御暴力破解能力越强
        return new BCryptPasswordEncoder();
    }
}