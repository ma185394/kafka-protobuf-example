package com.ncr.order.tracking.kafka.config;


import com.ncr.order.tracking.kafka.mapstruct.OrderTrackingKafkaMapper;
import com.ncr.order.tracking.kafka.repository.TrackedOrderRepository;
import com.ncr.order.tracking.kafka.service.DefaultKafkaMessageService;
import com.ncr.order.tracking.kafka.service.KafkaMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaMessageServiceConfig {
    @Bean
    public KafkaMessageService kafkaMessageService(
            TrackedOrderRepository repository, OrderTrackingKafkaMapper mapper){
        return new DefaultKafkaMessageService(repository, mapper);
    }
}
