package observe.weather.self.observer;

/**
 * 所有的气象组件都实现此接口
 * 这样,主题在需要通知观察者时,就有了一个共同的接口
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public interface Observer {
    /**
     * 更新,当气象观测值改变时,
     * 主题会把这些状态值当作方法的参数,传给观察者,并调用观察者显示方法
     *
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/25 23:29
     */
    void update(float temp, float humidity, float pressure);
}
