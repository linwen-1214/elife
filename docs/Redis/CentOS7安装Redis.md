

## 1.安装Redis需要的依赖

```
yum install -y gcc 
```

## 2.安装

```powershell
cd /usr/local/
wget http://download.redis.io/releases/redis-6.0.3.tar.gz
tar -zxvf redis-5.0.3.tar.gz
cd redis-6.0.3
make
make install PREFIX=/usr/local/redis
```

