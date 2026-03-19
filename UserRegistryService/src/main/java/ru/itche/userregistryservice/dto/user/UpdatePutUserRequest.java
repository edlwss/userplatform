package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Запрос на полное обновение данных пользователя")
public record UpdatePutUserRequest (
        @Schema(description = "Имя пользователя", example = "Иван")
        @NotBlank
        String firstName,

        @Schema(description = "Фамилия пользователя", example = "Иванов")
        @NotBlank
        String lastName
){
}
