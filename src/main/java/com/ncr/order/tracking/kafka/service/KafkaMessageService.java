package com.ncr.order.tracking.kafka.service;


import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;

public interface KafkaMessageService {
    /**
     * Save log message
     * @param message the log message from kafka
     */
    void handleMessage(LogMessageProto.LogMessage message);
}
