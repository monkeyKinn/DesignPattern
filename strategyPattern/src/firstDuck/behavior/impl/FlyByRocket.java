package firstDuck.behavior.impl;

import firstDuck.behavior.IFlyBehavior;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class FlyByRocket implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("插了火箭了,上天,冲干饭鸭~");
    }
}
