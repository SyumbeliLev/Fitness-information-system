package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.ProvidedOfferDto;
import ru.ithub.fitness.service.ProvidedOfferService;

import java.util.UUID;

@RestController
@RequestMapping("/providedoffer")
public class ProvidedOfferController {
    private final ProvidedOfferService service;

    public ProvidedOfferController(ProvidedOfferService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvidedOfferDto> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProvidedOfferDto> create(@RequestBody ProvidedOfferDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProvidedOfferDto> update(@PathVariable UUID id, @RequestBody ProvidedOfferDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
