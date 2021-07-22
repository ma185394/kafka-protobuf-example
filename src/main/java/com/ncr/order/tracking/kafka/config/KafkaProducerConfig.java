package com.ncr.order.tracking.kafka.config;

import com.github.daniel.shuy.kafka.protobuf.serde.KafkaProtobufDeserializer;
import com.github.daniel.shuy.kafka.protobuf.serde.KafkaProtobufSerializer;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.protobuf.generated.EmployeeProto;
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
    public ProducerFactory<String, LogMessageProto.LogMessage> producerFactory() {
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
                KafkaProtobufSerializer.class
        );

        return new DefaultKafkaProducerFactory<>(
                configMap,
                new StringSerializer(),
                new KafkaProtobufSerializer<>()
        );
    }


    /**
     * Bean to configure kafka template which is used to connect to topic
     *
     * @return kafkaTemplate used for connection to topic
     */
//    @Bean
//    public KafkaTemplate<String, EmployeeProto.Employee> kafkaTemplate() {
//        return new KafkaTemplate(producerFactory());
//    }

    @Bean
    public KafkaTemplate<String, LogMessageProto.LogMessage> logMessageKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
