package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Request for creating a new user")
public record CreateUserRequest(

        @Schema(description = "User first name", example = "Иван")
        @NotBlank
        String firstName,

        @Schema(description = "User last name", example = "Иванов")
        @NotBlank
        String lastName
) {}
