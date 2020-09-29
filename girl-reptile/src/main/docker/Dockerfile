# docker build -t girl_app .
FROM jinghan94/centos_jdk:8
MAINTAINER jinghan94@126.com
USER root
ENV MYPATH /data
ENV JVM_OPTS  -Xms512M -Xmx512M
RUN mkdir $MYPATH && chmod 777 $MYPATH
WORKDIR $MYPATH
ADD girl-reptile-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","$JVM_OPTS","/app.jar"]