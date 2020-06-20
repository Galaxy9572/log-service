package com.log.service;

/**
 * 日志服务
 * @author 廖俊瑶
 */
public interface ILogService {

    /**
     * 记录日志信息
     * @param log 日志文本
     * @return 成功返回true，否则false
     */
    boolean recordLog(String log);
}
