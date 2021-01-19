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
