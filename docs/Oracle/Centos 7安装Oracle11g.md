

## 1.更新包

### 1.1. 自动更新

```powershell
yum update
```

### 1.2.更新需要的包

```powershell
yum install  binutils compat-libstdc++-33  compat-libstdc++-33.i686 gcc  gcc-c++  glibc  glibc.i686  glibc-devel  glibc-devel.i686 ksh  libgcc  libgcc.i686  libstdc++  libstdc++.i686  libstdc++-devel  libstdc++-devel.i686  libaio  libaio.i686  libaio-devel  libaio-devel.i686  libXext  libXext.i686  libXtst  libXtst.i686  libX11  libX11.i686  libXau  libXau.i686  libxcb  libxcb.i686  libXi  libXi.i686  make  sysstat  unixODBC  unixODBC-devel  zlib-devel  elfutils-libelf-devel make -y 
```

### 1.3.安装无法自动更新的包

1. 将 'centos7安装Oracle11G需要的依赖包.zip'内的文件上传至CentOS 7 上
2. 在上传的文件夹中执行 `rpm -ivh --force --nodeps *.rpm`

## 2.修改系统参数

### 2.1 修改主机名

1.使用命令 `hostname` 检查 当前主机名
2.使用命令 `vim /etc/hosts` 修改hosts文件内主机名的配置

​	注： 在 127.0.0.1 的hosts配置中增加当前主机名

​			  将当前IP的配置增加至hosts文件

### 2.2 修改系统内核参数

​	1.使用命令`vim /etc/sysctl.conf` 

 2. 添加以下参数
 	```
    net.ipv4.icmp_echo_ignore_broadcasts = 1
    net.ipv4.conf.all.rp_filter = 1
    #设置最大打开文件数
    fs.file-max = 6815744 
    fs.aio-max-nr = 1048576
    #共享内存的总量，8G内存设置：2097152*4k/1024/1024
    kernel.shmall = 2097152
    #最大共享内存的段大小
    kernel.shmmax = 2147483648
    #整个系统共享内存端的最大数
    kernel.shmmni = 4096 
    kernel.sem = 250 32000 100 128
    #可使用的IPv4端口范围
    net.ipv4.ip_local_port_range = 9000 65500
    net.core.rmem_default = 262144
    net.core.rmem_max= 4194304
    net.core.wmem_default= 262144
    net.core.wmem_max= 1048576
    ```

 3. 修改完成后执行 ` sysctl -p`

### 2.3 设置seLiunx

​	1.使用命令 `vim /etc/selinux/config`

​	2.更改 为`SELINUX=disabled` 

### 2.4关闭防火墙

```
systemctl stop firewalld
systemctl disable firewalld
```

### 2.5 修改用户Shell限制

​	1.使用命令 `vim /etc/secutity/limits.conf/`

​	2.在末尾添加以下信息 oracle 为用户

	 #设置进程数软限制
	 oracle soft nproc 2047 
	 #设置进程数硬限制
	 oracle hard nproc 16384 
	 #设置文件数软限制
	 oracle soft nofile 1024 
	 #设置文件数硬限制
	 oracle hard nofile 65536

  3. 执行命令 `vim /etc/pam.d/login` 在文件末尾添加

    session required pam_limits.so

## 3.创建Oracle安装用户

### 3.1 创建用户

```
-- 创建Oracle 用户组
groupadd oracle
-- 创建Oracle用户
useradd -g oracle -m oracle
-- 修改 Oracle用户密码
passwd oracle
```

### 3.2 创建目录

```
mkdir -p /usr/oracle/product/11.2.0.4/dbhome_1
chown -R oracledb:oracledb /usr/oracle/
chmod -R 775 /usr/oracle/
```

3.3 修改用户配置

执行命令 `vim  /home/oracle/.bash_profile`

```
# Oracle Settings
export TMP=/tmp;  
export TMPDIR=$TMP; 
export ORACLE_HOSTNAME=oracledomain;
export ORACLE_BASE=/usr/oracle; 
export ORACLE_HOME=$ORACLE_BASE/product/11.2.0.4/dbhome_1; 
export ORACLE_SID=orcl;
export ORACLE_UNQNAME=orcl; 
export ORACLE_TERM=xterm;
export PATH=$ORACLE_HOME/bin:/usr/sbin:$PATH
export LANG=C
export NLS_LANG=AMERICAN_AMERICA.ZHS16GBK
export LD_LIBRARY_PATH=$ORACLE_HOME/lib:/lib:/usr/lib; 
export CLASSPATH=$ORACLE_HOME/JRE:$ORACLE_HOME/jlib:$ORACLE_HOME/rdbms/jlib;  
```

 







参考地址:

​	https://www.cnblogs.com/xibei666/p/5935219.html

​	https://blog.csdn.net/weixin_41078837/article/details/80584998

​	https://tieba.baidu.com/p/6411355587