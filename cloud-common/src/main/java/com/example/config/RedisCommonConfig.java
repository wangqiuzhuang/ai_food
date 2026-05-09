package com.example.config;

import com.example.utils.RedisUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisCommonConfig {
    @Bean
    public RedisUtils redisUtils(StringRedisTemplate redisTemplate) {
        return new RedisUtils(redisTemplate);
    }
}