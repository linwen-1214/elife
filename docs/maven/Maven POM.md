 ### Maven POM

> `POM(Project Object Model,项目对象模型)`是`Maven`工程的基本工作单元，是一个`XML`文件，包含了项目的基本信息，用于描述项目如何构建，声明项目依赖等。
>
> 在`POM`中可以指定一下配置
>
> - 项目依赖
> - 插件
> - 执行目标
> - 项目构建 profile(多环境切换)
> - 项目版本
> - 项目开发者列表
> - 相关邮件列表信息

 ####  POM文件内容元素

| 元素                                   | 描述                                                         | 是否必须 |
| -------------------------------------- | ------------------------------------------------------------ | -------- |
| <project>                              | 工程的根标签。                                               | Y        |
| <modelVersion>                         | POM模型版本 当前默认是 4.0.0                                 | N        |
| <groupId>                              | 这是工程组的标识。它在一个组织或者项目中通常是唯一的。       | Y        |
| <artifactId>                           | 这是工程的标识。它通常是工程的名称。例如，消费者银行。groupId 和 artifactId 一起定义了 artifact 在仓库中的位置。 | Y        |
| <version>                              | 这是工程的版本号。在 artifact 的仓库中，它用来区分不同的版本。 | Y        |
| <parent>                               | 指向当前POM文件的父级，里面必须包含groupId、artifactId、version三个元素 | N        |
| <relativePath>                         | 父项目的pom.xml文件的相对路径。相对路径允许你选择一个不同的路径。默认值是../pom.xml。Maven首先在构建当前项目的地方寻找父项 目的pom，其次在文件系统的这个位置（relativePath位置），然后在本地仓库，最后在远程仓库寻找父项目的pom。 | N        |
| <packaging>                            | 项目产生的构件类型(打包方式)，例如jar、war、ear、pom。插件可以创建他们自己的构件类型，所以前面列的不是全部构件类型 | N        |
| <name>                                 | 项目的名称, Maven产生的文档用                                | N        |
| <url>                                  | 项目主页的URL, Maven产生的文档用                             |          |
| <description>                          | 项目的详细描述, Maven 产生的文档用。 当这个元素能够用HTML格式描述时（例如，CDATA中的文本会被解析器忽略，就可以包含HTML标 签）， 不鼓励使用纯文本描述。如果你需要修改产生的web站点的索引页面，你应该修改你自己的索引页文件，而不是调整这里的文档。 |          |
| <prerequisites>                        | 描述了这个项目构建环境中的前提条件                           |          |
| <licenses><license>                    | 许可证                                                       |          |
| <mailingLists><mailingList>            | 邮件列表                                                     |          |
| <developers><developer>                | 开发者                                                       |          |
| <contributors><contributor>            | 贡献者                                                       |          |
| <issueManagement>                      | 问题追踪系统                                                 |          |
| <ciManagement>                         | 持续集成系统                                                 |          |
| <scm>                                  | 版本控制系统                                                 |          |
| <prerequisites><maven>                 | 要求Maven最低版本，默认值为2.0                               |          |
| <build><sourceDirectory>               | 主源码目录                                                   |          |
| <build><scriptSourceDirectory>         | 脚本源码目录                                                 |          |
| <build><testSourceDirectory>           | 测试源码目录                                                 |          |
| <build><outputDirectory>               | 主源码输出目录                                               |          |
| <build><testOutputDirectory>           | 测试源码输出目录                                             |          |
| <build><resources><resource>           | 主资源目录                                                   |          |
| <build><testResources>                 | 测试资源目录                                                 |          |
| <build><finalName>                     | 输出主构件的名称                                             |          |
| <build><directory>                     | 输出目录                                                     |          |
| <build><filters><filter>               | 通过properties文件定义资源过滤属性                           |          |
| <build><extensions><extension>         | 扩展Maven的核心                                              |          |
| <build><pluginManagement>              | 插件管理                                                     |          |
| <build><plugins><plugin>               | 插件                                                         |          |
| <profiles><profile>                    | POM Profile                                                  |          |
| <distributionManagement>               |                                                              |          |
| <repository>                           | 发布版本部署仓库                                             |          |
| <distributionManagement>               |                                                              |          |
| <snapshotRepository>                   | 快照版本部署仓库                                             |          |
| <repositories><repository>             | 仓库                                                         |          |
| <pluginRepositories><pluginRepository> | 插件仓库                                                     |          |
| <dependencies><dependency>             | 依赖                                                         |          |
| <properties>                           | Maven属性                                                    |          |
| <reporting><plugins>                   | 报告插件                                                     |          |