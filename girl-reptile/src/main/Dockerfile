FROM jinghan94/centos_jdk:8

MAINTAINER jinghan

VOLUME /tmp

ADD girl-admin.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]