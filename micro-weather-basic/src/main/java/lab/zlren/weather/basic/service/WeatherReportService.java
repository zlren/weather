package lab.zlren.weather.basic.service;

import lab.zlren.weather.basic.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zlren
 * @date 2018-01-29
 */
@Service
public class WeatherReportService {

    @Autowired
    private WeatherService weatherService;

    /**
     * 根据城市id获取
     *
     * @param cityId 城市id
     * @return Weather
     */
    public Weather getDataByCityId(String cityId) {
        return weatherService.getDataByCityId(cityId).getData();
    }
}
