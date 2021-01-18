[TOC]



#### 1. Liunx 概述

​		Liunx(Linux is not Unix) 是一个基于POSIX[^1]和Unix的多用户、多任务、支持多线程和多CPU的新能稳定的操作系统，可免费试用并自由传播。

​		Liunx继承了Unix以网络为核心的设计思想，它同时也是一个类Unix操作系统[^2]，能运行主要的Unix工具软件、应用程序和网络协议。支持32位及64位硬件。

​		Linux操作系统最初由一位名为Linus Torvalds（林纳斯 托瓦兹）的芬兰赫尔辛基大学的学生编制内核，随后由全世界各地的成千上万的程序员设计和实现。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的类Unix兼容产品。

#### 2. Liunx特点

- 源码的开放化

  Liunx操作系统是免费,并且开发人员可以自由获取使用Liunx源代码,开发者可以针对不通的应用需求对源码进行修改和优化,极大的便捷了嵌入式系统的开发,这也是其他操作系统无法做到的。

- 支付多用户及任务并行

  Linux系统可支持多名用户在线使用，每个用户之间互不影响，有较好的保密性；Linux可同时执行多个程序，并且各个程序的运行是独立的。

- 良好的安全性及稳定性

  Linux的内核继承了Unix系统的稳定、高效的特性，这一特性已在各领域得到了大量的验证。同时Linux采取了如对读、写控制、审计跟踪、核心授权等多种安全技术，保障用户开发环境的安全。

- 广泛的硬件平台支持

  Linux可以在多种硬件平台上进行运行，如在带有x86、680x0、SPARC、Alpha等大多数主流的处理器平台均可以运行。

- 移植的便捷性

  Linux系统是一个可移植的操作系统，它的内核设计非常精巧，可依据嵌入式的需求，实时的将某些模块从内核插入或移除。而Linux移植也就十分便捷，从一个平台转移到另一个平台后仍能保持自身的正常运行。






[^1]: POSIX 可移植操作系统接口(Portable Operation Syste Interface,正式名称:IEEE1003) 是IEEE为要在各种UNIX操作系统上运行软件，而定义API的一系列互相管理的标准的总称，其正式称呼为IEEE Std 1003，而国际标准名称为[ISO](https://baike.baidu.com/item/ISO)/[IEC](https://baike.baidu.com/item/IEC) 9945。此标准源于一个大约开始于1985年的项目。POSIX这个名称是由[理查德·斯托曼](https://baike.baidu.com/item/理查德·斯托曼)（RMS）应IEEE的要求而提议的一个易于记忆的名称。它基本上是Portable Operating System Interface（可移植操作系统接口）的缩写，而**X**则表明其对Unix API的传承。
[^2]: 类Unix系统(Unix-like)是指继承Unix的设计风格演变出来的系统（比如GNU/[Linux](https://baike.baidu.com/item/Linux)、[FreeBSD](https://baike.baidu.com/item/FreeBSD)、[OpenBSD](https://baike.baidu.com/item/OpenBSD)、SUN公司的[Solaris](https://baike.baidu.com/item/Solaris/3517)、Minix、QNX等），这些操作系统虽然有的是自由软件，有的是[商业软件](https://baike.baidu.com/item/商业软件/3528488)，但都相当程度地继承了原始UNIX的特性，有许多相似处，并且都在一定程度上遵守[POSIX](https://baike.baidu.com/item/POSIX)规范，但是它们却并不含有UNIX的源代码。UNIX的源代码为SCO公司所有，属于商业软件，UNIX的商标权和UNIX标准认定属于OPENGROUP所有。由于UNIX标准认定价格昂贵，所以唯一获得UNIX标准认定的为苹果的MACOS系统。

​	















