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



 在分布式系统中服务与服务之间的依赖错综复杂，一种不可避免的情况就是某些服务会出现故障，
 导致依赖于他们的其他服务出现远程调度的线程阻塞。某个服务的单个点的请求故障会导致用户的请求处于阻塞状态，
 最终的结果是整个服务的线程资源消耗殆尽。由于服务的依赖性，会导致依赖于该故障服务的其他服务也处于线程阻塞状态，
 最终导致这些服务的线程资源消耗殆尽，知道不可用，从而导致整个服务系统不可用，即雪崩效应。为了防止雪崩效应，产生了熔断器模型。

 Hystrix是Netflix公司开源的一个项目，提供了熔断器功能，能阻止分布式系统中出现联动故障。Hystrix是通过隔离服务的访问点阻止联动故障的，
 并提供了故障解决方案，从而提高了整个分布式系统的弹性。

 当服务的某个API接口的失败次数在一定时间内小于设定的阈值时，熔断器处于关闭状态，该API接口正常提供服务。
 当该API接口处理请求的失败次数大于设定的阈值时，hystrix判定该API接口出现了故障，打开熔断器，这时请求该API接口会执行快速失败的逻辑
 （即fallback回退的逻辑），不执行业务逻辑，请求的线程不会处于阻塞状态。处于打开状态的熔断器，一段时间后会处于半打开状态，
 并将一定数量的请求执行正常逻辑，剩余的请求会执行快速失败，
 若执行正常逻辑的请求失败了，则熔断器继续打开，若成功了，则关闭熔断器。这样熔断器就具有了自我修复的能力。
 */
@EnableFeignClients
@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
}
