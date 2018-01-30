package lab.zlren.weather.collect.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 未来天气预报
 *
 * @author zlren
 * @date 2018-01-29
 */
@Data
public class Forecast implements Serializable {

    /**
     * 日期
     */
    private String date;

    /**
     * 最高温度
     */
    private String high;

    /**
     * 风力
     */
    private String fengli;

    /**
     * 最低温度
     */
    private String low;

    /**
     * 风向
     */
    private String fengxiang;

    /**
     * 天气类型
     */
    private String type;
}
