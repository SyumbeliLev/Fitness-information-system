package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.SubscriptionDto;
import ru.ithub.fitness.entity.Offer;
import ru.ithub.fitness.entity.Subscription;
import ru.ithub.fitness.service.OfferService;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class SubscriptionMapper {
    private final OfferService offerService;

    public SubscriptionMapper(OfferService offerService) {
        this.offerService = offerService;
    }

    public SubscriptionDto toDto(Subscription entity) {
        return new SubscriptionDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getIncludedOffers()
                        .stream()
                        .map(Offer::getId)
                        .collect(Collectors.toSet()),
                entity.getPrice(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public Subscription toEntity(SubscriptionDto dto) {
        return new Subscription(
                null,
                dto.getName(),
                dto.getDescription(),
                offerService.getEntitiesByIds(dto.getIncludedOfferIds()),
                dto.getPrice(),
                LocalDateTime.now(),
                null
        );
    }

    public void update(Subscription entity, SubscriptionDto dto) {
        if (dto.getName() != null
                && !dto.getName().isBlank()
                && !dto.getName()
                .equals(entity.getName())) {
            entity.setName(dto.getName());
        }

        if (dto.getDescription() != null
                && !dto.getDescription().isBlank()
                && !dto.getDescription()
                .equals(entity.getDescription())) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getIncludedOfferIds() != null) {
            entity.setIncludedOffers(offerService.getEntitiesByIds(dto.getIncludedOfferIds()));
        }

        if (dto.getPrice() != null && !dto.getPrice().equals(entity.getPrice())) {
            entity.setPrice(dto.getPrice());
        }
    }
}
