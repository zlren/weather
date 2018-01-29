package lab.zlren.weather.basic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab.zlren.weather.basic.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * 获取天气数据服务
 *
 * @author zlren
 * @date 2018-01-29
 */
@Service
public class WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId 城市id
     * @return 天气数据
     */
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName 城市名称
     * @return 天气数据
     */
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }


    /**
     * 使用RestTemplate从天气API接口获取数据
     *
     * @param uri WEATHER_URI
     * @return 天气数据
     */
    private WeatherResponse doGetWeather(String uri) {

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        WeatherResponse weatherResponse = null;
        String strBody = null;

        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        try {
            weatherResponse = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherResponse;
    }
}
