package lab.zlren.weather.basic.config.cache;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;

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
    public CacheManagerCustomizer<RedisCacheManager> cacheManagerCustomizer() {
        return cacheManager -> {

            // 设置默认过期时间为60秒
            cacheManager.setDefaultExpiration(60);

            Map<String, Long> expires = new HashMap<>(1);
            expires.put("weather", WEATHER_TIME_OUT);
            cacheManager.setExpires(expires);
        };
    }
}
