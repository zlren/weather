package lab.zlren.weather.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zlren
 * @date 2018-01-31
 */
@SpringBootApplication
@EnableEurekaServer
public class WeatherEurekaServerApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherEurekaServerApp.class);
    }
}
