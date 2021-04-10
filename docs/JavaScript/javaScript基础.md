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

### 2.6.1 值类型

- **String(字符串)**

  - 字符串定义使用 '' 或者 "" 定义
  - 其他数值转换为字符串有三种方式：`toString()`、`String()`、`拼串`。

- **Number(数值)**

  - Number用来表示整数和浮点数，最常用的功能就是用来表示10进制的整数和浮点数。

  - Number表示的数字大小是有限制的，范围是`± 1.7976931348623157e+308` 如果超过这个范围就会返回`± Infinity`。

  - NaN，即非数值(Not a Number) 是一个特殊的数值 ，JS中当对数值进行计算时没有结果返回，则返回NaN。

  - 非数值转换为数值：`Number()`、`parseInt()`、`parseFloat()`

    - Number()可以用来转换任意类型的数据，而后两者只能用于转换字符串。
    - parseInt()只会将字符串转换为整数。
  
- parseFloat()可以转换为浮点数。	
  
- **Boolean(布尔)**

  - Boolean类型也被称为逻辑值类型或者真假值类型。
  - Boolean类型只有两个值`true(真)`、`false(假)`。
  - 其他的数据类型也可以通过Boolean()函数转换为布尔类型。

- **Null(空)**

  - Null 类型只有一个值的数据类型，这个特殊的值是`null` 。 
    • 从语义上看null表示的是一个空的对象。所以使用typeof检查null会返回一个Object。 
  - undefined值实际上是由`null`值衍生出来的，所以如果比较`undefined`和`null`是否相等，会返回`true`；

- **Undefined(未定义)**

  - Undefined 类型只有一个值，即特殊的 `undefined` 。 

    -  在使用 var 声明变量但未对其加以初始化时，这个变量的值就是 `undefined`。例如：

      – var message;

      – message 的值就是 undefined

  - 需要注意的是typeof对没有初始化和没有声明的变量都会返回`undefined`。

- **Symbol**

  - Symbol 是 ES6 引入了一种新的原始数据类型，表示独一无二的值

### 2.6.2 引用数据类型

- **Object(对象)**
- **Array(数组)**
- **Function(函数)**

## 2.7 运算符

### 2.7.1 算数运算符

- 算数运算符顾名思义就是进行算数操作的运算符。

- 算数运算符：

  | 运算符 | 说明 | 运算符   | 说明     |
  | ------ | ---- | -------- | -------- |
  | +      | 加法 | ++(前置) | 前置自增 |
  | -      | 减法 | ++(后置) | 后置自增 |
  | *      | 乘法 | --(前置) | 前置自减 |
  | /      | 除法 | --(后置) | 后置自减 |
  | %      | 取模 | +(一元运算符) | 符号不变 |
  |        |      | -(一元运算符) | 符号反转|
  
- 自增(++)与自减(--)

  - 自增和自减分为前置运算和后置元素。

  -  所谓的前置元素就是将元素符放到变量的前边，而后置将元素符放到变

    量的后边。

  - 前置运算，表达式的值等于变量变更以后的值。

  - 后置运算，表达式的值等于变量原值。

- 其他

  - 任何值 做 - * / 运算时，都会隐式的转换为Number进行计算。

- 一元运算符

  - 对于Number类型：
    `+`  正号不会对数字产生影响。
    
    `-` 负号会对数字进行取反计算。
    
  - 对于非Number类型

    会将其转换为Number类型后在进行一元运算。

### 2.7.2 逻辑运算符(布尔运算法)

- 一般情况下使用逻辑运算符会返回一个布尔值。

-  逻辑运算符主要有三个：非、与、或。

-  在进行逻辑操作时如果操作数不是布尔类型则会将其转换布尔类型在进行计算。

- 非使用符号 ! 表示，与使用 && 表示，或使用 || 表示。

  | 运算符 | 说明        | 短路规则                 |
  | ------ | ----------- | ------------------------ |
  | ！     | 逻辑非(NOT) | 无                       |
  | &&     | 逻辑与(AND) | 若左值为假，则不运算右值 |
  | \|\|   | 逻辑非(OR)  | 若左值为真，则不运算右值 |

- **非**

  - 非运算符使用 ! 表示。
  - 非运算符可以应用于任意值，无论值是什么类型，这个运算符都会返回一个布尔值。
  - 非运算符会对原值取反，比如原值是true使用非运算符会返回false，原值为false使用非运算符会返回true。

- **与**

  - 与运算符使用 && 表示。
  - 与运算符可以应用于任何数据类型，且不一定返回布尔值。
  - 对于非布尔值运算，会先将非布尔值转换为布尔值。 
  - 对布尔值做运算时，如果两个值都为true则返回true，否则返回false。 
  - 非布尔值时：如果两个都为true，则返回第二个值，如果两个值中有false则返回靠前的false的值。

