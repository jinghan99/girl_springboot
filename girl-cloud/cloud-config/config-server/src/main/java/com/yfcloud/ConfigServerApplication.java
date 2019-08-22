package com.yfcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Package com.yfcloud
 * @author: jingh
 * @date 2018/9/7 11:08
 * <p>
 * <p>
 * Spring Cloud Config 是用来为分布式系统中的基础设施和微服务应用提供集中化的外部配置支持，
 * 它分为服务端与客户端两个部分。
 * 其中服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置仓库并为客户端提供获取配置信息、加密 / 解密信息等访问接口；
 * 而客户端则是微服务架构中的各个微服务应用或基础设施，它们通过指定的配置中心来管理应用资源与业务相关的配置内容，
 * 并在启动的时候从配置中心获取和加载配置信息。Spring Cloud Config 实现了对服务端和客户端中环境变量和属性配置的抽象映射，
 * 所以它除了适用于 Spring 构建的应用程序之外，也可以在任何其他语言运行的应用程序中使用。
 * 由于 Spring Cloud Config 实现的配置中心默认采用 Git 来存储配置信息，所以使用 Spring Cloud Config 构建的配置服务器，
 * 天然就支持对微服务应用配置信息的版本管理，
 * 并且可以通过 Git 客户端工具来方便的管理和访问配置内容。当然它也提供了对其他存储方式的支持，比如：SVN 仓库、本地化文件系统。
 * <p>
 * <p>
 * 方式一： 启动工程config-server，再启动config-client，
 * 此时控制台会显示config-client向Url地址为http://localhost:8769的Config Server读取了配置文件，
 * 程序的启动端口为8762。
 * <p>
 * 方式二：依次重启config-server，config-client，控制台 浏览器访问http://localhost:8763/foo
 * 可见，config-server从远程仓库读取了配置文件，config-client从config-sever读取了配置文件。
 * <p>
 * 方式三：依次启动eureka-server和config-server(config-server开启两个实例，端口号8768、8769)，成功后启动config-client。
 * 通过控制台可以看到config-client向地址为http://localhost:8768的config-server读取了配置文件，
 * 浏览器访问http://localhost:8763/foo，显示
 * 多次启动config-client工程（我测试的时候重启了4、5次），
 * 控制台可以看到它会轮流从http://localhost:8768和http://localhost:8769的Config Server读取配置文件，并做了负载均衡。
 * <p>
 * <p>
 * 方式四：使用Spring Cloud Bus刷新配置
 * <p>
 * 依次启动config-eureka-server、config-server和config-client(config-client开启两个实例，端口号8762、8763)，
 * 访问浏览器http://localhost:8762/foo和http://localhost:8763/foo，显示
 * 更改远程仓库配置文件，将foo的值改为”foo: foo version 7“。
 * 通过Postman或其他工具发送一个Post请求http://localhost:8769/actuator/bus-refresh/，请求发送成功后，再访问浏览器，显示
 * 可见，通过向8769端口的服务端发送Post请求刷新配置，由于使用了Spring Cloud Bus，其他服务实例（如两个客户端）也会接收到刷新配置的消息，并刷新配置。
 * <p>
 * 对客户端config-client使用 /actuator/bus-refresh。
 * <p>
 * 首先需要把config-client上的bus-refresh端点给放出来，更改config-client的配置文件。
 * 发送Post请求http://localhost:8762/actuator/bus-refresh/。
 * <p>
 * <p>
 * 局部刷新
 * <p>
 * 某些场景下（例如灰度发布），我们可能只想刷新部分微服务的配置，
 * 此时可通过/actuator/bus-refresh/{destination}端点的 destination 参数来定位要刷新的应用程序。
 * 例如：/actuator/bus-refresh/customers:8000，这样消息总线上的微服务实例就会根据 destination 参数的值来判断是否需要要刷新。
 * 其中，customers:8000指的是各个微服务的 ApplicationContext ID。destination 参数也可以用来定位特定的微服务。
 * 例如：/actuator/bus-refresh/customers:**，这样就可以触发 customers 微服务所有实例的配置刷新。
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}