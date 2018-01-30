package lab.zlren.weather.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 天气查询服务
 *
 * @author zlren
 * @date 2018-01-29
 */
@SpringBootApplication
public class WeatherApiApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApiApp.class, args);
    }
}
