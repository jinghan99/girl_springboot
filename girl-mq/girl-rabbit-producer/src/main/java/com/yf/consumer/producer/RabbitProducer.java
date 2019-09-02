package com.yf.consumer.producer;

import com.yf.consumer.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package com.yf.mq.producer
 * @Description: rabbit消息生产者
 * @author: jingh
 * @date 2019/8/22 22:56
 */
@Component
public class RabbitProducer {



    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void stringSend() {
        Date date = new Date();
        for(int i=0;i<20;i++){
            String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date) + "队列： "+i;
            System.out.println("[string] send msg:" + dateString);
            // 第一个参数为刚刚定义的队列名称
            this.rabbitTemplate.convertAndSend(RabbitConfig.queue_yf, dateString);
        }

    }
}
