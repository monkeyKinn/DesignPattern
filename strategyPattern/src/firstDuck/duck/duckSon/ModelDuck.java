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
