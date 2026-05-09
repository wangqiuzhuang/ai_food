package com.example.controller;

import com.example.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisTestController {

    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/redis")
    public String testRedis() {
        // 1. 测试基础缓存
        redisUtils.set("project_name", "ai_food", 60);

        // 2. 测试获取
        String value = redisUtils.get("project_name");

        // 3. 测试排行榜（添加一个分数）
        redisUtils.addZSet("food_rank", "HotPot", 99.0);

        return "Redis 存取成功，值是：" + value;
    }
}