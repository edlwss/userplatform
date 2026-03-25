package ru.itche.producerservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itche.producerservice.dto.kafka.CreateUserEvent;
import ru.itche.producerservice.dto.user.UserPayload;
import ru.itche.producerservice.entity.EventStatusEnum;
import ru.itche.producerservice.entity.User;
import ru.itche.producerservice.kafka.CreateUserProducer;
import ru.itche.producerservice.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserEventPublisherService {

    private final UserRepository userRepository;
    private final CreateUserProducer producer;

    @Transactional
    @Scheduled(fixedDelayString = "${scheduler.user-event-delay}")
    public void userEventPublisher() {
        List<User> users = userRepository.findByEventStatus(EventStatusEnum.WAIT_PROCESSING.getCode());
        changeStatusForUsers(users);

        List<User> usersSent = checkUsers(users);
        for (User user : usersSent) {
            publicationEvent(user);
            user.setEventStatus(EventStatusEnum.SENT.getCode());
        }
    }

    public void publicationEvent(User user) {
        try {
            producer.sendCreateUserEvent(
                    new CreateUserEvent(
                            user.getId(),
                            LocalDateTime.now().toString(),
                            new UserPayload(
                                    user.getFirstName(),
                                    user.getLastName()
                            )
                    )
            );
        } catch (Exception e) {
            log.error("Ошибка при отправке сообщения в Kafka: ", e);
        }
    }

    public void changeStatusForUsers(List<User> users) {
        for (User user : users) {
            user.setEventStatus(EventStatusEnum.PROCESSING.getCode());
        }
    }

    public List<User> checkUsers(List<User> users) {
        List<User> usersSent = new ArrayList<>();
        for (User user : users) {
            if (user.getLastName() == null || user.getLastName().isBlank() || user.getFirstName() == null || user.getFirstName().isBlank()) {
                user.setEventStatus(EventStatusEnum.ERROR.getCode());
            } else {
                usersSent.add(user);
            }
        }
        return usersSent;
    }
}
