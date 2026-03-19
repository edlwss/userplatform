package ru.itche.userregistryservice.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import  ru.itche.userregistryservice.entity.User;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public record UserResponse(
        Long userId,
        String firstName,
        String lastName,
        String createdAt,
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
