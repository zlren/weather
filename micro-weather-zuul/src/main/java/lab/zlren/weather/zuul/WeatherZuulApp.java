package lab.zlren.weather.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 微服务网关
 *
 * @author zlren
 * @date 2018-01-31
 */
@SpringBootApplication
@EnableZuulProxy
public class WeatherZuulApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherZuulApp.class, args);
    }
}
