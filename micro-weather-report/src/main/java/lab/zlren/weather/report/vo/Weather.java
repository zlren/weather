package lab.zlren.weather.report.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 今天天气
 *
 * @author zlren
 * @date 2018-01-29
 */
@Data
@Accessors(chain = true)
public class Weather implements Serializable {
    /**
     * 城市名称
     */
    private String city;

    /**
     * 空气质量
     */
    private String aqi;

    /**
     * 温馨提示
     */
    private String ganmao;

    /**
     * 温度
     */
    private String wendu;

    /**
     * 昨日天气
     */
    private Yesterday yesterday;

    /**
     * 未来天气
     */
    private List<Forecast> forecast;
}
