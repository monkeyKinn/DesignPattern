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
