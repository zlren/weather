package lab.zlren.weather.report.service.zuul;

import lab.zlren.weather.report.vo.CityList;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 通过zuul网关去调用其他微服务
 *
 * @author zlren
 * @date 2018-01-31
 */
@FeignClient("weather-zuul")
@Primary
public interface CityClient {

    /**
     * 从城市微服务中获取城市列表
     *
     * @return 城市列表
     */
    @GetMapping("/city/cities")
    CityList getCityList();
}
