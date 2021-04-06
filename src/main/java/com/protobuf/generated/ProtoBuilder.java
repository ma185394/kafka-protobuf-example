package com.protobuf.generated;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Field;
import com.google.protobuf.UnknownFieldSet;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import lombok.Builder;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@Builder
public class ProtoBuilder {

    @Bean
    public static EmployeeProto.Employee buildEmployee() {
        return EmployeeProto.Employee
                .newBuilder().
                setName("Moe")
                .setId(1)
                .setSalary(100.00F)
                .build();
    }

    @Bean
    public static LogMessageProto.LogMessage buildLogMessage() throws Descriptors.DescriptorValidationException {

    Map<String, String> map = new HashMap<>();
    map.put("detail", "Order Started");
    map.put("subject", "Aloha Kitchen");
    map.put("orderStatus", "Started");
    map.put("orderId", "00001ec-0002-0000-2222-030000000000");
    map.put("category", " KITCHEN");

        LogMessageProto.LogMessage message = LogMessageProto.LogMessage
                .newBuilder()
                .setMessageType("LOG")
                .setModelVersion(2)
                .setMessageId("5df33343-46ce-a3d2-akl2-sdkfa3934")
                .setCreator(LogMessageProto.ApplicationInfo.newBuilder()
                        .setComputerName("DFTWURGIE1")
                        .setApplicationName("FluentBit")
                        .build())
                // start of body
                .setBody(
                        LogMessageProto.LogBody.newBuilder()
                                .setSeverity(LogMessageProto.LogBody.SeverityLevels.INFO)
                                .setApplication(LogMessageProto.ApplicationInfo.newBuilder()
                                        .setApplicationName("Kitchen")
                                        .setApplicationVersion("0.0.0.9999")
                                        .build())
//                                .getLabelsMap().putAll(map)
                                .setCorrelationId("0000e1e-0001-000-1503-0230000000")
                                .setLogType(LogMessageProto.LogBody.LogTypes.ORDER_TRACKING)
//                                .containsLabels("details")
                                .build())
                // end of body
                .setTimeUtc(LogMessageProto.Timestamp.newBuilder()
                        .setSeconds(1616420967L)
                        .setNanos(357000000)
                        .build())
                .setSiteId("654987")
//                .setOrganizationId("btw01")
                .build();

//        LogMessageProto.LogMessage clone = message.getField()
//        message.getBody().getLabelsMap().putAll(map);
        return message;
    }
}
