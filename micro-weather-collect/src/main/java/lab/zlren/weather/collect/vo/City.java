package lab.zlren.weather.collect.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * City
 *
 * @author zlren
 * @date 2018-01-29
 */
@Data
@Accessors(chain = true)
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;
}
