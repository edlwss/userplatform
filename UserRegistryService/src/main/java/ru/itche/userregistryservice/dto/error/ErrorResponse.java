package ru.itche.userregistryservice.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Данные ошибки")
public record ErrorResponse(

        @Schema(description = "Статус ошибки", example = "NOT_FOUND")
        String status,
        @Schema(description = "Сообщение об ошибки", example = "Пользователь не найден")
        String message
) {
}
