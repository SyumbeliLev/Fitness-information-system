package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
