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
