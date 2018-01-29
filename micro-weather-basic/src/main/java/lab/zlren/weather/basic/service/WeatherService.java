package lab.zlren.weather.basic.service;

import lab.zlren.weather.basic.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 获取天气数据服务
 *
 * @author zlren
 * @date 2018-01-29
 */
@Service
@Slf4j
public class WeatherService {

    @Autowired
    private WeatherApiService weatherApiService;

    public static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId 城市id
     * @return 天气数据
     */
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return weatherApiService.getWeather(uri);
    }

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName 城市名称
     * @return 天气数据
     */
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return weatherApiService.getWeather(uri);
    }
}
