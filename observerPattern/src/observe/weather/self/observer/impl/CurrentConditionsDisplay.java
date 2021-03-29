package observe.weather.self.observer.impl;

import observe.weather.self.display.DisplayElement;
import observe.weather.self.observer.Observer;
import observe.weather.self.subject.Subject;

/**
 * 当前状况显示 布告板
 * 实现了 观察者接口,可以从WeatherData中获取改变
 * 实现了 布告板接口,api规定,以此来确定这是个布告板
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    /** 温度 */
    private float temp;
    /** 湿度 */
    private float humidity;
    /** 气压 */
    private float pressure;

    /** 天气数据,类型为WeatherData的接口类 */
    private Subject weatherData;

    public CurrentConditionsDisplay(){}

    /**
     * 有参构造布告板
     * @param weatherData 气象数据
     * @return null
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/26 1:39
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        // 把自己注册到观察者里去
        this.weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前显示:  温度为: "+ this.getTemp()+"℉, 湿度为: "+ this.getHumidity()+"%, 气压为: "+this.getPressure());
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        // 调用时候把数据存起来,然后用display显示
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.display();
    }

    public float getTemp() {
        return this.temp;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public Subject getWeatherData() {
        return this.weatherData;
    }

    public float getPressure() {
        return this.pressure;
    }

}
