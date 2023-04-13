package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.OfferDto;
import ru.ithub.fitness.entity.Offer;

import java.time.LocalDateTime;

@Component
public class OfferMapper {
    public OfferDto toDto(Offer entity) {
        return new OfferDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public Offer toEntity(OfferDto dto) {
        return new Offer(
                null,
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                LocalDateTime.now(),
                null
        );
    }

    public void update(Offer entity, OfferDto dto) {
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

        if (dto.getPrice() != null && !dto.getPrice()
                .equals(entity.getPrice())) {
            entity.setPrice(dto.getPrice());
        }

        entity.setUpdatedAt(LocalDateTime.now());
    }
}
