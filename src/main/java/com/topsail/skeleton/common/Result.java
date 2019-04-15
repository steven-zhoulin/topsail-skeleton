package com.topsail.skeleton.common;

import lombok.Data;

/**
 * @author Steven
 */
@Data
public class Result {

    /**
     * 自定义错误编码
     */
    private int code;

    /**
     * 错误内容
     */
    private String error;

    public Result(String error, int code) {
        this.error = error;
        this.code = code;
    }

}
