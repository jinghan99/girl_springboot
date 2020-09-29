# docker build -t java-jar-run:2.0 .
FROM jinghan94/centos_jdk:8
MAINTAINER jinghan94@126.com
ENV MYPATH /data
RUN mkdir $MYPATH
WORKDIR $MYPATH
ENV JAVA_OPTS="\
-Xms512M -Xmx512M -XX:PermSize=125M \
-XX:MaxPermSize=256M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDateStamps \
-XX:+PrintGCDetails -XX:NewRatio=1 -XX:SurvivorRatio=30 -XX:+UseParallelGC -XX:+UseParallelOldGC \
-Duser.timezone=Asia/Shanghai"
ENTRYPOINT java -server ${JAVA_OPTS} -jar $MYPATH/app.jar
