# docker build -t girl_app .
FROM jinghan94/centos_jdk:8
MAINTAINER jinghan94@126.com
USER root
ENV MYPATH /data
RUN mkdir $MYPATH && chmod 777 $MYPATH
WORKDIR $MYPATH
VOLUME  $MYPATH
ADD docker-app-start.sh start.sh
ADD girl-reptile-1.0.0.jar app.jar
RUN chmod 777 $MYPATH/start.sh
ENTRYPOINT ["./start.sh","start"]