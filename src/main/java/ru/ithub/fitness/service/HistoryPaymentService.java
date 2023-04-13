package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.HistoryPaymentDto;
import ru.ithub.fitness.entity.HistoryPayment;
import ru.ithub.fitness.mapper.HistoryPaymentMapper;
import ru.ithub.fitness.repository.HistoryPaymentRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HistoryPaymentService {
    private final HistoryPaymentRepository repository;
    private final HistoryPaymentMapper mapper;

    public HistoryPaymentService(HistoryPaymentRepository repository, HistoryPaymentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public HistoryPayment getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                HistoryPayment.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public Set<HistoryPayment> getAllEntities() {
        return new HashSet<>(repository.findAll());
    }

    public Set<HistoryPaymentDto> getAllDto() {
        return getAllEntities().stream()
                .map(mapper::toDto)
                .collect(Collectors.toSet());
    }

    public HistoryPaymentDto get(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public HistoryPaymentDto create(HistoryPaymentDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
