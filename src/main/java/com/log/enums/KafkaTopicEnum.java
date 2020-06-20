package com.log.enums;

/**
 * Kafka Topic枚举
 * @author 廖俊瑶
 */
public enum KafkaTopicEnum {
    /** log */
    LOG("log");

    private String topicName;

    KafkaTopicEnum(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }
}
