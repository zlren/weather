package lab.zlren.weather.collect.service;

import lab.zlren.weather.collect.vo.CityList;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 城市微服务客户端
 *
 * @author zlren
 * @date 2018-01-31
 */
@FeignClient("weather-zuul")
public interface CityClient {

    /**
     * 从城市微服务中获取城市列表
     *
     * @return 城市列表
     */
    @GetMapping("/city/cities")
    CityList getCityList();
}
