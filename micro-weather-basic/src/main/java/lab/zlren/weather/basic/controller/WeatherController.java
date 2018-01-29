package lab.zlren.weather.basic.controller;

import lab.zlren.weather.basic.vo.WeatherResponse;
import lab.zlren.weather.basic.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WeatherController
 *
 * @author zlren
 * @date 2018-01-29
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * 根据城市id查询天气数据
     *
     * @param cityId 城市id
     * @return 天气数据
     */
    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable String cityId) {
        return weatherService.getDataByCityId(cityId);
    }

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName 城市名称
     * @return 天气数据
     */
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable String cityName) {
        return weatherService.getDataByCityName(cityName);
    }
}
