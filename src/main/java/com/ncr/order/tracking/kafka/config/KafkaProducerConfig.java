package com.ncr.order.tracking.kafka.config;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(
        value = KafkaConfig.class
)
@AllArgsConstructor
public class KafkaProducerConfig {

    private KafkaConfig kafkaConfig;

    /**
     * Bean to configure kafka server, key serializer, and value serializer
     *
     * @return defaultKafkaProducerFactory kafka producer object
     */

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                kafkaConfig.getBootstrapServers()
        );
        configMap.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );
        configMap.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );

        return new DefaultKafkaProducerFactory<>(configMap);
    }


    /**
     * Bean to configure kafka template which is used to connect to topic
     *
     * @return kafkaTemplate used for connection to topic
     */
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
