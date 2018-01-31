package lab.zlren.weather.report.controller;

import lab.zlren.weather.report.service.zuul.CityClient;
import lab.zlren.weather.report.service.zuul.WeatherApiClient;
import lab.zlren.weather.report.vo.CityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * WeatherReportController
 *
 * @author zlren
 * @date 2018-01-29
 */
@Controller
@RequestMapping("report")
public class WeatherReportController {

    @Autowired
    private WeatherApiClient weatherApiClient;

    @Autowired
    private CityClient cityClient;

    @GetMapping("cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) {

        CityList cityList = cityClient.getCityList();

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList.getCityList());
        model.addAttribute("report", weatherApiClient.getWeatherByCityId(cityId).getData());

        return new ModelAndView("weather/report", "reportModel", model);
    }
}
