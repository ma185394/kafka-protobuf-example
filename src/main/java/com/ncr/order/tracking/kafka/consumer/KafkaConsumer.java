package com.ncr.order.tracking.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    /**
     * Method to read message from kafka topic
     *
     * @param message from kafka topic
     */
    @KafkaListener(containerFactory = "kafkaListenerContainerFactory", topics = "REDACTED")
    public void getMessageFromTopic(String message) {
        log.info("message from kafka {}", "\n" + message);
    }
}
