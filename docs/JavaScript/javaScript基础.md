[TOC]

# 1 简介

## 1.1 主要功能

1. 嵌入动态文本与HTML页面。
2. 对浏览器时间作出响应。
3. 读写HTML元素。
4. 在数据提交到服务器之前验证。
5. 检测房客的浏览器信息。控制cookies。
6. 基于Node.js 技术进行服务器端编程。

## 1.2 语言组成

- ECMAScript
- DOM(文档对象模型)
- BOM(浏览器对象模型)

## 1.3 JavaScript和ECMAScript

`ECMAScript 是JavaScript的标准了，一般来说JavaScript就是指ECMAScript`

## 1.4 特点

- 解释型语言

  ```
  • 是一门解释型语言，所谓值不需要被编 译为机器码在执行，而是直接。
  • 由于少了编译这一步骤，所以解释型语言开发起来尤为轻松但是解释型语言运行较慢也它的劣势。
  • 不过解释型语言中使用了 JIT 技术，使得运行速度以改善。
  ```

- 基于原型的面向对象

- 简单

  ```
  JavaScript语言中采用的是弱类型的变量类型，对使用的数据类型未做出严格的要求，是基于Java基本语句和控制的脚本语言，其设计简单紧凑
  ```

- 动态性

  ```
  • JavaScriptJavaScriptJavaScriptJavaScriptJavaScript JavaScriptJavaScript 是一门动态语言，所谓的可以暂时理解为 在语言中的一切内容都是不确定。比如个变量，这时刻是个整型，下一时刻可能会变成字符串了。当然这问题我们以后再谈。
  • 不过在补充一句动态语言相比静性能上要差些，由于 JavaScriptJavaScriptJavaScriptJavaScriptJavaScript JavaScriptJavaScriptJavaScript 中应用的 JIT 技术，所以 JS 可能是运行速度最快 的动态语言了。
  ```

- 跨平台性

# 2.基本语法

## 2.1 <script> 标签

### 2.1.1 属性

- type :默认值`text/javascript`
- src: 当需要引入一个外部的Js文件时，使用该属性指向文件的地址，使用该属性后，<script>标签内部的JS内容将会失效。

## 2.2 javaScript严格区分大小写。

## 2.3 注释

- 注释中的内容不会被解析器解析执行，但是会在源码中显示。
- JavaScript中的注释和Java的一致，分为两种：
  - 单行注释: // 注释内容
  - 多行注释: /* 注释内容 */

### 2.4 标识符

- 标识符是指变量、函数、属性的名字，或函数的参数。

- 标识符命名规范:

  - 标识符由字母、数字、下划线(_)、美元符号($)组成。
  - 第一个字符必须是字母、下划线(_)、美元符号($)。

- 标识符名称规则一般按照驼峰命名法。

- 标识符不能是关键字和保留字。

  - 关键字

    | **break** |**do**   | **instanceof** | **typeof** | **case** |
    | -------- | ---- | ---------- | ------ | ---- |
    | **else** | **new** | **var** | **catch** | **finally** |
    | **return** | **void** | **continue** | **for** | **switch** |
  	| **while** | **default** | **if** | **throw** | **delete** |
    | **in** | **try** | **function** | **this** | **with** |
    | **debugger** | **false** | **true** | **null** |  |
    
   - 保留字

  	| **class** |**enum**   | **extends** | **super** | **const** |
    | -------- | ---- | ---------- | ------ | ---- |
    | **export** | **import** | **implements** | **let** | **private** |
    | **public** | **yield** | **interface** | **package** | **static** |

   - 其他不建议使用的标识符

     | **abstract** |**double** | **goto** | **native** | **static** |
     | -------- | ---- | ---------- | ------ | ---- |
     | **boolean** | **synchronize** | **char** | **int** | **protected** |
     | **final** | **transient** | **float** | **long** | **short** |
     | **volatile** | **atguments** | **encodeURI** | **Infinity** | **Number** |
     | **RegExp** | **undefined** | **isFinite** | **Object** | **String** |
     | **Boolean** | **Error** | **RangeError** | **parseFloat** | **SyntaxError** |
     | **Date** | **eval** | **JSON** | **ReferenceError** | **TypeError** |
     | **decodeURI** | **EvalError** | **Math** | **URIError** | **decodeURIComponent** |
     | **Function** | **NAN** | **isNaN** | **parseInt** | **Array** |
     | **EncodeURIComponent** | **** | **** | **** | **** |

## 2.5 变量

` 变量的作用是给某一个值或者对象标注名称`

### 2.5.1 变量的声明

- 使用`var`
- 使用 `let`
- 使用 `const`

### 2.5.2 变量的赋值

- 使用时赋值
- 声明时赋值

## 2.6 数据类型

