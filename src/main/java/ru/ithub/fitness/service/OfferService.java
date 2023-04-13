package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.CollectionDto;
import ru.ithub.fitness.dto.OfferDto;
import ru.ithub.fitness.entity.Offer;
import ru.ithub.fitness.mapper.OfferMapper;
import ru.ithub.fitness.repository.OfferRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class OfferService {
    private final OfferRepository repository;
    private final OfferMapper mapper;

    public OfferService(OfferRepository repository, OfferMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Offer getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                Offer.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public Set<Offer> getEntitiesByIds(Collection<Long> collection) {
        return new HashSet<>(repository.findAllById(collection));
    }

    public OfferDto get(Long id) {
        return mapper.toDto(getEntity(id));
    }

    public OfferDto create(OfferDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public OfferDto update(Long id, OfferDto dto) {
        Offer offer = getEntity(id);
        mapper.update(offer, dto);

        return mapper.toDto(repository.save(offer));
    }

    public void delete(CollectionDto<Long> dto) {
        repository.deleteAllById(dto.getCollection());
    }
}