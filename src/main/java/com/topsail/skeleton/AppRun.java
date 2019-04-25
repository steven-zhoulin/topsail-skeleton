package com.topsail.skeleton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Steven
 */
@SpringBootApplication
@MapperScan("com.topsail.skeleton")
public class AppRun {

    public static void main(String[] args) {
        // 启动
        SpringApplication.run(AppRun.class, args);
    }

}
