package com.yfcloud.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 1.首先通过@EnableFeignClients注解开启FeignClient功能。只有这个注解的存在，程序启动时才会开启对@FeignConfig注解的包的扫描，

 2.根据Feig的规则实现接口，并在接口上面加上@FeignClient注解。

 3.程序启动后会进行包扫描，扫描所有@FeignClient注解的类，并将这些信息注入IOC容器中。

 4.当接口的方法被调用时，通过JDK的代理来生成具体的RequestTemplate模板对象。

 5.根据RequestTemplate再生成Http请求的Request对象。

 6.Request对象交给Client去处理，其中Client的网络请求框架可以是HttpURLConnection、HttpClient和OkHttp。

 7.最后Client被封装到LoadBalanceClient类，这个类结合类Ribbon做到了负载均衡。
 */
@EnableFeignClients
@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
}
