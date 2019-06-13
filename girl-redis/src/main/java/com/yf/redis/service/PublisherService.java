package com.yf.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Package com.yf.redis.service
 * @Description: 消息生产者 redis
 * @author: jingh
 * @date 2019/6/13 22:24
 */
@Service
public class PublisherService {

    public static final String CHANNEL_USER_NAME="TOPIC_USERNAME";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String sendMessage(String name) {
        try {
            stringRedisTemplate.convertAndSend(CHANNEL_USER_NAME, name);
            return "消息发送成功了";
        } catch (Exception e) {
            e.printStackTrace();
            return "消息发送失败了";
        }
    }
}
