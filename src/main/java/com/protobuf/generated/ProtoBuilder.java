package com.protobuf.generated;

import lombok.Builder;
import org.springframework.context.annotation.Bean;

@Builder
public class EmployeeProtoBuilder {

    @Bean
    public static EmployeeProto.Employee buildEmployee() {
        return EmployeeProto.Employee
                .newBuilder().
                setName("Moe")
                .setId(1)
                .setSalary(100.00F)
                .build();
    }
}
