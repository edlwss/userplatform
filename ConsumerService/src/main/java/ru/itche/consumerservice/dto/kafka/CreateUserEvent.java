package ru.itche.consumerservice.dto.kafka;

import ru.itche.consumerservice.dto.user.UserPayload;

public record CreateUserEvent(
        Long userId,
        String timestamp,
        UserPayload payload
) {
}
