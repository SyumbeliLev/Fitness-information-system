package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.HistoryPayment;

public interface HistoryPaymentRepository extends JpaRepository<HistoryPayment, Long> {
}
