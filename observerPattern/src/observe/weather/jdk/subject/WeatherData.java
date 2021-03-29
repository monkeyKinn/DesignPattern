package observe.weather.jdk.subject;

import java.util.Observable;

public class WeatherData extends Observable {
    /** 温度 */
    private float temperature;
    /** 湿度 */
    private float humidity;
    /** 气压 */
    private float pressure;

    public WeatherData() { }

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
        // 表示状态已经改变
        setChanged();
        notifyObservers();
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
