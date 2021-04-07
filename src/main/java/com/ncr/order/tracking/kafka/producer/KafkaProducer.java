package com.ncr.order.tracking.kafka.producer;

import com.google.protobuf.Descriptors;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.protobuf.generated.ProtoBuilder;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer {

    /**
     * topic name for kafka
     */
    private static final String TOPIC_NAME = "topic";

    /**
     * template used to connect to kafka
     */
//    private KafkaTemplate<String, EmployeeProto.Employee> employeeKafkaTemplate;

    private KafkaTemplate<String, LogMessageProto.LogMessage> logMessageTemplate;

    /**
     * Method to write messages to topic
     *
     * @param message contains data from the producer
     */
    public void writeLogMessage(String message) throws Descriptors.DescriptorValidationException {
        logMessageTemplate.send(TOPIC_NAME, ProtoBuilder.buildLogMessage());
    }

}
