package lab.zlren.weather.collect.job;

import lab.zlren.weather.collect.service.CityClient;
import lab.zlren.weather.collect.service.WeatherDataCollectService;
import lab.zlren.weather.collect.vo.City;
import lab.zlren.weather.collect.vo.CityList;
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
    private WeatherDataCollectService weatherDataCollectService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {

        log.info("任务同步开始");

        CityList cityList = cityClient.getCityList();

        try {
            for (City city : cityList.getCityList()) {
                log.info("正在同步天气数据，城市：{}", city.getCityName());
                // weatherDataCollectService.syncDataByCityId(city.getCityId());
                // Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        log.info("任务同步结束");
    }
}
