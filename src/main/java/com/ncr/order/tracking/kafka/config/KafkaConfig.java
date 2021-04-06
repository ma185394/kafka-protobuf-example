package com.ncr.order.tracking.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.kafka.consumer")
public class KafkaConfig {

    private String bootstrapServers;

    private String userName;

    private String password;

    private String groupId;

}
