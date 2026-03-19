package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UpdatePutUserRequest (
        @NotBlank
        @Schema(example = "Ирина")
        String firstName,

        @NotBlank
        @Schema(example = "Шейк")
        String lastName
){
}
