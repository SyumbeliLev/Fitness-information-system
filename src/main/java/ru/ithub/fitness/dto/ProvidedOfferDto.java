package ru.ithub.fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProvidedOfferDto {
    private UUID id;
    private Long offerId;
    private Long subscriptionId;
    private String providedServiceType;
    private LocalDateTime activeBefore;
    private UUID userCardId;
}
