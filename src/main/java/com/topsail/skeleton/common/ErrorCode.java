package com.topsail.skeleton.common;

/**
 * @author Steven
 */
public enum ErrorCode {

    /**
     * 字典不存在
     */
    DICT_NOT_FOUND(40401),

    /**
     * 字典已存在
     */
    DICT_ALREADY_EXIST(40001),

    /**
     * 字典详情不存在
     */
    DICT_DETAIL_NOT_FOUND(40402),

    /**
     * 字典详情已存在
     */
    DICT_DETAIL_ALREADY_EXIST(40002),

    /**
     * 字典详情不存在
     */
    USER_NOT_FOUND(40403),

    /**
     * 字典详情已存在
     */
    USER_ALREADY_EXIST(40003),

    ;

    private int code;

    ErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
