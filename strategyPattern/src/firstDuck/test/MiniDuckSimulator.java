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
