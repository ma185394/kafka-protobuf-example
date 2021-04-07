package com.ncr.order.tracking.kafka.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.protobuf.format.JsonFormat;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Slf4j
@AllArgsConstructor
@Converter(autoApply = true)
public class LogBodyConverter implements AttributeConverter<LogMessageProto.LogBody, String> {

    private final ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(LogMessageProto.LogBody logBody) {
        if (logBody == null) {
            return null;
        }
        String payload = "";
        try {
            payload = mapper.writeValueAsString(logBody);
        } catch (Exception e) {
            log.error("Unable to serialize LogBody to jsonb due to: " + e.getCause());
        }
        return payload;
    }

    @Override
    public LogMessageProto.LogBody convertToEntityAttribute(String dbData) {
        return null;
    }

}