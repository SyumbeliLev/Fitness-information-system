package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
