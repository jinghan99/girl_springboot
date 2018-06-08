package com.yf.base.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @ClassName RedisCacheManager
 * @Description
 * @Date 2018/5/3 14:26
 * @Author jinghan
 * @Version 1.0
 */
public class RedisCacheManager implements CacheManager {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new RedisCache<>(name, redisTemplate);
    }
}
