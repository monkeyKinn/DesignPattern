package observe.weather.jdk.observer;

import observe.weather.jdk.subject.WeatherData;
import observe.weather.self.display.DisplayElement;
import observe.weather.self.subject.Subject;

import java.util.Observable;
import java.util.Observer;

/**
 * 当前状况显示 布告板
 * 实现了 观察者接口,可以从WeatherData中获取改变
 * 实现了 布告板接口,api规定,以此来确定这是个布告板
 *
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
    Observable observable;

    public CurrentConditionsDisplay() {
    }

    /**
     * 有参构造布告板
     *
     * @param observable 气象数据
     * @return null
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/26 1:39
     */
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    public float getTemp() {
        return this.temp;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }

    public Observable getObservable() {
        return this.observable;
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData){
            WeatherData weatherData = (WeatherData) o;
            this.temp = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("当前显示:  温度为: "+ this.getTemp()+"℉, 湿度为: "+ this.getHumidity()+"%, 气压为: "+this.getPressure());
    }
}
