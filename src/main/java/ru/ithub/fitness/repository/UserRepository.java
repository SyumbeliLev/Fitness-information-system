package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Boolean existsByPhone(Long phone);
}
