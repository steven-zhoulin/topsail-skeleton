package com.topsail.skeleton;

import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Steven
 */
@Api("Topsail skeleton 相关 API")
@SpringBootApplication
@Controller
public class AppRun {

    public static void main(String[] args) {
        // 启动
        SpringApplication.run(AppRun.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "redirect:main";
    }

    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/system-dict")
    public String systemDict() {
        return "system/dict";
    }



}
