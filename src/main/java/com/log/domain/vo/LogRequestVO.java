package com.log.domain.vo;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * 请求日志记录VO类
 * @author 廖俊瑶
 */
@Data
public class LogRequestVO {

    /** 消息字段 */
    @NotEmpty(message = "Log Can Not Empty")
    private String message;

}
