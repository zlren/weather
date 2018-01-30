package lab.zlren.weather.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.zlren.weather.api.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * WeatherAPI
 *
 * @author zlren
 * @date 2018-01-29
 */
@Service
@Slf4j
public class WeatherApiService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 从redis中获取数据，如果没有直接报异常
     *
     * @param uri WEATHER_URI
     * @return 天气数据
     */
    public WeatherResponse getWeather(String uri) {

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
