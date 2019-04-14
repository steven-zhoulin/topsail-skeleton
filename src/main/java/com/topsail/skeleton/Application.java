package com.topsail.skeleton;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven
 */
@Api("swaggerDemoController相关的api")
@SpringBootApplication
@Controller
public class Application {

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/system-dict")
    public String systemDict() {
        return "system/dict";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
