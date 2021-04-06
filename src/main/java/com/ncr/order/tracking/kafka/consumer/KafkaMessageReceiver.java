package com.ncr.order.tracking.kafka.consumer;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.ncr.order.tracking.kafka.mapstruct.LogMapper;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
        import com.ncr.order.tracking.kafka.service.KafkaMessageService;
        import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
        import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class KafkaMessageReceiver {

    private final KafkaMessageService kafkaMessageService;

    /**
     * Method to read message from kafka topic
     *
     * @param message from kafka topic
     */
    @KafkaListener(
            topics = "topic",
            containerFactory = "kafkaListenerContainerFactory")
//            groupId = "test_group_id_2")
    public void getMessageFromTopic(LogMessageProto.LogMessage message) {

        log.info("message from kafka {}", "\n" + message);
        kafkaMessageService.saveProtoLogMessage(message);


    }
}
