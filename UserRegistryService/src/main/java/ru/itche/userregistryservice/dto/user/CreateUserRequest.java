package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Запрос на создание пользователя")
public record CreateUserRequest(

        @Schema(description = "Имя пользователя", example = "Иван")
        @NotBlank
        String firstName,

        @Schema(description = "Фамилия пользователя", example = "Иванов")
        @NotBlank
        String lastName
) {
}
