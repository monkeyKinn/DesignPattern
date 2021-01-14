package firstDuck.behavior.impl;

import firstDuck.behavior.IQuackBehavior;

/**
 * 橡皮鸭子吱吱叫
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Squeak implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("我橡皮鸭子,我吱吱叫~");
    }
}
