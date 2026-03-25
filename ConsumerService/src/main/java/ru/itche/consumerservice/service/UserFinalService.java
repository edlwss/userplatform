package ru.itche.consumerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itche.consumerservice.dto.kafka.CreateUserEvent;
import ru.itche.consumerservice.entity.UserFinal;
import ru.itche.consumerservice.repository.UserFinalRepository;

@Service
@RequiredArgsConstructor
public class UserFinalService {

    private final UserFinalRepository userFinalRepository;

    @Transactional
    public void saveUserData(CreateUserEvent event) {

        UserFinal user = new UserFinal();
        user.setUserId(event.userId());
        user.setCreatedEvent(event.timestamp());
        user.setFirstNameUser(event.payload().firstName());
        user.setLastNameUser(event.payload().lastName());

        userFinalRepository.save(user);
    }
}
