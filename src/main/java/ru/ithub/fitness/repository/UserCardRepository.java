package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.UserCard;

import java.util.UUID;

public interface UserCardRepository extends JpaRepository<UserCard, UUID> {
}
