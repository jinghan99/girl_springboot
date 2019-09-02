package com.yf.consumer.config;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @Package com.yf.mq.config
 * @Description: TODO
 * @author: jingh
 * @date 2019/8/22 22:53
 */
@Configuration
public class RabbitConfig {
    /**
     * 定义队列名
     */
    public final static String queue_yf = "queue_yf";


    /**
     * 定义string队列
     * @return
     */
    @Bean
    public Queue string() {
        return new Queue(queue_yf);

    }

}
