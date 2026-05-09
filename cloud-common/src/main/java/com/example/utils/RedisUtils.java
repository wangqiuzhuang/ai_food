package com.example.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 */
@RequiredArgsConstructor
public class RedisUtils {

    private final StringRedisTemplate redisTemplate;

    // --- 1. 基础缓存 ---
    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // --- 2. 分布式锁 ---
    public boolean lock(String key, String value, long expireTime) {
        Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.SECONDS);
        return result != null && result;
    }

    public void unlock(String key) {
        redisTemplate.delete(key);
    }

    // --- 3. 倒计时/过期时间 ---
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    // --- 4. 排行榜 (ZSet) ---
    public void addZSet(String key, String member, double score) {
        redisTemplate.opsForZSet().add(key, member, score);
    }

    public Set<String> getRankList(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }
}