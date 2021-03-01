# 基于远景智能基础镜像构建：java7_centos7.4
FROM harbor.eniot.io/envisioniot/java8:latest
#
# MAINTAINER（必填项，表明编译镜像的owner）
MAINTAINER shuang.wei <shuang.wei@envision-digital.com>

# 定义环境变量
ENV APP_NAME spring-service-ws
ENV APP_HOME /home/envuser

# 经过自动构建后，默认情况下构建好的包会放在 release/ 这个目录下。这里即为将构建好的包复制到容器中去
COPY ./release/* $APP_HOME/
# 需在 git代码根目录 下自行写 服务启动脚本startup.sh
COPY ./startup.sh $APP_HOME/

# 指定工作目录，后续运行启动服务时，以此工作目录为当前路径
WORKDIR $APP_HOME

# 执行命令，改变文件权限
RUN chmod 755 startup.sh

# 启动服务命令
ENTRYPOINT ["bash","./startup.sh"]
