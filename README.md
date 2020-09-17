# springboot 实践 


## Spring Cloud Alibaba-Nacos 服务注册与发现

 
 ```
 # 下载源码 项目已下载 见 doc/nacos
 git clone https://github.com/alibaba/nacos.git
 
 # 安装到本地仓库
 cd nacos/
 mvn -Prelease-nacos clean install -U
 
 cd distribution/target/nacos-server-0.7.0
 ```
#### 启动服务
 ```
cd /nacos/bin

# Linux 默认启动端口：8848/nacos
./startup.sh -m standalone

tail -f   /root/nacos/nacos/logs/start.out

# Windows
startup.cmd
  ```
#### nacos docker 启动服务  
 ```
  docker run -d \
  --name nacos-server \
  --restart=always \
  --link mysql:mysql_docker \
  -e PREFER_HOST_MODE=hostname \
  -e MODE=standalone \
  -e SPRING_DATASOURCE_PLATFORM=mysql \
  -e MYSQL_SERVICE_HOST=mysql_docker \
  -e MYSQL_SERVICE_PORT=3306 \
  -e MYSQL_SERVICE_USER=root \
  -e MYSQL_SERVICE_PASSWORD=ec05e6607Ffex0000x \
  -e MYSQL_SERVICE_DB_NAME=nacos \
  -p 8848:8848 \
  nacos/nacos-server
  ```

  
## Nacos Config 分布式配置中心

  #### 配置 mysql 数据库 持久化
  ``` 
  cd nacos-server-1.1.3/nacos/conf
  vi application.properties
  
  # 在 server.port=8848 下方 添加 以下配置
  
  spring.datasource.platform=mysql
  db.num=1
  db.url.0=jdbc:mysql://192.168.1.8:3306/nacos?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false
  db.user=root
  db.password=rroooott
  ```

## Spring Cloud Alibaba-Sentinel 熔断器仪表盘监控

#### github 地址：https://github.com/alibaba/Sentinel

#### 控制台 打包 运行 ：https://github.com/alibaba/Sentinel/tree/master/sentinel-dashboard
 ``` 
 #  项目已下载打包 见 doc/sentinel
 mvn clean package

  java -Xmx512m -Xms512m -Dserver.port=8080  -Dcsp.sentinel.statistic.max.rt=10000  -Dcsp.sentinel.dashboard.server=localhost:8080  -Dproject.name=sentinel-dashboard  -jar sentinel-dashboard.jar
  ```
  
 ##持久化 配置
 
 ```
resource :  资源名称 ；

grade :   0 根据RT(相应时间)降级，
            1根据异常比例降级，
            2根据异常数降级 ， 

timeWindow：时间窗口，单位s(秒) ，达到降级条件后，接下来timeWindow 秒内的请求都会自动熔断，grade为2时注意时长 ；

count ：阈值。 当grade为0时，单位ms(毫秒)，当 1s 内持续进入 5 个请求，对应时刻的平均响应时间（秒级）均超过阈值（count，以 ms 为单位）时，进入熔断降级；

              当grade为1时，值的范围为[0.0, 1.0]，代表 0% - 100% ， 当资源的每秒请求量 >= 5，并且每秒异常总数占通过量的比值超过阈值（DegradeRule 中的 count）之后，资源进入降级状态；

              当grade为2时，值为整数，当资源近 1 分钟的异常数目超过阈值之后会进行熔断。注意由于统计时间窗口是分钟级别的，若 timeWindow 小于 60s，则结束熔断状态后仍可能再进入熔断状态。

```
## nacos 配置降级例如: ym-mobile-service-warehouse-sentinel-degrade
```
ds1:
  nacos: #sentinel  ,熔断降级配置
    dataId: ${spring.application.name}-sentinel-degrade
    groupId: DEFAULT_GROUP
    ruleType: degrade
    server-addr: ${spring.cloud.nacos.discovery.server-addr}

[
  {
    "resource": "helloworld3",
    "count": 20.0,
    "grade": 0,
    "timeWindow": 10
  }
]
```



##  Spring Cloud Gateway 路由网关统一访问接口

## SkyWalking 链路追踪

## Apache Alibaba RocketMQ 消息队列
