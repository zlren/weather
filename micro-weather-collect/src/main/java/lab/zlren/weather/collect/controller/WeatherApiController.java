package lab.zlren.weather.collect.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.zlren.weather.collect.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 天气数据API
 *
 * @author zlren
 * @date 2018-01-31
 */
@RestController
public class WeatherApiController {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId 城市id
     * @return 天气数据
     */
    @GetMapping("cityId/{cityId}")
    public WeatherResponse getDataByCityId(@PathVariable String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return getWeather(uri);
    }

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName 城市名称
     * @return 天气数据
     */
    @GetMapping("cityName/{cityName}")
    public WeatherResponse getDataByCityName(@PathVariable String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return getWeather(uri);
    }

    /**
     * 从redis中获取数据，如果没有直接报异常
     *
     * @param uri WEATHER_URI
     * @return 天气数据
     */
    private WeatherResponse getWeather(String uri) {

        String key = "weather:" + uri;

        if (stringRedisTemplate.hasKey(key)) {
            String s = stringRedisTemplate.opsForValue().get(key);
            try {
                return objectMapper.readValue(s, WeatherResponse.class);
            } catch (IOException e) {
                throw new RuntimeException("服务端异常");
            }
        }

        throw new RuntimeException("查询的服务不存在");
    }
}
