package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
