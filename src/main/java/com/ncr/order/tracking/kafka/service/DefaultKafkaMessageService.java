package com.ncr.order.tracking.kafka.service;

import com.ncr.order.tracking.kafka.mapstruct.OrderTrackingKafkaMapper;
import com.ncr.order.tracking.kafka.model.TrackedOrder;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.ncr.order.tracking.kafka.repository.TrackedOrderRepository;

import com.googlecode.protobuf.format.JsonFormat;
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
    private final OrderTrackingKafkaMapper mapper;

    private final JsonFormat jsonFormat;

    @Override
    public void saveProtoLogMessage(LogMessageProto.LogMessage message) {
        if (message != null) {

            final TrackedOrder orderToSave = mapper.createLogMessageProtoToTrackedOrder(message);

            orderToSave.setTrackedOrderBody(jsonFormat.printToString(message.getBody()));

            log.trace("Saving the following message: {}", orderToSave);
            trackedOrderRepository.save(orderToSave);


            log.info("Successfully saved tracked order with id {} and organization {} ",
                    message.getBody().getCorrelationId(),
                    message.getOrganizationId());
        }
    }
}
