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
