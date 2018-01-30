package lab.zlren.weather.report.controller;

import lab.zlren.weather.report.service.WeatherReportService;
import lab.zlren.weather.report.vo.City;
import lab.zlren.weather.report.vo.CityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable String cityId, Model model) {

        // TODO 改为由城市数据微服务来提供数据
        CityList cityList = new CityList();
        List<City> list = new ArrayList<>();
        list.add(new City().setCityCode("101280101").setCityId("101280101").setCityName("广州").setProvince("广东"));
        cityList.setCityList(list);

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList.getCityList());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report", "reportModel", model);
    }
}
