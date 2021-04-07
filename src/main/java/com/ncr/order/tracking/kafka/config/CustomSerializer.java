package com.ncr.order.tracking.kafka.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;


import java.io.IOException;

public class CustomSerializer extends JsonSerializer<Message> {
    @Override
    public void serialize(Message value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        JsonFormat format = new JsonFormat();
        gen.writeString(format.printToString(value));
    }
}
