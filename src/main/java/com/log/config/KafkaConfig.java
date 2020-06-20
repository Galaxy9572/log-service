package com.log.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * Kafka配置
 * @author 廖俊瑶
 */
@Configuration
public class KafkaConfig {

    @Bean
    public RecordMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

}
