package lab.zlren.weather.collect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 天气同步服务
 *
 * @author zlren
 * @date 2018-01-29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WeatherCollectApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectApp.class, args);
    }
}
