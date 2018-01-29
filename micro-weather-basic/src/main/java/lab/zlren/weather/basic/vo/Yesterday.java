package lab.zlren.weather.basic.vo;

import lombok.Data;

/**
 * 昨日天气
 *
 * @author zlren
 * @date 2018-01-29
 */
@Data
public class Yesterday {

    /**
     * 日期
     */
    private String date;

    /**
     * 最高问题
     */
    private String high;

    /**
     * 风向
     */
    private String fx;

    /**
     * 最低温度
     */
    private String low;

    /**
     * 风力
     */
    private String fl;

    /**
     * 天气类型
     */
    private String type;
}
