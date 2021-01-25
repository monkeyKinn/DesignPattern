package observe.weather.self.subject;


import observe.weather.self.observer.Observer;

/**
 * 主题接口
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public interface Subject {
    /**
     * 注册观察者
     * @param observer 需要注册的观察者
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/25 23:32
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer 需要移除的观察者
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/25 23:32
     */
    void removeObserver(Observer observer);

    /**
     * 当主题改变时,通知所有的观察者
     *
     * @return void
     * @author 金聖聰
     * @email jinshengcong@163.com
     * @version v1.0
     * @date 2021/01/25 23:24
     */
    void notifyObservers();
}
