package lab.zlren.weather.basic.config.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * CacheConfig
 *
 * @author zlren
 * @date 2018-01-29
 */
@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * 天气数据过期时间60秒
     */
    private static final long WEATHER_TIME_OUT = 600;

    /**
     * 自定义缓存相关参数
     *
     * @return cacheManager
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {

        RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(factory);

        // 默认60秒失效
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        cacheConfig = cacheConfig.entryTtl(Duration.ofSeconds(60));

        // 为weather设置60秒失效
        Map<String, RedisCacheConfiguration> initialCacheConfigurations = new HashMap<>(1);
        initialCacheConfigurations.put("weather", cacheConfig.entryTtl(Duration.ofSeconds(WEATHER_TIME_OUT)));

        return new RedisCacheManager(cacheWriter, cacheConfig, initialCacheConfigurations);
    }
}
