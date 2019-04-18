package com.topsail.skeleton.exception.handler;

import com.topsail.skeleton.common.IResult;
import com.topsail.skeleton.common.Result;
import com.topsail.skeleton.exception.AlreadyExistException;
import com.topsail.skeleton.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.OK;

/**
 * 实现全局异常的拦截处理, 注: @ControllerAdvice 和 @RestControllerAdvice 都会自动注册
 *
 * @author Steven
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(OK)
    public IResult handleResourceNotFoundException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return Result.failure(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseBody
    @ResponseStatus(OK)
    public IResult handleResourceAlreadyExistException(AlreadyExistException e) {
        log.error(e.getMessage(), e);
        return Result.failure(e.getCode(), e.getMessage());
    }

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(OK)
    public IResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.failure(-1, e.getMessage());
    }

}