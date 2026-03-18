package ru.itche.userregistryservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.itche.userregistryservice.dto.user.CreateUserRequest;
import ru.itche.userregistryservice.dto.user.UserResponse;
import ru.itche.userregistryservice.entity.User;
import ru.itche.userregistryservice.repository.UserRepository;

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
    public UserResponse getUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserResponse.from(user);
    }
}
