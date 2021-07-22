package com.ncr.order.tracking.kafka.mapstruct;

import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class InstantMapper {
    public static Instant timeStampToDate(LogMessageProto.Timestamp timestamp){
        return Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());
    }
}
