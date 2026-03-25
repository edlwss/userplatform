package ru.itche.producerservice.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import ru.itche.producerservice.dto.kafka.CreateUserEvent;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    private final KafkaTemplate<String, CreateUserEvent> createUserEventKafkaTemplate;

    public CompletableFuture<SendResult<String, CreateUserEvent>> sendCreateUserEvent(CreateUserEvent event) {
        ProducerRecord<String, CreateUserEvent> record =
                new ProducerRecord<>("create-user", event);
        record.headers().add("eventType", "CREATE_USER".getBytes(StandardCharsets.UTF_8));

        return createUserEventKafkaTemplate.send(record);
    }
}