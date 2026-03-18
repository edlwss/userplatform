package ru.itche.userregistryservice.service;

import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;
import ru.itche.userregistryservice.entity.User;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);
    UserResponse getUser(Long userId);

}
