package lab.zlren.weather.report.service.direct;

import lab.zlren.weather.report.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 调用WeatherApi微服务获取数据
 *
 * @author zlren
 * @date 2018-01-31
 */
@FeignClient("weather-collect")
public interface WeatherApiClient {

    /**
     * 根据城市id查询天气数据
     *
     * @param cityId 城市id
     * @return 天气数据
     */
    @GetMapping("/api/cityId/{cityId}")
    WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName 城市名称
     * @return 天气数据
     */
    @GetMapping("/api/cityName/{cityName}")
    WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName);
}
