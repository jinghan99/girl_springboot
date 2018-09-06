package com.yfcloud.zuulclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 *  Zuul作为微服务系统的网关组件，用于构建边界服务，致力于动态路由、过滤、监控、弹性伸缩和安全。

 为什么需要Zuul

 Zuul、Ribbon以及Eureka结合可以实现智能路由和负载均衡的功能；
 网关将所有服务的API接口统一聚合，统一对外暴露。外界调用API接口时，
 不需要知道微服务系统中各服务相互调用的复杂性，保护了内部微服务单元的API接口；
 网关可以做用户身份认证和权限认证，防止非法请求操作API接口；网关可以实现监控功能，
 实时日志输出，对请求进行记录；网关可以实现流量监控，在高流量的情况下，对服务降级；
 API接口从内部服务分离出来，方便做测试。

 Zuul通过Servlet来实现，通过自定义的ZuulServlet来对请求进行控制。核心是一系列过滤器，
 可以在Http请求的发起和响应返回期间执行一系列过滤器。Zuul采取了动态读取、编译和运行这些过滤器。
 过滤器之间不能直接通信，而是通过RequestContext对象来共享数据，每个请求都会创建一个RequestContext对象。

 Zuul生命周期如下。
 当一个客户端Request请求进入Zuul网关服务时，网关先进入”pre filter“，
 进行一系列的验证、操作或者判断。然后交给”routing filter“进行路由转发，
 转发到具体的服务实例进行逻辑处理、返回数据。当具体的服务处理完成后，
 最后由”post filter“进行处理，该类型的处理器处理完成之后，将Request信息返回客户端。

 在配置文件做相关配置，包括端口号5000，服务注册中心地址http://localhost:8761/eureka/，
 程序名service-zuul，其中zuul路由配置：zuul.routes.hiapi为”/hiapi/**“，zuul.routes.serviceId为”eureka-client“，
 这两个配置就可以将以”/hiapi“开头的Url路由到eureka-client服务，zuul.routes.hiapi中的”hiapi“是自己定义的需要指定它的path和serviceId，
 两者配合使用，就可以将指定类型的请求Url路由到指定的serviceId。同理，满足”/ribbonapi“开头的请求Url都会被分发到eureka-ribbon-client，
 满足”/feignapi“开头的请求Url都会被分发到eureka-feign-client服务。如果服务存在多个实例，zuul会结合ribbon做负载均衡。
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulClientApplication.class, args);
	}
}
