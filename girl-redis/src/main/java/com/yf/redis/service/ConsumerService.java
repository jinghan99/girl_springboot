package com.yf.redis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;


/**
 * @Package com.yf.redis.service
 * @Description: 消息消费者 redis
 * @author: jingh
 * @date 2019/6/13 22:27
 */
@Service
public class ConsumerService  implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisSerializer<String> valueSerializer = stringRedisTemplate.getStringSerializer();
        String deserialize = valueSerializer.deserialize(message.getBody());
        logger.info("收到的mq消息：" + deserialize);
    }
}
