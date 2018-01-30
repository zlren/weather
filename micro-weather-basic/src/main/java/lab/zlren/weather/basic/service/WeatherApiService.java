package lab.zlren.weather.basic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.zlren.weather.basic.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public static final String WEATHER = "weather";

    /**
     * 使用RestTemplate从天气API接口获取数据
     *
     * @param uri WEATHER_URI
     * @return 天气数据
     */
    @Cacheable(value = WEATHER, key = "#uri", unless = "#result.status != 1000")
    public WeatherResponse getWeather(String uri) {

        log.info("拉取数据，uri是：{}", uri);

        String strBody = null;

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCode().is2xxSuccessful()) {
            strBody = respString.getBody();
        }

        WeatherResponse weatherResponse = null;

        try {
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        return weatherResponse;
    }
}
