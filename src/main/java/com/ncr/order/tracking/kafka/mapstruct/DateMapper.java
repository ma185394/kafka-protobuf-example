package com.ncr.order.tracking.kafka.mapstruct;

import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class DateMapper {
    @Named("toDate")
    public static Date timeStampToDate(LogMessageProto.Timestamp timestamp){
        return Date.from(Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos()));
    }
}
