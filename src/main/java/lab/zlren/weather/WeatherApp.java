package lab.zlren.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 天气App入口类
 *
 * @author zlren
 * @date 2018-01-29
 */
@SpringBootApplication
public class WeatherApp {
    public static void main(String[] args) {
        SpringApplication.run(WeatherApp.class, args);
    }
}
