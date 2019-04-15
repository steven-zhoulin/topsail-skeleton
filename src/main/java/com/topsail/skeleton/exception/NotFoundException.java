package com.topsail.skeleton.exception;

/**
 * @author Steven
 */
public class NotFoundException extends GlobalException {
    public NotFoundException(String message, int code) {
        super(message, code);
    }
}
