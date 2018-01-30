package lab.zlren.weather.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 天气响应封装
 *
 * @author zlren
 * @date 2018-01-29
 */
@Data
public class WeatherResponse implements Serializable {

    /**
     * 天气数据
     */
    private Weather data;

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 描述
     */
    private String desc;
}
