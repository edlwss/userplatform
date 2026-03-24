package ru.itche.userregistryservice.service;

import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePatchUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePutUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);

    UserResponse getUser(Long userId);

    List<UserResponse> getUsers();

    UserResponse updateUser(Long userId, UpdatePutUserRequest request);

    UserResponse patchUser(Long userId, UpdatePatchUserRequest request);

    void deleteUser(Long userId);
}
