package lab.zlren.weather.basic.job;

import lab.zlren.weather.basic.service.WeatherApiService;
import lab.zlren.weather.basic.service.WeatherService;
import lab.zlren.weather.basic.vo.City;
import lab.zlren.weather.basic.vo.CityList;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

/**
 * 数据自动同步
 *
 * @author zlren
 * @date 2018-01-29
 */
@Slf4j
@Service
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityList cityList;

    @Autowired
    private WeatherApiService weatherApiService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {

        log.info("任务同步开始");


        // TODO 为什么每次启动都会去同步，上次的缓存如果没有失效呢？？

        try {
            for (City city : cityList.getCityList()) {
                log.info("正在同步天气数据，城市：{}", city.getCityName());
                weatherApiService.getWeather(WeatherService.WEATHER_URI + "citykey=" + city.getCityId());
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        log.info("任务同步结束");
    }
}
