package ru.ithub.fitness.service;

import org.springframework.stereotype.Service;
import ru.ithub.fitness.dto.ProvidedOfferDto;
import ru.ithub.fitness.entity.ProvidedOffer;
import ru.ithub.fitness.mapper.ProvidedOfferMapper;
import ru.ithub.fitness.repository.ProvidedOfferRepository;
import ru.ithub.fitness.util.NotFoundException;

import java.util.UUID;

@Service
public class ProvidedOfferService {
    private final ProvidedOfferRepository repository;
    private final ProvidedOfferMapper mapper;

    public ProvidedOfferService(ProvidedOfferRepository repository, ProvidedOfferMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProvidedOffer getEntity(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(
                ProvidedOffer.class,
                NotFoundException.Variable.ID,
                id.toString()
        ));
    }

    public ProvidedOfferDto get(UUID id) {
        return mapper.toDto(getEntity(id));
    }

    public ProvidedOfferDto create(ProvidedOfferDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public ProvidedOfferDto update(UUID id, ProvidedOfferDto dto) {
        ProvidedOffer providedOffer = getEntity(id);
        mapper.update(providedOffer, dto);

        return mapper.toDto(repository.save(providedOffer));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
