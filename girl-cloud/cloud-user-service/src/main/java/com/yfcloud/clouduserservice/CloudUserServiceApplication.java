package com.yfcloud.clouduserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 新建Module工程user-service，作为服务提供者，
 * 对位暴漏API接口，pom文件继承主maven工程的pom文件，
 * 引入eureka client、zipkin的起步依赖，其中zipkin的依赖中包含了sleuth的起步依赖。
 * <p>
 * 配置文件中，指定程序名user-service，端口号8762，服务注册地址http://localhost:8761/eureka/，
 * Zipkin Server地址http://localhost:9411。Spring Cloud Sleuth 有一个 Sampler 策略，可以通过这个实现类来控制采样算法。
 * 采样器不会阻碍 span 相关 id 的产生，但是会对导出以及附加事件标签的相关操作造成影响。
 * Sleuth 默认采样算法的实现是 Reservoir sampling，具体的实现类是 PercentageBasedSampler，默认的采样比例为: 0.1(即 10%)。
 * 不过我们可以通过spring.sleuth.sampler.probability来设置，所设置的值介于 0.0 到 1.0 之间，1.0 则表示全部采集。
 */
@SpringBootApplication
public class CloudUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudUserServiceApplication.class, args);
    }
}
