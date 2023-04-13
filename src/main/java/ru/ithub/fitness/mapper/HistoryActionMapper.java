package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.HistoryActionDto;
import ru.ithub.fitness.entity.EHistoryActionType;
import ru.ithub.fitness.entity.HistoryAction;
import ru.ithub.fitness.service.UserCardService;

import java.time.LocalDateTime;

@Component
public class HistoryActionMapper {
    private final UserCardService userCardService;

    public HistoryActionMapper(UserCardService userCardService) {
        this.userCardService = userCardService;
    }

    public HistoryActionDto toDto(HistoryAction entity) {
        return new HistoryActionDto(
                entity.getId(),
                entity.getUserCard().getId(),
                entity.getDate(),
                entity.getHistoryActionType().name()
        );
    }

    public HistoryAction toEntity(HistoryActionDto dto) {
        return new HistoryAction(
                null,
                userCardService.getEntity(dto.getUserCardId()),
                LocalDateTime.now(),
                EHistoryActionType.valueOf(dto.getHistoryActionType())
        );
    }
}
