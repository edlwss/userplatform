package ru.itche.userregistryservice.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePatchUserRequest;
import ru.itche.userregistryservice.dto.user.UpdatePutUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;
import ru.itche.userregistryservice.entity.User;
import ru.itche.userregistryservice.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Profile("default")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());

        User savedUser = userRepository.save(user);
        return UserResponse.from(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserResponse.from(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();

        return UserResponse.fromAll(users);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long userId, UpdatePutUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User nt found"));

        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());

        return UserResponse.from(user);
    }

    @Override
    @Transactional
    public UserResponse patchUser(Long userId, UpdatePatchUserRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (request.firstName() != null && !request.firstName().isBlank()){
            user.setFirstName(request.firstName());
        }
        if (request.lastName() != null && !request.lastName().isBlank()){
            user.setLastName(request.lastName());
        }

        return UserResponse.from(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
