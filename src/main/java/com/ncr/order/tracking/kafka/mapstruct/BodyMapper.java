package com.ncr.order.tracking.kafka.mapstruct;

import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import org.mapstruct.Named;

import java.nio.charset.StandardCharsets;

public class BodyMapper {
    @Named("bodyMapper")
    public String toBody(LogMessageProto.LogBody logBody) {
        final byte[] logBodyByte = logBody.toByteArray();
        return new String(logBodyByte, StandardCharsets.UTF_8);
    }

}
