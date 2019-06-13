package com.yf.redis.config;

import com.yf.redis.service.ConsumerService;
import com.yf.redis.service.PublisherService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @Package com.yf.redis.config
 * @Description: 消息发布订阅者配置类
 * @author: jingh
 * @date 2019/6/13 22:29
 */
@Configuration
@AutoConfigureAfter({ConsumerService.class})
public class SubscriberConfig {
    /**
     * 消息监听适配器，注入接受消息方法，输入方法名字 反射方法
     *
     * @param receiver
     * @return
     */
    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(ConsumerService receiver) {
        return new MessageListenerAdapter(receiver);
    }

    /**
     * 创建消息监听容器
     *
     * @param redisConnectionFactory
     * @param messageListenerAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new ChannelTopic(PublisherService.CHANNEL_USER_NAME));
        return redisMessageListenerContainer;
    }
}
