package ru.ithub.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.fitness.entity.ProvidedOffer;

import java.util.UUID;

public interface ProvidedOfferRepository extends JpaRepository<ProvidedOffer, UUID> {
}
