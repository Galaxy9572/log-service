package com.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 廖俊瑶
 */
@SpringBootApplication(scanBasePackages = "com.log")
public class LogServiceProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogServiceProducerApplication.class, args);
    }

}
