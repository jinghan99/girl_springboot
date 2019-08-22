package client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yfcloud.client.controller
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/6 14:51
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String hi(@RequestParam(defaultValue = "试一试", required = false) String name) {
        return "可以的,来源于potr: " + port + ": " + name;
    }
}
