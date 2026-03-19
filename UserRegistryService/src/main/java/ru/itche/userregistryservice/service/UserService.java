package ru.itche.userregistryservice.service;

import org.springframework.data.jpa.repository.query.PreprocessedQuery;
import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePatchUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePutUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;
import ru.itche.userregistryservice.entity.User;

import java.util.List;

public interface UserService {

    UserResponse createUser(CreateUserRequest request);
    UserResponse getUser(Long userId);
    List<UserResponse> getUsers();
    UserResponse updateUser(Long userId, UpdatePutUserRequest request);
    UserResponse patchUser(Long userId, UpdatePatchUserRequest request);
    void deleteUser(Long userId);
}
