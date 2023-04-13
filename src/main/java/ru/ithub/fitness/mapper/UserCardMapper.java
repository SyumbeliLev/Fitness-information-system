package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.UserCardDto;
import ru.ithub.fitness.entity.UserCard;
import ru.ithub.fitness.service.UserService;

import java.time.LocalDateTime;

@Component
public class UserCardMapper {
    private UserService userService;

    public UserCardMapper(UserService userService) {
        this.userService = userService;
    }

    public UserCardDto toDto(UserCard entity) {
        return  new UserCardDto(
                entity.getId(),
                entity.getIsEnabled(),
                entity.getOwner().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public UserCard toEntity(UserCardDto dto) {
        return new UserCard(
                null,
                dto.getIsEnabled(),
                userService.getEntity(dto.getUserId()),
                LocalDateTime.now(),
                null
        );
    }

    public void update(UserCard entity, UserCardDto dto) {
        if (dto.getIsEnabled() != null && !dto.getIsEnabled() == entity.getIsEnabled()) {
            entity.setIsEnabled(!entity.getIsEnabled());
        }
    }
}
