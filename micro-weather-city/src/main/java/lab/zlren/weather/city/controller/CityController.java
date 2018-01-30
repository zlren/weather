package lab.zlren.weather.city.controller;

import lab.zlren.weather.city.vo.CityList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取城市列表
 *
 * @author zlren
 * @date 2018-01-30
 */
@RestController
@RequestMapping("cities")
@Slf4j
public class CityController {

    @Autowired
    private CityList cityList;

    /**
     * 获取城市列表
     *
     * @return cityList
     */
    @GetMapping
    public CityList getCityList() {
        return cityList;
    }
}
