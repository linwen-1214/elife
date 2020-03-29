[TOC]



### 1.什么是Maven？

>`Maven` 是Apache下的一个纯`Java`开发的开源项目。基于项目对象模型(POM)概念，`Maven`利用一个中央信息片段能管理一个项目的构建、报告和文档等步骤。
>
>`Maven`是一个项目管理和综合工具。Maven提供了开发人员构建一个完整的生命周期框架。开发退案件可以自动完成项目的基础工具建设，`Maven`使用标准的目录结构和默认构建生命周期。
>
>在多个开发团队环境是，`Maven`可以设置按标准在非常短的时间里完成配置工作。由于大部分项目的设置都很简单，并且可重复使用，`Maven`让开发人员的工作更轻松，同时创建报表，检查，构建和测试自动化设置。

### 2.Maven仓库

#### 2.1 本地仓库

> 本地仓库默认存储地址为 `C:\Documents and Settings\{your-username}\.m2`
>
> 可以通过修改`Maven`配置文件更改本地仓库存储地址，配置文件地址`{M2_HOME}\conf\setting.xml`修改其中的`localRepository`配置的值

#### 2.2 中央仓库

> 当本地仓库没有需要的资源时，会从中央仓库中拉取资源到本地仓库进行保存。
>
> 中央仓库默认使用`http://repo1.maven.org/maven2/`,`仓库资源搜索地址:`[https://mvnrepository.com/](https://mvnrepository.com/)
>
> 在国内可以更改仓库地址为 阿里的仓库地址：
>
> 在配置文件`{M2_HOME}\conf\setting.xml`中找到 `mirrors`在其中增加：
>
> ```xml
> <mirror>
> 	<id>alimaven</id>
> 	<name>aliyun maven</name>
> 	<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
> 	<mirrorOf>central</mirrorOf>
> </mirror>
> ```
>`仓库资源搜索地址:`[https://maven.aliyun.com/mvn/view](https://maven.aliyun.com/mvn/view)

### 3.Maven POM

​	 [Maven POM.md](Maven POM.md) 

### 4.引入外部依赖

> 第一种方式
>
> ```XML
> <dependencies>
>     <!-- 在这里添加你的依赖 -->
>     <dependency>
>         <groupId>ldapjdk</groupId>  <!-- 库名称，也可以自定义 -->
>         <artifactId>ldapjdk</artifactId>    <!--库名称，也可以自定义-->
>         <version>1.0</version> <!--版本号-->
>         <scope>system</scope> <!--作用域-->
>         <systemPath>${basedir}\src\lib\ldapjdk.jar</systemPath> <!--项目根目录下的lib文件夹下-->
>     </dependency> 
> </dependencies>
> ```
>
> 第二种方式
>
> ```powershell
> mvn install:install-file -Dfile=${basedir}\src\lib\ldapjdk.jar -DgroupId=ldapjdk -DartifactId=ldapjdk -Dversion=1.0 -Dpackaging=jar
> ```
>
> ```XML
> <dependencies>
>     <!-- 在这里添加你的依赖 -->
>     <dependency>
>         <groupId>ldapjdk</groupId>  <!-- 库名称，也可以自定义 -->
>         <artifactId>ldapjdk</artifactId>    <!--库名称，也可以自定义-->
>         <version>1.0</version> <!--版本号-->
>     </dependency> 
> </dependencies>
> ```
>
> 








