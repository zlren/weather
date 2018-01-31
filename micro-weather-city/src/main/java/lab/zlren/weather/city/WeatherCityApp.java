package lab.zlren.weather.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zlren
 * @date 2018-01-29
 */
@SpringBootApplication
@EnableEurekaClient
public class WeatherCityApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCityApp.class, args);
    }
}
