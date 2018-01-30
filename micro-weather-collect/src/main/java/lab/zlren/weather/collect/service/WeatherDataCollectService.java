package lab.zlren.weather.collect.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 天气同步服务
 *
 * @author zlren
 * @date 2018-01-30
 */
@Service
@Slf4j
public class WeatherDataCollectService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 根据城市id同步（下载）数据
     *
     * @param cityId 城市id
     */
    public void syncDataByCityId(String cityId) {

        String strBody = null, url = WEATHER_URI + "citykey=" + cityId;

        ResponseEntity<String> respString = restTemplate.getForEntity(url, String.class);
        if (respString.getStatusCode().is2xxSuccessful()) {
            strBody = respString.getBody();
        }

        // 缓存起来
        stringRedisTemplate.opsForValue().set("weather:" + url, strBody);
    }
}
