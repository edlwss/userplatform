package ru.itche.producerservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createUserTopic() {
        return TopicBuilder.name("create-user")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
