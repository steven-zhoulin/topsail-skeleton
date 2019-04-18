package com.topsail.skeleton.common;

import lombok.Data;

import java.util.List;

/**
 * @author Steven
 */
@Data
public class Result implements IResult {

    private Integer total;
    private Object rows;

    private Integer code;
    private String message;

    public static Result success() {
        Result result = new Result();
        result.setResultCode(0);
        return result;
    }

    public static Result success(Object rows) {
        Result result = new Result();
        result.setResultCode(0);
        result.setRows(rows);
        if (rows instanceof List) {
            List list = (List) rows;
            result.setTotal(list.size());
        }
        return result;
    }

    public static Result failure(int code) {
        Result result = new Result();
        result.setResultCode(code);
        return result;
    }

    public static Result failure(String message) {
        Result result = new Result();
        result.setCode(-1);
        result.setMessage(message);
        return result;
    }

    public static Result failure(int code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }

    private void setResultCode(int code) {
        this.code = code;
    }

}
