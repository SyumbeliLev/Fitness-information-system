package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.CollectionDto;
import ru.ithub.fitness.dto.SubscriptionDto;
import ru.ithub.fitness.entity.Subscription;
import ru.ithub.fitness.mapper.SubscriptionMapper;
import ru.ithub.fitness.repository.SubscriptionRepository;
import ru.ithub.fitness.util.NotFoundException;

@Service
public class SubscriptionService {
    private final SubscriptionRepository repository;
    private final SubscriptionMapper mapper;

    public SubscriptionService(SubscriptionRepository repository, SubscriptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Subscription getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                Subscription.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public SubscriptionDto get(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public SubscriptionDto create(SubscriptionDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public SubscriptionDto update(Long id, SubscriptionDto dto) {
        Subscription subscription = getEntity(id);
        mapper.update(subscription, dto);

        return mapper.toDto(repository.save(subscription));
    }

    public void delete(CollectionDto<Long> dto) {
        repository.deleteAllById(dto.getCollection());
    }
}
