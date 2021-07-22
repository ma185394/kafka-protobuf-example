package com.ncr.order.tracking.kafka.config;

import com.github.daniel.shuy.kafka.protobuf.serde.KafkaProtobufDeserializer;
import com.ncr.order.tracking.kafka.protobuf.LogMessageProto;
import com.protobuf.generated.EmployeeProto;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@EnableConfigurationProperties(
        value = KafkaConfig.class
)
@Configuration
@AllArgsConstructor
public class KafkaConsumerConfig {
    private final KafkaConfig kafkaConfig;

    @Bean
    public ConsumerFactory<String, LogMessageProto.LogMessage> consumerFactory() {
        final Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfig.getBootstrapServers());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConfig.getGroupId());
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaProtobufDeserializer.class);
//        config.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   " +
//                "required username='"+ kafkaConfig.getUserName() +"'   password='"+ kafkaConfig.getPassword() +"';");
//        config.put("sasl.mechanism", "PLAIN");
//        config.put("security.protocol", "SASL_SSL");

        return new DefaultKafkaConsumerFactory<>(
                config, new StringDeserializer(),
                new KafkaProtobufDeserializer<>(LogMessageProto.LogMessage.parser()));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LogMessageProto.LogMessage> kafkaListenerContainerFactory() {
        final ConcurrentKafkaListenerContainerFactory<String, LogMessageProto.LogMessage> kafkaListenerContainerFactory
                = new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
        return kafkaListenerContainerFactory;
    }

}
