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
