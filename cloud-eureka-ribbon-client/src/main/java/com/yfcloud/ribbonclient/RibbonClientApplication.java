package com.yfcloud.ribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Ribbon是Netflix公司开源的一个负载均衡组件，将负载均衡逻辑封装在客户端中，运行在客户端的进程里。
 *
 * 启动eureka-ribbon-client工程，访问http://localhost:8761，显示服务已注册
 *
 * 现在可以知道，在Ribbon中的负载均衡客户端为LoadBalancerClient 。在spring cloud项目中，
 * 负载均衡器Ribbon会默认从Eureka Client 的服务注册列表中获取服务的信息，并缓存一份，根据缓存的信息，
 * 通过LoadBalancerClient来选择不同的服务实例，从而实现负载均衡，如果禁止Ribbon从Eureka获取注册列表信息，
 * 则需要自己去维护一份服务注册列表信息。根据自己维护的信息，Ribbon也可以实现负载均衡。
 */
@SpringBootApplication
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}
