package com.ncr.order.tracking.kafka.mapstruct;
//
//import com.ncr.order.tracking.kafka.model.TrackedOrder;
//import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
//import org.mapstruct.*;
//
//import java.sql.Date;
//import java.util.Arrays;
//
//@Mapper(componentModel = "spring")
//public interface LogMapper {
//
//    @BeforeMapping
//    default TrackedOrder beforeMapping(LogMessageProto.LogMessage message){
//        System.out.println("message ===> " + Arrays.toString(LogMessageProto.LogMessage.class.getFields()));
//
//
//        return new TrackedOrder();
//    }
//
//    @Mapping(source = "message.BODY_FIELD_NUMBER.correlationId_", target = "trackedOrderId")
//    TrackedOrder logMessageToTrackedOrder(LogMessageProto.LogMessage message);
////
////    @AfterMapping
////    default TrackedOrder afterMapping(LogMessageProto.LogMessage message){
////        TrackedOrder order = new TrackedOrder();
////        if(message != null){
////            order.setDateCreated(Date.valueOf(message.getTimestampUtc().toString()));
////            order.setSiteId(message.getSiteId());
////            order.setOrganization(message.getOrganizationId());
////            order.setTrackedOrderId(message.getBody().getCorrelationId());
////            order.setTrackedOrderBody(message.getBody().get);
////        }
////    };
//}
