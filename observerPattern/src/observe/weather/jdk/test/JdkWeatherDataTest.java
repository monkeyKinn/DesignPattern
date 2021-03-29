package observe.weather.jdk.test;

import observe.weather.jdk.observer.CurrentConditionsDisplay;
import observe.weather.jdk.subject.WeatherData;

/**
 * TODO description
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 * @date Created in 2021/03/29 15:31
 */
public class JdkWeatherDataTest {
    public static void main(String[] args) {
        // 1. 建立一个weatherData对象
        WeatherData weatherData = new WeatherData();
        // 2. 匿名创建当前显示的布告板
        new CurrentConditionsDisplay(weatherData);
        // 3.更新气象数据,观察布告板是否更新
        // weatherData.setMeasurements(36.7F,10F,100F);
        weatherData.setMeasurements(1009.7F,100F,0F);
    }
}
