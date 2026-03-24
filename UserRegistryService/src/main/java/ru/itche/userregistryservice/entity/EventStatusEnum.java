package ru.itche.userregistryservice.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatusEnum {
    WAIT_PROCESSING(0),
    PROCESSING(1),
    SENT(2),
    ERROR(3);

    private final Integer code;
}
