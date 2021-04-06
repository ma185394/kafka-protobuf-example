//package com.ncr.order.tracking.kafka.util;
//
//import com.google.protobuf.Timestamp;
//import com.ncr.order.tracking.kafka.model.TrackedOrder;
//import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
//import jnr.ffi.annotations.In;
//
//import java.util.Date;
//import java.time.Instant;
//
//public class TrackedOrderUtil {
//
//    public static TrackedOrder logMessageProtoToTrackedOrder(LogMessageProto.LogMessage message) {
//        final TrackedOrder order = new TrackedOrder();
//        if (message != null) {
//            order.setDateCreated(toDate(message));
//            order.setSiteId(message.getSiteId());
//            order.setOrganization(message.getOrganizationId());
//            order.setTrackedOrderId(message.getBody().getCorrelationId());
//            order.setTrackedOrderBody(message.getBody().toString());
//
//        }
//
//        return order;
//    }
//
//    public static Date toDate(LogMessageProto.LogMessage message){
//        Instant instant = Instant.ofEpochSecond(
//                message.getTimeUtc().getSeconds(),
//                message.getTimeUtc().getNanos()
//        );
//
//
//        return Date.from(instant);
//    }
//}
