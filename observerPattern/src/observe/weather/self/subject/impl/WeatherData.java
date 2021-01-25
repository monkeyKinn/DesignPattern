package observe.weather.self.subject.impl;


import observe.weather.self.observer.Observer;
import observe.weather.self.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    /** 用来记录观察者,在构造器中实例化 */
    private List<Observer> observerList;
    /** 温度 */
    private float temperature;
    /** 湿度 */
    private float humidity;
    /** 气压 */
    private float pressure;

    public WeatherData() {
        // 创建观察者数组,用来记录观察者
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        // 既然是注册就是加到观察者的数组里
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        // 在移除之前,判断有没有
        // indexOf 返回列表中第一次出现该元素的索引,如果没有就返回-1
        int num = observerList.indexOf(observer);
        if (num < 0) {
            // 没有就啥也不做
            return;
        }
        // 有的话就移除
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        // 把状态告诉每一个观察者,因为观察者都实现了update()方法,所以我们就调用这个方法就能通知到他
        // 循环遍历观察者数组对象
        for (Observer observer : observerList) {
            // 通知每个观察者
            observer.update(this.getTemperature(), this.getHumidity(), this.getPressure());
        }
    }

    /**
     * 气象测量值更新后,就会调用这个方法,这个方法去调用接口的更新观察者方法
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/25 23:43
     */
    public void measurementsChanged() {
        this.notifyObservers();
    }

    /**
     * 设定测量值,用来模拟气象站
     *
     * @param temperature 温度
     * @param humidity    湿度
     * @param pressure    气压
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/25 23:42
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        // 测量值更新 调用此类中的方法
        this.measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
