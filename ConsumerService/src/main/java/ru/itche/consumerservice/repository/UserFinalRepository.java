package ru.itche.consumerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itche.consumerservice.entity.UserFinal;

@Repository
public interface UserFinalRepository extends JpaRepository<UserFinal, Long> {
}
