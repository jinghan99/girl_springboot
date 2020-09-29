# docker build -t girl_app:2.0 .
FROM jinghan94/centos_jdk:8
MAINTAINER jinghan94@126.com
ENV MYPATH /data
RUN mkdir $MYPATH
WORKDIR $MYPATH
ENV JAVA_OPTS="\
-server \
-Xms512M -Xmx512M -XX:PermSize=125M \
-XX:MaxPermSize=256M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps \
-XX:+PrintGCDetails -XX:NewRatio=1 -XX:SurvivorRatio=30 -XX:+UseParallelGC -XX:+UseParallelOldGC \
-Duser.timezone=Asia/Shanghai"
VOLUME $MYPATH/app.jar
ENTRYPOINT java ${JAVA_OPTS} -jar ./app.jar
