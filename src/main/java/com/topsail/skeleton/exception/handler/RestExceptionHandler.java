package com.topsail.skeleton.exception.handler;

import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * 实现全局异常的拦截处理, 注: @ControllerAdvice 和 @RestControllerAdvice 都会自动注册
 *
 * @author Steven
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseBody
    @ResponseStatus(NOT_FOUND)
    public Result handleResourceNotFoundException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = AlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(FORBIDDEN)
    public Result handleResourceAlreadyExistException(AlreadyExistException e) {
        log.error(e.getMessage(), e);
        return new Result(e.getMessage(), e.getCode());
    }

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return new Result(e.getMessage(), -1);
    }

}