package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.HistoryAction;

public interface HistoryActionRepository extends JpaRepository<HistoryAction, Long> {
}
