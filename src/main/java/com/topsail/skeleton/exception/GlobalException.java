package com.topsail.skeleton.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Steven
 */
@Setter
@Getter
public class GlobalException extends RuntimeException {

    private String message;
    private int code;

    public GlobalException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

}
