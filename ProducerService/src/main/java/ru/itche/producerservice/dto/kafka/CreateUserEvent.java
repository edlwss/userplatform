package ru.itche.producerservice.dto.kafka;

import ru.itche.producerservice.dto.user.UserPayload;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CreateUserEvent(
        Long userId,
        String timestamp,
        UserPayload payload
) {
}
