package com.ncr.order.tracking.kafka.mapstruct;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncr.order.tracking.kafka.model.TrackedOrder;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Base64Util;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Mapper(componentModel = "spring", uses = DateMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderTrackingKafkaMapper {
    @Mapping(target = "trackedOrderId", source = "body.correlationId")
    @Mapping(target = "organization", source = "organizationId")
//    @Mapping(target = "trackedOrderBody", source = "body")
    @Mapping(target = "siteId", source = "siteId")
    @Mapping(target = "dateCreated", source = "timeUtc", qualifiedByName = "toDate")
//    @Mapping(target = "trackedOrderBody.body.severity", source = "body.severity" )
//    @Mapping(target = "trackedOrderBody.body.logType", source = "body.logType")
    TrackedOrder createLogMessageProtoToTrackedOrder(LogMessageProto.LogMessage message);

//    @BeforeMapping
//    @Named("bodyMapper")
//    default String toBody(@MappingTarget LogMessageProto.LogBody logBody) throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        String convertedObject = null;
//        try {
//            convertedObject = objectMapper.writeValueAsString(logBody);
//        } catch (JsonProcessingException e) {
//            System.out.println("not able to parse");
//        }
//        return convertedObject;
//    }

    @AfterMapping
    default TrackedOrder toBody(@MappingTarget LogMessageProto.LogBody logBody){
        final TrackedOrder trackedOrder = new TrackedOrder();
        trackedOrder.setTrackedOrderBody(logBody);
        return trackedOrder;
    }
}