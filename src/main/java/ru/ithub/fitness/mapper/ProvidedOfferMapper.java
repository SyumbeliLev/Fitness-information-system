package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.ProvidedOfferDto;
import ru.ithub.fitness.entity.EProvidedOfferType;
import ru.ithub.fitness.entity.Offer;
import ru.ithub.fitness.entity.ProvidedOffer;
import ru.ithub.fitness.entity.Subscription;
import ru.ithub.fitness.service.OfferService;
import ru.ithub.fitness.service.SubscriptionService;
import ru.ithub.fitness.service.UserCardService;

@Component
public class ProvidedOfferMapper {
    private final OfferService offerService;
    private final SubscriptionService subscriptionService;
    private final UserCardService userCardService;

    public ProvidedOfferMapper(OfferService offerService, SubscriptionService subscriptionService, UserCardService userCardService) {
        this.offerService = offerService;
        this.subscriptionService = subscriptionService;
        this.userCardService = userCardService;
    }



    public ProvidedOfferDto toDto(ProvidedOffer entity) {
        return new ProvidedOfferDto(
                entity.getId(),
                entity.getOffer() == null ? null : entity.getOffer().getId(),
                entity.getSubscription() == null ? null : entity.getSubscription().getId(),
                entity.getProvidedServiceType().name(),
                entity.getActiveBefore(),
                entity.getUserCard().getId()
        );
    }

    public ProvidedOffer toEntity(ProvidedOfferDto dto) {
        Offer offer = null;
        Subscription subscription = null;

        if (dto.getProvidedServiceType().equalsIgnoreCase(EProvidedOfferType.SERVICE.name())) {
            offer = offerService.getEntity(dto.getOfferId());
        } else if (dto.getProvidedServiceType().equalsIgnoreCase(EProvidedOfferType.SUBSCRIPTION.name())) {
            subscription = subscriptionService.getEntity(dto.getSubscriptionId());
        } else {
            throw new RuntimeException("Not accepted provided service type");
        }

        return new ProvidedOffer(
                null,
                offer,
                subscription,
                EProvidedOfferType.valueOf(dto.getProvidedServiceType()),
                dto.getActiveBefore(),
                userCardService.getEntity(dto.getUserCardId())
        );
    }

    public void update(ProvidedOffer entity, ProvidedOfferDto dto) {
        if (dto.getActiveBefore() != null && !dto.getActiveBefore().equals(entity.getActiveBefore())) {
            entity.setActiveBefore(dto.getActiveBefore());
        }
    }
}
