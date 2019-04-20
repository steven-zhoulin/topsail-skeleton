package com.topsail.skeleton;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api("Topsail skeleton 相关 API")
@Controller
public class MenuController {

    @GetMapping("/")
    public String index() {
        return "redirect:main";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/system-dict")
    public String systemDict() {
        return "system/dict";
    }

    @GetMapping("/system-job")
    public String systemJob() {
        return "system/job";
    }

    @GetMapping("/system-dept")
    public String systemDept() {
        return "system/dept";
    }
}
