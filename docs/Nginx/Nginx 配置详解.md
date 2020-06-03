[TOC]



### 1.全局块

```
配置影响nginx全局的指令。一般有运行nginx服务器的用户组，nginx进程pid存放路径，日志存放路径，配置文件引入，允许生成worker process数等。
```

#### 1.1 user

```
配置用户或者组，默认为nobody nobody。
```

#### 1.2 worker_processes

```
允许生成的进程数，默认为1
```

#### 1.3pid 

```
指定nginx进程运行文件存放地址
```

#### 1.4 error_log 

```
制定日志路径，级别。这个设置可以放入全局块，http块，server块，级别以此为：debug|info|notice|warn|error|crit|alert|emerg
```

#### 1.5 events 

```
配置影响nginx服务器或与用户的网络连接。有每个进程的最大连接数，选取哪种事件驱动模型处理连接请求，是否允许同时接受多个网路连接，开启多个网络连接序列化等。
```

##### 1.5.1 accept_mutex

```
设置网路连接序列化，防止惊群现象发生，默认为on
```

##### 1.5.2 multi_accept 

```
设置一个进程是否同时接受多个网络连接，默认为off
```

##### 1.5.3 use

```
事件驱动模型，select|poll|kqueue|epoll|resig|/dev/poll|eventport
```

##### 1.5.4 worker_connections  

````
最大连接数
````

