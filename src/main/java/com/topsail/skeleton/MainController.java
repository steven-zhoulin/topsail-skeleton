package com.topsail.skeleton;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api("Topsail skeleton 相关 API")
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "redirect:main";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 菜单管理
     *
     * @return
     */
    @GetMapping("system-permission")
    public String systemPermission() {
        return "system/permission";
    }

    /**
     * 菜单管理
     *
     * @return
     */
    @GetMapping("system-menu")
    public String systemMenu() {
        return "system/menu";
    }

    /**
     * 部门管理
     *
     * @return
     */
    @GetMapping("/system-dept")
    public String systemDept() {
        return "system/dept";
    }

    /**
     * 岗位管理
     *
     * @return
     */
    @GetMapping("/system-job")
    public String systemJob() {
        return "system/job";
    }

    /**
     * 字典管理
     *
     * @return
     */
    @GetMapping("/system-dict")
    public String systemDict() {
        return "system/dict";
    }

}
