package lab.zlren.weather.basic.config.data;

import lab.zlren.weather.basic.util.XmlBuilder;
import lab.zlren.weather.basic.vo.CityList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author zlren
 * @date 2018-01-29
 */
@Configuration
public class CityListConfig {

    @Bean
    public CityList cityList() throws Exception {

        // 读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));

        StringBuilder builder = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        br.close();

        // XML转为Java对象
        return (CityList) XmlBuilder.xmlStrToOject(CityList.class, builder.toString());
    }
}