- **或**

  - 或运算符使用 || 表示。
  - 或运算符可以应用于任何数据类型，且不一定返回布尔值。
  - 对于非布尔值运算，会先将非布尔值转换为布尔值。 
  - 对布尔值进行运算时，如果两个值都为false则返回false，否则返回true。 
  - 非布尔值时：如果两个都为false ，则返回第二个值，否则返回靠前true的值。

- 三元条件运算符

  - condition? true case : false case

### 2.7.3 赋值运算符

- 简单的赋值操作符由等于号 （ = ） 表示，其作用就是把右侧的值赋给左侧的变量。

- 如果在等于号左边添加加减乘除等运算符，就可以完成复合赋值操作。

  | 运算符   | 等同于     |
  | -------- | ---------- |
  | x+=y     | x=x+y      |
  | x -= y   | x = x - y  |
  | x *= y   | x = x * y  |
  | x /= y   | x = x / y  |
  | x %= y   | x = x % y  |
  | x >>= y  | x = x >> y |
  | x <<= y  | x = x << y |
  | x >>>= y | x = x >>>y |
  | x &= y   | x = x & y  |
  | x \|= y  | x = x \| y |
  | x ^= y   | x = x ^ y  |

  

### 2.7.4 比较运算符

| 运算符 | 说明                                                         | 举例      | 值    |
| ------ | ------------------------------------------------------------ | --------- | ----- |
| ==     | 相等 对于不同的数据类型会进行自动类型转换                    | “5” == 5  | true  |
| !=     | 不相等 对于不同的数据类型会进行自动类型转换                  | “5” != 5  | false |
| ===    | 严格相等 比较时，不会进行自动类型转换,换句话说就是不仅要值相等 并且数据类型也得相等 | “5” === 5 | false |
| !==    | 严格相等 比较时，不会进行自动类型转换,换句话说就是不仅要值相等 并且数据类型也得相等 | “5” !== 5 | true  |
| <      | 小于 对于不同的数据类型会进行自动类型转换                    | “5” <5    | false |
| <=     | 小于等于 对于不同的数据类型会进行自动类型转换                | “5” <=5   | true  |
| >      | 大于 对于不同的数据类型会进行自动类型转换                    | “5” >5    | false |
| >=     | 大于等于 对于不同的数据类型会进行自动类型转换                | “5” <=5   | true  |

### 2.7.5 位运算符

- 或运算（or）：符号为`|`，表示两个二进制位中有一个为1，则结果为1，否则为0。
- 与运算（and）：符号为`&`，表示两个二进制位都为1，则结果为1，否则为0。
- 否运算（not）：符号为`～`，表示将一个二进制位变成相反值。
- 异或运算（xor）：符号为`ˆ`，表示两个二进制位中有且仅有一个为1时，结果为1，否则为0。
- 左移运算（left shift）：符号为`<<`
- 右移运算（right shift）：符号为`>>`
- 带符号位的右移运算（zero filled right shift）：符号为`>>>`

### 2.7.6 其他运算符
> 小括号

在JavaScript中，圆括号是一种运算符，它有两种用法：如果把表达式放在圆括号之中，作用是求值；如果跟在函数的后面，作用是调用函数。
把表达式放在圆括号之中，将返回表达式的值。

> void

void运算符的作用是执行一个表达式，然后返回undefined。

> 逗号运算符

逗号运算符用于对两个表达式求值，并返回后一个表达式的值。

### 2.7.7 运算符优先级

- 运算符的优先级决定了表达式中运算执行的先后顺序，优先级高的运算符最先被执行。

