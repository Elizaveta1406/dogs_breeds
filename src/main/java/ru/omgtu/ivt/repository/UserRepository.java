package ru.omgtu.ivt.repository;

import ru.omgtu.ivt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); // Поиск пользователя по логину
}
