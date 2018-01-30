package lab.zlren.weather.report.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

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
