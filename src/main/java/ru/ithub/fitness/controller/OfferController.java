package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.CollectionDto;
import ru.ithub.fitness.dto.OfferDto;
import ru.ithub.fitness.service.OfferService;

@RestController
@RequestMapping("/offer")
public class OfferController {
    private final OfferService service;

    public OfferController(OfferService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OfferDto> create(@RequestBody OfferDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDto> update(@PathVariable Long id, @RequestBody OfferDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CollectionDto<Long> dto) {
        service.delete(dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
