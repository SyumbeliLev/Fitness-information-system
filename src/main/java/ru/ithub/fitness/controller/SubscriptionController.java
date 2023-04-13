package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.CollectionDto;
import ru.ithub.fitness.dto.SubscriptionDto;
import ru.ithub.fitness.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SubscriptionDto> create(@RequestBody SubscriptionDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDto> update(@PathVariable Long id, @RequestBody SubscriptionDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CollectionDto<Long> dto) {
        service.delete(dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
