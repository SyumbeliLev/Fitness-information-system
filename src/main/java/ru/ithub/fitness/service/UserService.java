package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.CollectionDto;
import ru.ithub.fitness.dto.UserDto;
import ru.ithub.fitness.entity.User;
import ru.ithub.fitness.mapper.UserMapper;
import ru.ithub.fitness.repository.UserCardRepository;
import ru.ithub.fitness.repository.UserRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper, UserCardRepository userCardRepository) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User getEntity(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                User.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public User getEntityByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundException(
                User.class,
                NotFoundException.Variable.EMAIL,
                email
        ));
    }

    public Set<User> getAllEntities() {
        return new HashSet<>(repository.findAll());
    }

    public Set<UserDto> getAllDtos() {
        return getAllEntities().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    public UserDto getDto(UUID id) {
        return mapper.toDto(getEntity(id));
    }

    public UserDto create(UserDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public UserDto update(UUID id, UserDto dto) {
        User user = getEntity(id);
        mapper.update(user, dto);

        return mapper.toDto(repository.save(user));
    }

    public void delete(CollectionDto<UUID> dto) {
        repository.deleteAllById(dto.getCollection());
    }
}