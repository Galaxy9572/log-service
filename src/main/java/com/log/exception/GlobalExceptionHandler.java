package com.log.exception;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.log.rest.domain.RestResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常处理
 * @author 廖俊瑶
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Exception类，打印日志，返回服务器错误
     * @param e Exception
     * @return RestResponse
     */
    @ExceptionHandler(Exception.class)
    public RestResponse<Object> handleException(Exception e){
        log.error("GlobalExceptionHandler: Caught Exception", e);
        return RestResponse.serverError();
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(!CollectionUtils.isEmpty(fieldErrors)){
            fieldErrors.forEach(i -> errorMessage.append(i).append("\n"));
        }
        return RestResponse.failed(HttpStatus.BAD_REQUEST, errorMessage.toString());
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = BindException.class)
    public RestResponse<Object> handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if(!CollectionUtils.isEmpty(fieldErrors)){
            fieldErrors.forEach(i -> errorMessage.append(i).append("\n"));
        }
        return RestResponse.failed(HttpStatus.BAD_REQUEST, errorMessage.toString());
    }

    /**
     * 校验异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public RestResponse<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        StringBuilder errorMessage = new StringBuilder();
        if(!CollectionUtils.isEmpty(constraintViolations)){
            constraintViolations.forEach(i -> errorMessage.append(i.getMessage()).append("\n"));
        }
        return RestResponse.failed(HttpStatus.BAD_REQUEST, errorMessage.toString());
    }

}
