package com.log.service;

import com.log.enums.KafkaTopicEnum;

/**
 * 发送消息的服务
 * @author 廖俊瑶
 */
public interface IMessageService {

    /**
     * 发送消息
     * @param topic 目标主题
     * @param message 消息文本
     * @return 成功返回true，否则false
     */
    boolean sendMessage(KafkaTopicEnum topic, String message);
}
