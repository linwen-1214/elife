### 	1.创建Oracle用户组和用户

```powershell
-- 创建Oracle 用户组
groupadd oracle
-- 创建Oracle用户
useradd -g oracle -m oracle
-- 修改 Oracle用户密码
passwd oracle

```

### 2. 创建Oracle安装目录及授权

```powershell
-- 创建Oracle 安装目录
mkdir -p /usr/oracle/
-- oracle数据库配置文件目录
mkdir -p /usr/oracle/oraInventory　　
-- oracle数据库软件包解压目录
mkdir -p /usr/oracle/database　　
-- 文件夹授权
chown -R oracle:oracle /usr/oracle/
chown -R oracle:oracle /usr/oracle/oraInventory/
chown -R oracle:oracle /usr/oracle/database/

```

### 3.检查依赖包安装

```powershell
yum install binutils-2.* compat-libstdc++-33* elfutils-libelf-0.* elfutils-libelf-devel-* gcc-4.* gcc-c++-4.* glibc-2.* glibc-common-2.* glibc-devel-2.* glibc-headers-2.* ksh-2* libaio-0.* libaio-devel-0.* libgcc-4.* libstdc++-4.* libstdc++-devel-4.* make-3.* sysstat-7.* unixODBC-2.* unixODBC-devel-2.* pdksh*

```

### 4. 修改内核参数

```
vim /etc/sysctl.conf


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

修改完成后执行  sysctl -p命令使配置生效
```

### 5.修改oracle用户限制

```
在/etc/security/limits.conf 文件末尾另上以下代码

oracle soft nproc 2047 

oracle hard nproc 16384 

oracle soft nofile 1024 

oracle hard nofile 65536
```

### 6.配置用户环境变量

```
#oracle数据库安装目录
export ORACLE_BASE=/data/oracle
#oracle数据库路径
export ORACLE_HOME=$ORACLE_BASE/product/11.2.0/db_1
#oracle启动数据库实例名
export ORACLE_SID=orcl
#xterm窗口模式安装
export ORACLE_TERM=xterm
#添加系统环境变量
export PATH=$ORACLE_HOME/bin:/usr/sbin:$PATH
#添加系统环境变量
export LD_LIBRARY_PATH=$ORACLE_HOME/lib:/lib:/usr/lib
#防止安装过程出现乱码
export LANG=C
#设置Oracle客户端字符集，必须与Oracle安装时设置的字符集保持一致
export NLS_LANG=AMERICAN_AMERICA.ZHS16GBK

添加完成后执行  source /home/oracle/.bash_profile   命令使配置生效。
```

### 7.关闭系统防火墙

```
systemctl stop firewalld.service
systemctl status firewalld.service
systemctl disable firewalld.service
```

### 8.关闭selinux

```
vim /etc/selinux/config 

把文件中的SELINUX=enforcing   改为SELINUX=disabled 即可
```

### 9. 解压安装包

```
unzip linux.x64_11gR2_database_1of2.zip -d /data/database/  #解压文件1
unzip linux.x64_11gR2_database_2of2.zip -d /data/database/  #解压文件2
chown -R oracle:oinstall /data/database/database/　　　　　　 #分配安装文件授权Oracle
```

### 10.Oracle安装

​	1. 使用Oracle用户登录 使用命令行跳转到data/database/database目录下，输入./runInstaller 调出安装页面；









参考地址:

​	https://www.cnblogs.com/xibei666/p/5935219.html

​	https://blog.csdn.net/weixin_41078837/article/details/80584998

​	https://tieba.baidu.com/p/6411355587