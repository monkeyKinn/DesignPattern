# 由一只鸭子引发的模式---策略模式

<div style="text-align:right">作者:<font color="brown">故事我忘了<sup>￠</sup></font><br/>个人微信公众号:<font color="blue">程序猿的月光宝盒</font><br/><img src="http://blog-cc.nos-eastchina1.126.net/0c89c806-7e3d-41c5-9d72-84dcecaec490"  width="15%"/></div><hr>

> 不算是教程,充其量(本来就)是个笔 ji叭,但也希望不会浪费你的阅读时间~
>
> ----------------------------------[Head First 设计模式] 笔记

前置知识:

需要了解java的:

1.封装

2.继承

3.多态

4.抽象

前三也称为java的三大特性



**Demo描述：（OO原则解决方式）**

一只未知品种的鸭子,众所周知,所有鸭子都会游泳(春江水暖鸭先知),有的鸭子会飞(玩具鸭,绑上飞行器/本来就会飞,方式不同),有的鸭子会叫(玩具鸭也会叫,只是叫声不同)

第一反应其实就是用继承的方法,本来嘛,都是鸭子,都会飞,都会叫,个别的让子类重写不就完了吗

但是,老金要说但是了.假设,我作为小丑鸭子类,我本来就不需要会飞,我也不想飞,为什么你要让我实现对应的飞的功能,要飞天空任你飞,大不了伤痛我来背

**这里就引出了第一个设计原则:**

### 一.开闭原则

> 找出应用中可能需要改变的地方,把他们独立出来,不要和那些不需要变化的混在一起
>
>
>
> 对修改关闭,对拓展开放





那么在程序中,怎么用设计模式实现这一场景呢?

## 0. 整体类图

