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
