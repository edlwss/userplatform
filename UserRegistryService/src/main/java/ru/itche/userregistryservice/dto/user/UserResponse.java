package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import  ru.itche.userregistryservice.entity.User;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Schema(description = "Ответ с данными пользователя")
public record UserResponse(
        @Schema(description = "ID пользователя", example = "1")
        Long userId,
        @Schema(description = "Имя пользователя", example = "Иван")
        String firstName,
        @Schema(description = "фамилия пользователя", example = "Иванов")
        String lastName,
        @Schema(description = "Дата создания пользователя", example = "19.03.2026 13:00:00")
        String createdAt,
        @Schema(description = "Дата обновления пользователя", example = "19.03.2026 13:10:00")
        String updatedAt
) {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static UserResponse from(User user){
        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getCreatedAt().format(FORMATTER),
                user.getUpdatedAt().format(FORMATTER)
        );
    }

    public static List<UserResponse> fromAll(List<User> users){
        List<UserResponse> response = new ArrayList<>();
        for (User user:users){
            response.add(from(user));
        }
        return response;
    }


}
