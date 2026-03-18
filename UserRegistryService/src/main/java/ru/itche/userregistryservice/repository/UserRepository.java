package ru.itche.userregistryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itche.userregistryservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}