首先我们来看一下整体的UML类图,这个类图是用idea自动生成的,默认快捷键是..我百度一下,嗯  ,还是我的这篇博客 [idea快捷键](https://www.cnblogs.com/jsccc520/p/13463607.html) 里面写了

> ctrl+shift+alt+u

我们来试一下:

![图片](http://blog-cc.nos-eastchina1.126.net/581db4f9-b72c-411a-b41b-b8b98039d040)

由上可知,有个MallardDuck(绿头鸭) 继承于 鸭子父类,而这个父类里面仅仅是只有对应的行为属性,对应的行为属性也是个接口,具体类图如下:

![图片](http://blog-cc.nos-eastchina1.126.net/1ca55c9e-34fd-490c-9de8-f4fe477bf11f)

![图片](http://blog-cc.nos-eastchina1.126.net/ba086aa7-d36a-4fb3-a76b-8f14d31dd8f6)



> **这样的设计,可以让飞行和呱呱叫的动作被其他对象复用,因为这些行为已经跟鸭子无关了.**
>
>
>
> **而我们能新增一些行为,不会影响到已经有的行为类,也不会影响使用了已经存在的行为的具体鸭子类**



这里用到了两个设计原则:

### 二.**依赖倒转原则**

> 依赖于抽象的类,而不要依赖于具体的类;
>
> 针对接口或抽象类编程 ,而不是针对具体类编程

### 三. 组合/聚合复用原则

> 多用组合,少用继承



好了 我们上代码

## 1. 具体代码

### 1.1 关于鸭子

#### 1.1.1 鸭子父类: ``Duck.java``

```java
package firstDuck.duck;

import firstDuck.behavior.IFlyBehavior;
import firstDuck.behavior.IQuackBehavior;

/**
 * 鸭子父类(抽象)
 */
public abstract class Duck {
    /** 飞的行为 定义为接口,在运行时,持有特定行为的引用*/
    protected IFlyBehavior iFlyBehavior;
    /** 叫的行为 也是被定义为接口*/
    protected IQuackBehavior iQuqBehavior;


    public Duck() {
    }

    /**
     * 调用飞的行为去飞
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:25
     */
    public void doFly() {
        this.iFlyBehavior.fly();
    }

    /**
     * 调用叫的行为去叫
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:25
     */
    public void doQuack() {
        this.iQuqBehavior.quack();
    }

    /**
     * 显示外观 相当于toString
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 22:54
     */
    public abstract void display();

    public void swim() {
        System.out.println("所有的鸭子都会浮在水面上~");
    }
}

```

#### 1.1.2 鸭子子类(可以有很多这里举例1) ``MallardDuck.java``

```java
package firstDuck.duck.duckSon;

import firstDuck.behavior.impl.FlyWithWings;
import firstDuck.behavior.impl.Quack;
import firstDuck.duck.Duck;

/**
 * 绿头鸭
 *
 * @author 金聖聰
 * @email jinshengcong@163.com
 * @version v1.0
 * @date 2021/01/13 22:55
 */
public class MallardDuck extends Duck {

    /**
     * 绿头鸭构造器
     *
     * @return null
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:35
     */
    public MallardDuck() {
        /* 绿头鸭调用Quack类处理正真的呱呱叫 */
        super.iQuqBehavior = new Quack();
        /* 绿头鸭调用FlyWithWings类处理正真的飞行 */
        super.iFlyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("我是一个真正的绿头鸭");
    }
}

```

### 1.2 关于行为

#### 1.2.1 飞行的行为 ``IFlyBehavior.java``

这是一个接口,所有飞行类都实现他,所有的飞行类都必须实现fly()方法

```java
package firstDuck.behavior;

/**
 * 飞行的行为
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public interface IFlyBehavior {
    /**
     * 飞行
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:11
     */
    void fly();
}
```

##### 1.2.1.1 飞行行为的实现类 ``FlyNoWay.java``

```java
package firstDuck.behavior.impl;

import firstDuck.behavior.IFlyBehavior;

/**
 * 不能飞
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class FlyNoWay implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不能飞啊喂~");
    }
}

```

##### 1.2.1.2 飞行行为的实现类 ``FlyWithWings.java``

```java
package firstDuck.behavior.impl;

import firstDuck.behavior.IFlyBehavior;

/**
 * 翅膀飞
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class FlyWithWings implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("用翅膀飞~");
    }
}

```

#### 1.2.2 叫的行为 `` IQuackBehavior.java``

叫的行为也一样,所有叫的类都实现他,所有的会叫的类都必须实现quack()方法

```java
package firstDuck.behavior;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public interface IQuackBehavior {
    /**
     * 叫
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:11
     */
    void quack();
}

```

##### 1.2.2.1 叫的行为的实现类 `` Quack.java``

```java
package firstDuck.behavior.impl;

import firstDuck.behavior.IQuackBehavior;

/**
 * 鸭子嘎嘎叫
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Quack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("我真鸭子,我嘎嘎叫~");
    }
}

```

##### 1.2.2.2  叫的行为的实现类 `` Squeak.java``

```java
package firstDuck.behavior.impl;

import firstDuck.behavior.IQuackBehavior;

/**
 * 橡皮鸭子吱吱叫
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Squeak implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("我橡皮鸭子,我吱吱叫~");
    }
}

```

##### 1.2.2.3 叫的行为的实现类 `` Squeak.java``

```java
package firstDuck.behavior.impl;

import firstDuck.behavior.IQuackBehavior;

/**
 * 哑巴鸭不会叫
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class MuteQuack implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("我不会叫~~");
    }
}

```

### 1.3 测试类

```java
package firstDuck.test;

import firstDuck.duck.Duck;
import firstDuck.duck.duckSon.MallardDuck;

/**
 * 迷你鸭子模拟器 测试类
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        /* 绿头鸭 */
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.doFly();
        mallard.doQuack();
    }
}

```

输出:

![图片](http://blog-cc.nos-eastchina1.126.net/a4cca676-1f03-49bd-95c3-9ddabf6324a4)

所以,绿头鸭会真的嘎嘎叫,因为,在构造实例时,构造器会把继承来的``iQuqBehavior``初始化成Quack类型的新实例,

同样的处理方式也用在飞行行为上

## 3. 思考一下

在绿头鸭的构造器中,这里是在干啥

```java
public MallardDuck() {
        /* 绿头鸭调用Quack类处理正真的呱呱叫 */
        super.iQuqBehavior = new Quack();
        /* 绿头鸭调用FlyWithWings类处理正真的飞行 */
        super.iFlyBehavior = new FlyWithWings();
    }
```

根据开头引出的设计原则之依赖倒转原则,不是应该针对接口编程吗,这里怎么又针对实现编程了,你在构造一个具体的叫的行为和飞的行为的实现类啊哥?靠谱一点啊老金~

行,谁说我不靠谱老子锤爆你的头~[doeg保命.gif]

一步一步来吗~

刚开始在鸭子类里建立了一堆动态行为属性(其实就俩)没有用到嘛~现在用一下咯~

#### 3.1 改造开始:

##### 3.1.1 首先是鸭子类``Duck.java``

```java
package firstDuck.duck;

import firstDuck.behavior.IFlyBehavior;
import firstDuck.behavior.IQuackBehavior;

/**
 * 鸭子父类(抽象)
 */
public abstract class Duck {
    /** 飞的行为 定义为接口,在运行时,持有特定行为的引用*/
    protected IFlyBehavior iFlyBehavior;
    /** 叫的行为 也是被定义为接口*/
    protected IQuackBehavior iQuqBehavior;

    /**
     * 新增飞行的setter方法
     * @param iFlyBehavior 飞的行为
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/18 23:50
     */
    public void setiFlyBehavior(IFlyBehavior iFlyBehavior) {
        this.iFlyBehavior = iFlyBehavior;
    }

    /**
     * 新增叫的setter方法
     * @param iQuqBehavior 叫的行为
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/18 23:51
     */
    public void setiQuqBehavior(IQuackBehavior iQuqBehavior) {
        this.iQuqBehavior = iQuqBehavior;
    }

    public Duck() {
    }

    /**
     * 调用飞的行为去飞
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:25
     */
    public void doFly() {
        this.iFlyBehavior.fly();
    }

    /**
     * 调用叫的行为去叫
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 23:25
     */
    public void doQuack() {
        this.iQuqBehavior.quack();
    }

    /**
     * 显示外观 相当于toString
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/13 22:54
     */
    public abstract void display();

    public void swim() {
        System.out.println("所有的鸭子都会浮在水面上~");
    }
}

```

也就是新增两个setter方法,动态设置成员变量

从此以后,我们可以随时动态调用这两个方法改变鸭子的行为,就相当于脑子里植入了芯片,被人为所欲为~啧啧啧

测一下测一下

##### 3.1.2 然后是新建子类`` ModelDuck.java``



````java
package firstDuck.duck.duckSon;

import firstDuck.behavior.impl.FlyNoWay;
import firstDuck.behavior.impl.MuteQuack;
import firstDuck.duck.Duck;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class ModelDuck extends Duck {
    public ModelDuck(){
        /* 一开始不会飞  */
        super.iFlyBehavior = new FlyNoWay();
        /* 一开始不会叫  */
        super.iQuqBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是模型鸭子");
    }
}

````

##### 3.1.3 新建一个飞行行为让火箭飞!`` FlyByRocket.java``

````java
package firstDuck.behavior.impl;

import firstDuck.behavior.IFlyBehavior;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class FlyByRocket implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("插了火箭了,上天,冲干饭鸭~");
    }
}

````

##### 3.1.4 修改测试类

````java
package firstDuck.test;

import firstDuck.behavior.impl.FlyByRocket;
import firstDuck.duck.Duck;
import firstDuck.duck.duckSon.MallardDuck;
import firstDuck.duck.duckSon.ModelDuck;

/**
 * 迷你鸭子模拟器 测试类
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        /* 绿头鸭 */
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.doFly();
        mallard.doQuack();
        System.out.println();
        System.out.println("-----------改造后------------");
        Duck modelDuck = new ModelDuck();
        modelDuck.display();
        modelDuck.doQuack();
        modelDuck.doFly();
        /* 一开始是不会飞的,直到我给他插了火箭,摇身一变冲天干饭鸭  */
        modelDuck.setiFlyBehavior(new FlyByRocket());
        /* 现在插了火箭了,看看阿能飞了 */
        modelDuck.doFly();
    }
}

````

运行结果:

![图片](http://blog-cc.nos-eastchina1.126.net/f9b0b356-e472-4278-a3d8-9239ba5cd495)

好了,恭喜~get策略模式

那最终官方的策略模式定义是什么呢?背下来,适合装逼~



> 定义了算法族,分别封装起来,让他们之间可以互相替换,此模式让算法的变化独立于使用算法(行为)的客户

怎么背啊,淦?

算法族想像成刚才的飞行方式,有这么多飞行方式需要用,是不是定义了一个接口用来封装?然后具体用的时候只要new具体的行为方式到setter方法里就能动态改变了?具体的模型鸭子还是不会飞吧,插火箭这个动作是你插的吧,你能插,也能拔吧?

我没有开车,get out~



所以上边的助记就是

``定义了算法族(行为方式),分别封装起来(做成接口),让他们之间可以互相替换(动态set调用),此模式让算法(行为)的变化独立于使用算法(行为)的客户``

##  总结一下:

### 设计原则:

#### 1.开闭原则

对修改关闭,对拓展开放,找出程序中变化的部分,封装独立出来

#### 2.依赖倒转

依赖于抽象,而不依赖于具体;

针对接口/抽象编程,不针对具体类编程

#### 3.组合复用

多用组合,少用继承



#### 4.策略模式定义

定义了算法族,分别封装起来,以让他们可以互相替换,此模式可以让算法的变化独立于使用算法的客户