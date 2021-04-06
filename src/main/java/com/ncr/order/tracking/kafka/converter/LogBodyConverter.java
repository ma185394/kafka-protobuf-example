package com.ncr.order.tracking.kafka.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncr.order.tracking.kafka.model.MessageBody;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
@AllArgsConstructor
@Slf4j
public class LogBodyConverter implements AttributeConverter<LogMessageProto.LogMessage, String> {

    private final ObjectMapper mapper;


    @Override
    public String convertToDatabaseColumn(LogMessageProto.LogMessage attribute) {
        if(attribute == null){
            return null;
        }
        StringBuilder builder = new StringBuilder();
        try{
            builder.append(mapper.writeValueAsString(attribute));

        }catch (JsonProcessingException e){
            log.error("Unable to convert LogBody to String due to: " + e.getCause());
        }
        return builder.toString();
    }

    @Override
    public LogMessageProto.LogMessage convertToEntityAttribute(String dbData) {
        return null;
    }

}
