package ru.itche.consumerservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.itche.consumerservice.dto.kafka.CreateUserEvent;
import ru.itche.consumerservice.service.UserFinalService;

@Service
@RequiredArgsConstructor
public class CreateUserListener {

    private final UserFinalService service;

    @KafkaListener(topics = "create-user", groupId = "group-create-user")
    public void handleUserCreated(CreateUserEvent event) {
        service.saveUserData(event);
    }
}
