package observe.weather.self.test;

import observe.weather.self.observer.Observer;
import observe.weather.self.observer.impl.CurrentConditionsDisplay;
import observe.weather.self.subject.Subject;
import observe.weather.self.subject.impl.WeatherData;

/**
 * description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class WeatherStation {
    public static void main(String[] args) {
        // 1. 建立一个weatherData对象
        WeatherData weatherData = new WeatherData();
        // 2. 匿名创建当前显示的布告板
        new CurrentConditionsDisplay(weatherData);
        // 3.更新气象数据,观察布告板是否更新
        weatherData.setMeasurements(36.7F,10F,100F);
        weatherData.setMeasurements(16.7F,100F,0F);
    }
}
