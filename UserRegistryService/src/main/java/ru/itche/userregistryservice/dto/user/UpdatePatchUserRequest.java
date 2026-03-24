package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Запрос на частичное обновение данных пользователя")
public record UpdatePatchUserRequest(

        @Schema(description = "Имя пользователя", example = "Иван")
        String firstName,

        @Schema(description = "Фамилия пользователя", example = "Иванов")
        String lastName
) {
}
