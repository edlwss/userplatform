package ru.itche.producerservice.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.itche.producerservice.dto.kafka.CreateUserEvent;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    private final KafkaTemplate<String, CreateUserEvent> createUserEventKafkaTemplate;

    public void sendCreateUserEvent(CreateUserEvent event) {
        createUserEventKafkaTemplate.send("create-user", event);
    }
}
