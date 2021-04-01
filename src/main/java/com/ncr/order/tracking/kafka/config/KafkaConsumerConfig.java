package com.ncr.order.tracking.kafka.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties(
        value = KafkaConfig.class
)
@Configuration
@AllArgsConstructor
public class KafkaTopicConfig {

    /**
     * Object for kafka configuration
     */
    private KafkaConfig kafkaConfig;

    /**
     * Bean to set up bootstrap server to localhost
     *
     * @return
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>();
        config.put(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaConfig.getBootstrapServers()
        );
        return new KafkaAdmin(config);
    }

}
