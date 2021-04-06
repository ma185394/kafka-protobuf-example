package com.ncr.order.tracking.kafka.service;

import com.google.protobuf.Message;
import com.ncr.order.tracking.kafka.mapstruct.OrderTrackingKafkaMapper;
import com.ncr.order.tracking.kafka.model.TrackedOrder;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.ncr.order.tracking.kafka.repository.TrackedOrderRepository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapping;
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

    @Override
    public void saveProtoLogMessage(LogMessageProto.LogMessage message) {
        if (message != null) {

           LogMessageProto.LogMessage constructedMessage = LogMessageProto.LogMessage.newBuilder()
                   .setOrganizationId(message.getOrganizationId())
                   .setSiteId(message.getSiteId())
                   .setTimeUtc(message.getTimeUtc())
                   .setBody(message.getBody())
                   .build();

            final TrackedOrder orderToSave = mapper.createLogMessageProtoToTrackedOrder(constructedMessage);

//            log.trace("Saving the following message: {}", orderToSave);
//            trackedOrderRepository.save(orderToSave);

            log.info("Successfully saved tracked order with id {} and organization {} ",
                    message.getBody().getCorrelationId(),
                    message.getOrganizationId());
        }
    }
}