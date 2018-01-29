package lab.zlren.weather.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlren
 * @date 2018-01-29
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String sayHello() {
        return "hello";
    }
}
