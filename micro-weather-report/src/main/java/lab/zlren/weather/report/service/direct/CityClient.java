package lab.zlren.weather.report.service.direct;

import lab.zlren.weather.report.vo.CityList;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过feign以及服务提供者的appName注解调用
 *
 * @author zlren
 * @date 2018-01-31
 */
@FeignClient("weather-city")
public interface CityClient {

    /**
     * 从城市微服务中获取城市列表
     *
     * @return 城市列表
     */
    @GetMapping("/cities")
    CityList getCityList();
}