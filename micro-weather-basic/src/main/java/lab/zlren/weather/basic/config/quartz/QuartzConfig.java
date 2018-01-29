package lab.zlren.weather.basic.config.quartz;

import lab.zlren.weather.basic.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置定时任务
 *
 * @author zlren
 * @date 2018-01-29
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJobDetail").storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger() {

        // 半个小时一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1800)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
