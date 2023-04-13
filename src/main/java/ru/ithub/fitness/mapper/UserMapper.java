package ru.ithub.fitness.mapper;

import org.springframework.stereotype.Component;
import ru.ithub.fitness.dto.UserDto;
import ru.ithub.fitness.entity.Authority;
import ru.ithub.fitness.entity.User;
import ru.ithub.fitness.repository.AuthorityRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    private final AuthorityRepository authorityRepository;

    public UserMapper(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getFio(),
                entity.getEmail(),
                null,
                entity.getPhone(),
                entity.getBirthDate(),
                entity.getAuthority().getId(),
                entity.getIsActive(),
                entity.getUserCard() == null ? null : entity.getUserCard().getId(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public User toEntity(UserDto dto) {
        return new User(
                null,
                dto.getFio(),
                dto.getEmail(),
                dto.getPassword(), // TODO протестить енкодинг
                dto.getPhone(),
                dto.getBirthDate(),
                authorityRepository.findById(dto.getAuthorityId())
                        .orElseThrow(() -> new NotFoundException(
                                Authority.class,
                                NotFoundException.Variable.ID,
                                dto.getAuthorityId().toString()
                        )),
                true,
                null,
                LocalDateTime.now(),
                null
        );
    }

    public void update(User entity, UserDto dto) {
        if (dto.getFio() != null
                && !dto.getFio().isBlank()
                && !dto.getFio().equals(entity.getFio())) {
            entity.setFio(dto.getFio());
        }

        if (dto.getEmail() != null
                && !dto.getEmail().isBlank()
                && !dto.getEmail().equals(entity.getEmail())) {
            entity.setEmail(dto.getEmail());
        }

        if (dto.getPhone() != null && dto.getPhone().toString().length() == 11) {
            entity.setPhone(dto.getPhone());
        }

        if (dto.getBirthDate() != null && !dto.getBirthDate().equals(entity.getBirthDate())) {
            entity.setEmail(dto.getEmail());
        }

        if (dto.getIsActive() != null && dto.getIsActive() != entity.getIsActive()) {
            entity.setIsActive(!entity.getIsActive());
        }

        entity.setUpdatedAt(LocalDateTime.now());
    }
}