package com.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.log.domain.vo.LogRequestVO;
import com.log.rest.domain.RestResponse;
import com.log.service.ILogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 廖俊瑶
 */
@Api(tags = "日志记录相关接口")
@RestController
@RequestMapping("/log")
public class LogController {

    private final ILogService iLogService;

    @Autowired
    public LogController(ILogService iLogService) {
        this.iLogService = iLogService;
    }

    @ApiOperation("测试接口")
    @GetMapping("/hello")
    public RestResponse<String> hello(){
        return RestResponse.success("Hello");
    }

    @ApiOperation("发送日志")
    @PostMapping("")
    public RestResponse<String> recordLog(@RequestBody @Validated LogRequestVO log){
        boolean isSuccess = iLogService.recordLog(log.getMessage());
        return isSuccess ? RestResponse.success() : RestResponse.failed(HttpStatus.EXPECTATION_FAILED);
    }

}
