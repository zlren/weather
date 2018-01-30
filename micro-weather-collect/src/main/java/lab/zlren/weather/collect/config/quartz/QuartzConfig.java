package lab.zlren.weather.collect.config.quartz;

import lab.zlren.weather.collect.job.WeatherDataSyncJob;
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

    /**
     * JobDetail
     *
     * @return JobDetail
     */
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJobDetail").storeDurably().build();
    }

    /**
     * Trigger
     *
     * @return Trigger
     */
    @Bean
    public Trigger weatherDataSyncTrigger() {

        // 半个小时一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1800 * 2)
                .repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
