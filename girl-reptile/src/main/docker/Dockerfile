FROM jinghan94/centos_jdk:8

MAINTAINER jinghan

CMD ["cd /usr/local"]
CMD ["mkdir app"]
CMD ["cd app"]

#用于指定持久化目录 -v 时
VOLUME ["/usr/local/ymapp"]

#相当于CD
WORKDIR /usr/local/app

ADD docker-app-start.sh app-start.sh

#启动镜像时执行的命令
ENTRYPOINT ["./app-start.sh","start"]