package com.log.rest.domain;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * 接口返回结果
 * @author 廖俊瑶
 */
@Data
public class RestResponse<T> {

    /** 状态码 */
    private Integer code;

    /** 返回信息 */
    private String message;

    /** 返回结果 */
    private T result;

    public static <T> RestResponse<T> success(){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return response;
    }

    public static <T> RestResponse<T> success(T result){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setResult(result);
        return response;
    }

    public static <T> RestResponse<T> success(String message, T result){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage(message);
        response.setResult(result);
        return response;
    }

    public static <T> RestResponse<T> failed(HttpStatus status){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(status.value());
        return response;
    }

    public static <T> RestResponse<T> failed(HttpStatus status, String message){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(status.value());
        response.setMessage(message);
        return response;
    }

    public static <T> RestResponse<T> failed(HttpStatus status, String message, T result){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(status.value());
        response.setMessage(message);
        response.setResult(result);
        return response;
    }

    public static <T> RestResponse<T> serverError(){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;
    }

    public static <T> RestResponse<T> serverError(String message){
        RestResponse<T> response = new RestResponse<>();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(message);
        return response;
    }
}
