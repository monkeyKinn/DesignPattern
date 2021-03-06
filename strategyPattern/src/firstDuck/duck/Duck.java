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
