package com.ncr.order.tracking.kafka.proto;

import com.protobuf.generated.EmployeeProto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@Configuration
public class ProtoConfig {

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    EmployeeProto.Employee createEmployee() {
        return EmployeeProto.Employee.newBuilder()
                .setId(1)
                .setName("John Doe")
                .setSalary(100_000F)
                .build();
    }
}
