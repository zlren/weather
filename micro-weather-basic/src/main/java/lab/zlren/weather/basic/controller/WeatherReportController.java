package lab.zlren.weather.basic.controller;

import lab.zlren.weather.basic.service.WeatherReportService;
import lab.zlren.weather.basic.vo.CityList;
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
    private WeatherReportService weatherReportService;

    @Autowired
    private CityList cityList;

    @GetMapping("cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) {

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList.getCityList());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report", "reportModel", model);
    }
}
