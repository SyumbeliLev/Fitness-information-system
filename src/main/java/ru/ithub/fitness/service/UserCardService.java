package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.UserCardDto;
import ru.ithub.fitness.entity.UserCard;
import ru.ithub.fitness.mapper.UserCardMapper;
import ru.ithub.fitness.repository.UserCardRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserCardService {
    private final UserCardRepository repository;
    private final UserCardMapper mapper;

    public UserCardService(UserCardRepository repository, UserCardMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserCard getEntity(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                UserCard.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public UserCardDto get(UUID id) {
        return mapper.toDto(getEntity(id));
    }

    public Set<UserCard> getAllEntities() {
        return new HashSet<>(repository.findAll());
    }

    public Set<UserCardDto> getAllDtos() {
        return getAllEntities().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }


    public UserCardDto create(UserCardDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public UserCardDto update(UUID id, UserCardDto dto) {
        UserCard userCard = getEntity(id);
        mapper.update(userCard, dto);

        return mapper.toDto(repository.save(userCard));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
