package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.HistoryPaymentDto;
import ru.ithub.fitness.entity.HistoryPayment;
import ru.ithub.fitness.service.ProvidedOfferService;
import ru.ithub.fitness.service.UserService;

@Component
public class HistoryPaymentMapper {
    private final ProvidedOfferService providedOfferService;
    private final UserService userService;

    public HistoryPaymentMapper(ProvidedOfferService providedOfferService, UserService userService) {
        this.providedOfferService = providedOfferService;
        this.userService = userService;
    }

    public HistoryPaymentDto toDto(HistoryPayment entity) {
        return new HistoryPaymentDto(
                entity.getId(),
                entity.getProvidedOffer().getId(),
                entity.getUser().getId(),
                entity.getDateOfPay(),
                entity.getCreatedAt()
        );
    }

    public HistoryPayment toEntity(HistoryPaymentDto dto) {
        return new HistoryPayment(
                null,
                providedOfferService.getEntity(dto.getProvidedOfferId()),
                userService.getEntity(dto.getUserId()),
                dto.getDateOfPay(),
                dto.getCreatedAt()
        );
    }
}
