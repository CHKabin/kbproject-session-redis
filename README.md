# kbproject-session-redis
基于springboot,shiro,redis的分布式session样例

# 启动
1.执行kbproject-db中sql文件夹下sql文件
2.开启redis
3.启动kbproject-all项目

#打包并测试分布式

1.修改kbproject-allx下server端口；

2.命令行进入kbproject目录，执行mvn install后执行mvn clean package;

3.执行 java -Dfile.encoding=UTF-8 -jar kbproject-all/target/kbproject-all-0.1.0-exec.jar 

#postman测试结果

登陆url:http://localhost:8080/login/userLogin;    username：test11;   password:123456; 


