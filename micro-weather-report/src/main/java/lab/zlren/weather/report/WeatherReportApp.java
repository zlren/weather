package lab.zlren.weather.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 天气预报服务
 *
 * @author zlren
 * @date 2018-01-29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WeatherReportApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherReportApp.class, args);
    }
}
