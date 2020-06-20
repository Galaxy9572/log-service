package com.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.enums.KafkaTopicEnum;
import com.log.service.ILogService;
import com.log.service.IMessageService;

/**
 * @author 廖俊瑶
 */
@Service
public class LogServiceImpl implements ILogService {

    private IMessageService iMessageService;

    @Autowired
    public LogServiceImpl(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

    @Override
    public boolean recordLog(String log){
        return iMessageService.sendMessage(KafkaTopicEnum.LOG, log);
    }

}
