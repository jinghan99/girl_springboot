package com.yf.consumer.consumer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Package com.yf.mq.consumer
 * @Description: rabbitmq消费者 @RabbitListener(queues = "simpleMsg") 监听名simpleMsg的队列
 * @author: jingh
 * @date 2019/8/22 22:59
 */
@Component
@RabbitListener(queues = "queue_yf")
public class StringConsumer {
    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    /**
     * 消息消费
     * @RabbitHandler 代表此方法为接受到消息后的处理方法
     */
    @RabbitHandler
    public void recieved(String msg) {
        System.out.println("[string] recieved message:" + msg);
    }
}
