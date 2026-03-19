package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UpdatePatchUserRequest(
        @Schema(example = "Петр")
        String firstName,

        @Schema(example = "Новосельцев")
        String lastName
) {
}
