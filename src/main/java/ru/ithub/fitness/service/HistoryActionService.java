package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.HistoryActionDto;
import ru.ithub.fitness.entity.HistoryAction;
import ru.ithub.fitness.mapper.HistoryActionMapper;
import ru.ithub.fitness.repository.HistoryActionRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HistoryActionService {
    private final HistoryActionRepository repository;
    private final HistoryActionMapper mapper;


    public HistoryActionService(HistoryActionRepository repository, HistoryActionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public HistoryAction getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                HistoryAction.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public Set<HistoryAction> getAllEntities() {
        return new HashSet<>(repository.findAll());
    }

    public Set<HistoryActionDto> getAllDto() {
        return getAllEntities().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    public HistoryActionDto get(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public HistoryActionDto create(HistoryActionDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
