package com.log.service.impl;

import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.log.enums.KafkaTopicEnum;
import com.log.service.IMessageService;

import lombok.extern.slf4j.Slf4j;

/**
 * Kafka消息发送服务
 * @author 廖俊瑶
 */
@Slf4j
@Service
public class KafkaMessageServiceImpl implements IMessageService {

    private final KafkaTemplate<KafkaTopicEnum, String> kafkaTemplate;

    @Autowired
    public KafkaMessageServiceImpl(KafkaTemplate<KafkaTopicEnum, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public boolean sendMessage(KafkaTopicEnum topic, String message) {
        AtomicBoolean isSuccess = new AtomicBoolean(false);
        ListenableFuture<SendResult<KafkaTopicEnum, String>> sendResult = kafkaTemplate.send(topic.getTopicName(), message);
        sendResult.addCallback(result -> {
            log.info("Send message to Kafka success");
            isSuccess.set(true);
        }, ex -> log.error("Send message to Kafka failed", ex));
        return isSuccess.get();
    }

}
