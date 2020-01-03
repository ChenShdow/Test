package com.edu.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String exception(Exception e){
        log.info("拦截到项目出现的不可控制的异常,{}",e.getMessage());
        return "异常拦截";
    }
    //todo
}
