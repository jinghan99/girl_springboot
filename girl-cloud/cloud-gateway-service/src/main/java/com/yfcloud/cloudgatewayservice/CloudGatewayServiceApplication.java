package com.yfcloud.cloudgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * cloud-gateway-service作为服务网关，
 * 将请求转发到user-service。作为zipkin客户端，上传链路数据到zipkin服务器。pom文件引入eureka client、zipkin和zuul的依赖。
 * <p>
 * 所以官方提供了一键脚本（Windows下需要安装curl，不过如果你安装了Git客户端，可以直接在Git Bash中使用）
 * <p>
 * curl -sSL https://zipkin.io/quickstart.sh | bash -s
 * java -jar zipkin.jar
 * <p>
 * 如果用 Docker 的话，直接
 * <p>
 * docker run -d -p 9411:9411 openzipkin/zipkin
 * <p>
 * <p>
 * 启动类加上@EnableZuulProxy注解，开启zuul代理功能。
 * <p>
 * 启动Zipkin服务器，依次启动eureka-server、user-service和gateway-service，浏览器访问http://localhost:5000/user-api/user/hi，显示
 * 访问Zipkin服务器http://localhost:9411/zipkin/，点击 Find Traces 会看到有一条记录
 * <p>
 * <p>
 * 因为之前说的 Zipkin 不再推荐我们来自定义 Server 端了，所以在最新版本的 Spring Cloud 依赖管理里已经找不到 zipkin-server 了。
 * 那么如果直接用官方提供的 jar 包怎么从 RabbitMQ 中获取 trace 信息呢？
 * <p>
 * <p>
 * <p>
 * 我们可以通过环境变量让 Zipkin 从 RabbitMQ 中读取信息，就像这样：
 * <p>
 * java -jar zipkin.jar --zipkin.collector.rabbitmq.addresses=127.0.0.1:5672
 */
@EnableZuulProxy
@SpringBootApplication
public class CloudGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayServiceApplication.class, args);
    }
}
