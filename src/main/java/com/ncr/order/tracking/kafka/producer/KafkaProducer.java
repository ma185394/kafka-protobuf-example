package com.ncr.order.tracking.kafka.producer;

import com.protobuf.generated.EmployeeProto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer {

    /**
     * topic name for kafka
     */
    private static final String TOPIC_NAME = "test_topic";

    /**
     * template used to connect to kafka
     */
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * Method to write messages to topic
     *
     * @param message contains data from the producer
     */
    public void writeMessageToTopic(String message) {
//        kafkaTemplate.send(TOPIC_NAME, message);
    }

    /**
     * Method to protobuf message to kafka topic
     *
     * @param employee contains data from the producer
     */
    public void writeMessageToTopic(EmployeeProto.Employee employee) {
//        kafkaTemplate.send(TOPIC_NAME, employee.toString());
    }
}
