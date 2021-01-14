package firstDuck.duck;

import firstDuck.behavior.IFlyBehavior;
import firstDuck.behavior.IQuackBehavior;

/**
 * 鸭子父类(抽象)
 */
public abstract class Duck {
    /** 飞的行为 */
    protected IFlyBehavior iFlyBehavior;
    /** 叫的行为 */
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
