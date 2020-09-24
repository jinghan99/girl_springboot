FROM jinghan94/centos_jdk:8
VOLUME /tmp
ADD girl-reptile-1.0.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar  -Duser.timezone=Asia/Shanghai "," app.jar"]