package com.topsail.skeleton;

import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api("Topsail skeleton 相关 API")
@Controller
public class MainController {

    private int count = 0;
    private int i = 0;

    @RequestMapping(value = "/setCookies", method = RequestMethod.GET)
    public void setCookies(HttpServletResponse response) throws IOException {
        count++;
        if (i < 10) {
            i++;
        }
        String suffix = StringUtils.leftPad(String.valueOf(i), 10, '0');
        Cookie cookie = new Cookie("c_eom_" + suffix, "r_eom_25.138_8080_" + suffix);
        response.addCookie(cookie);
        response.getWriter().write("setCookie: " + cookie.getValue() + ", count: " + count);
    }

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