- 关联性决定了拥有相同优先级的运算符的执行顺序。考虑下面这个表达式：

  <table class="fullwidth-table">
 <tbody>
  <tr>
   <th>优先级</th>
   <th>运算类型</th>
   <th>关联性</th>
   <th>运算符</th>
  </tr>
  <tr>
   <td>21</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Grouping"><code>圆括号</code></a></td>
   <td>n/a（不相关）</td>
   <td><code>( … )</code></td>
  </tr>
  <tr>
   <td rowspan="5">20</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Property_Accessors#%e7%82%b9%e7%ac%a6%e5%8f%b7%e8%a1%a8%e7%a4%ba%e6%b3%95"><code>成员访问</code></a></td>
   <td>从左到右</td>
   <td><code>… . …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Property_Accessors#%e6%8b%ac%e5%8f%b7%e8%a1%a8%e7%a4%ba%e6%b3%95"><code>需计算的成员访问</code></a></td>
   <td>从左到右</td>
   <td><code>… [ … ]</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/new"><code>new</code></a> (带参数列表)</td>
   <td>n/a</td>
   <td><code>new … ( … )</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Guide/Functions" title="JavaScript/Reference/Operators/Special_Operators/function_call">函数调用</a></td>
   <td>从左到右</td>
   <td><code>… (&nbsp;<var>…&nbsp;</var>)</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Optional_chaining">可选链（Optional chaining）</a></td>
   <td>从左到右</td>
   <td><code>?.</code></td>
  </tr>
  <tr>
   <td rowspan="1">19</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/new" title="JavaScript/Reference/Operators/Special_Operators/new_Operator">new</a>&nbsp;(无参数列表)</td>
   <td>从右到左</td>
   <td><code>new …</code></td>
  </tr>
  <tr>
   <td rowspan="2">18</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Increment" title="JavaScript/Reference/Operators/Arithmetic_Operators">后置递增</a>(运算符在后)</td>
   <td colspan="1" rowspan="2">n/a<br>
    &nbsp;</td>
   <td><code>… ++</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Decrement" title="JavaScript/Reference/Operators/Arithmetic_Operators">后置递减</a>(运算符在后)</td>
   <td><code>… --</code></td>
  </tr>
  <tr>
   <td colspan="1" rowspan="10">17</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Logical_Operators#Logical_NOT">逻辑非</a></td>
   <td colspan="1" rowspan="10">从右到左</td>
   <td><code>! …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators#Bitwise_NOT" title="JavaScript/Reference/Operators/Bitwise_Operators">按位非</a></td>
   <td><code>~ …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Unary_plus" title="JavaScript/Reference/Operators/Arithmetic_Operators">一元加法</a></td>
   <td><code>+ …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Unary_negation" title="JavaScript/Reference/Operators/Arithmetic_Operators">一元减法</a></td>
   <td><code>- …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Increment" title="JavaScript/Reference/Operators/Arithmetic_Operators">前置递增</a></td>
   <td><code>++ …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Decrement" title="JavaScript/Reference/Operators/Arithmetic_Operators">前置递减</a></td>
   <td><code>-- …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/typeof" title="JavaScript/Reference/Operators/Special_Operators/typeof_Operator">typeof</a></td>
   <td><code>typeof …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/void" title="JavaScript/Reference/Operators/Special_Operators/void_Operator">void</a></td>
   <td><code>void …</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/delete" title="JavaScript/Reference/Operators/Special_Operators/delete_Operator">delete</a></td>
   <td><code>delete …</code></td>
  </tr>
  <tr>
   <td><a href="/en-US/docs/Web/JavaScript/Reference/Operators/await">await</a></td>
   <td><code>await …</code></td>
  </tr>
  <tr>
   <td>16</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Exponentiation" title="JavaScript/Reference/Operators/Arithmetic_Operators">幂</a></td>
   <td>从右到左</td>
   <td><code>…&nbsp;**&nbsp;…</code></td>
  </tr>
  <tr>
   <td rowspan="3">15</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Multiplication" title="JavaScript/Reference/Operators/Arithmetic_Operators">乘法</a></td>
   <td colspan="1" rowspan="3">从左到右<br>
    &nbsp;</td>
   <td><code>… *&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Division" title="JavaScript/Reference/Operators/Arithmetic_Operators">除法</a></td>
   <td><code>… /&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Remainder" title="JavaScript/Reference/Operators/Arithmetic_Operators">取模</a></td>
   <td><code>… %&nbsp;…</code></td>
  </tr>
  <tr>
   <td rowspan="2">14</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Addition" title="JavaScript/Reference/Operators/Arithmetic_Operators">加法</a></td>
   <td colspan="1" rowspan="2">从左到右<br>
    &nbsp;</td>
   <td><code>… +&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Arithmetic_Operators#Subtraction" title="JavaScript/Reference/Operators/Arithmetic_Operators">减法</a></td>
   <td><code>… -&nbsp;…</code></td>
  </tr>
  <tr>
   <td rowspan="3">13</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators" title="JavaScript/Reference/Operators/Bitwise_Operators">按位左移</a></td>
   <td colspan="1" rowspan="3">从左到右</td>
   <td><code>… &lt;&lt;&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators" title="JavaScript/Reference/Operators/Bitwise_Operators">按位右移</a></td>
   <td><code>… &gt;&gt;&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators" title="JavaScript/Reference/Operators/Bitwise_Operators">无符号右移</a></td>
   <td><code>… &gt;&gt;&gt;&nbsp;…</code></td>
  </tr>
  <tr>
   <td rowspan="6">12</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Less_than_operator" title="JavaScript/Reference/Operators/Comparison_Operators">小于</a></td>
   <td colspan="1" rowspan="6">从左到右</td>
   <td><code>… &lt;&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Less_than__or_equal_operator" title="JavaScript/Reference/Operators/Comparison_Operators">小于等于</a></td>
   <td><code>… &lt;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/en-US/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Greater_than_operator" title="JavaScript/Reference/Operators/Comparison_Operators">大于</a></td>
   <td><code>… &gt;&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Greater_than_or_equal_operator" title="JavaScript/Reference/Operators/Comparison_Operators">大于等于</a></td>
   <td><code>… &gt;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/in" title="JavaScript/Reference/Operators/Special_Operators/in_Operator">in</a></td>
   <td><code>… in&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/instanceof" title="JavaScript/Reference/Operators/Special_Operators/instanceof_Operator">instanceof</a></td>
   <td><code>… instanceof&nbsp;…</code></td>
  </tr>
  <tr>
   <td rowspan="4">11</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Equality" title="JavaScript/Reference/Operators/Comparison_Operators">等号</a></td>
   <td colspan="1" rowspan="4">从左到右<br>
    &nbsp;</td>
   <td><code>… ==&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Inequality" title="JavaScript/Reference/Operators/Comparison_Operators">非等号</a></td>
   <td><code>… !=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Identity" title="JavaScript/Reference/Operators/Comparison_Operators">全等号</a></td>
   <td><code>… ===&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comparison_Operators#Nonidentity" title="JavaScript/Reference/Operators/Comparison_Operators">非全等号</a></td>
   <td><code>… !==&nbsp;…</code></td>
  </tr>
  <tr>
   <td>10</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators#Bitwise_AND" title="JavaScript/Reference/Operators/Bitwise_Operators">按位与</a></td>
   <td>从左到右</td>
   <td><code>… &amp;&nbsp;…</code></td>
  </tr>
  <tr>
   <td>9</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators#Bitwise_XOR" title="JavaScript/Reference/Operators/Bitwise_Operators">按位异或</a></td>
   <td>从左到右</td>
   <td><code>… ^&nbsp;…</code></td>
  </tr>
  <tr>
   <td>8</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Bitwise_Operators#Bitwise_OR" title="JavaScript/Reference/Operators/Bitwise_Operators">按位或</a></td>
   <td>从左到右</td>
   <td><code>… |&nbsp;…</code></td>
  </tr>
  <tr>
   <td>7</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Logical_Operators#Logical_AND" title="JavaScript/Reference/Operators/Logical_Operators">逻辑与</a></td>
   <td>从左到右</td>
   <td><code>… &amp;&amp;&nbsp;…</code></td>
  </tr>
  <tr>
   <td>6</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Logical_Operators#Logical_OR" title="JavaScript/Reference/Operators/Logical_Operators">逻辑或</a></td>
   <td>从左到右</td>
   <td><code>… ||&nbsp;…</code></td>
  </tr>
  <tr>
   <td>5</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Nullish_coalescing_operator" title="JavaScript/Reference/Operators/Nullish_coalescing_operator">空值合并</a></td>
   <td>从左到右</td>
   <td><code>… ?? …</code></td>
  </tr>
  <tr>
   <td>4</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Conditional_Operator" title="JavaScript/Reference/Operators/Special_Operators/Conditional_Operator">条件运算符</a></td>
   <td>从右到左</td>
   <td><code>… ? … : …</code></td>
  </tr>
  <tr>
   <td rowspan="16">3</td>
   <td rowspan="16"><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Assignment_Operators" title="JavaScript/Reference/Operators/Assignment_Operators">赋值</a></td>
   <td rowspan="16">从右到左</td>
   <td><code>… =&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… +=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… -=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… **=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… *=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… /=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… %=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… &lt;&lt;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… &gt;&gt;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… &gt;&gt;&gt;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… &amp;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… ^=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… |=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… &amp;&amp;=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… ||=&nbsp;…</code></td>
  </tr>
  <tr>
   <td><code>… ??=&nbsp;…</code></td>
  </tr>
  <tr>
   <td colspan="1" rowspan="2">2</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/yield" title="JavaScript/Reference/Operators/yield">yield</a></td>
   <td colspan="1" rowspan="2">从右到左</td>
   <td><code>yield&nbsp;…</code></td>
  </tr>
  <tr>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/yield*" title="JavaScript/Reference/Operators/yield">yield*</a></td>
   <td><code>yield*&nbsp;…</code></td>
  </tr>
  <tr>
   <td>1</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Spread_operator" title="JavaScript/Reference/Operators/Spread_operator">展开运算符</a></td>
   <td>n/a</td>
   <td><code>...</code>&nbsp;…</td>
  </tr>
  <tr>
   <td>0</td>
   <td><a href="/zh-CN/docs/Web/JavaScript/Reference/Operators/Comma_Operator" title="JavaScript/Reference/Operators/Comma_Operator">逗号</a></td>
   <td>从左到右</td>
   <td><code>… ,&nbsp;…</code></td>
  </tr>
 </tbody>
</table>

  

