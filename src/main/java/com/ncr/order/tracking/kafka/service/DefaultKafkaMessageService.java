package com.ncr.order.tracking.kafka.service;

import com.googlecode.protobuf.format.JsonFormat;
import com.ncr.order.tracking.kafka.mapstruct.OrderTrackingKafkaMapper;
import com.ncr.order.tracking.kafka.model.TrackedOrder;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.ncr.order.tracking.kafka.repository.TrackedOrderRepository;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DefaultKafkaMessageService implements KafkaMessageService {
    /**
     * Spring Data Repository
     */
    private final TrackedOrderRepository trackedOrderRepository;

    /**
     * Mapper for kafka messages
     */
    private final OrderTrackingKafkaMapper kafkaMapper;

    /**
     * Json Mapper for Protobuf Log Body
     */
    private final JsonFormat jsonFormat;

    @Override
    public void handleMessage(LogMessageProto.LogMessage message) {
        if (message != null) {
            final TrackedOrder orderToSave = kafkaMapper.logMessageProtoToTrackedOrder(message);
            orderToSave.setPayload(jsonFormat.printToString(message.getBody()));

            trackedOrderRepository.save(orderToSave);

            log.info("Successfully saved tracked order with enterprise unit {} and organization {}",
                    orderToSave.getSiteId(),
                    orderToSave.getOrganization());
        }
    }
}
