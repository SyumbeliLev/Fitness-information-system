package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.UserCardDto;
import ru.ithub.fitness.service.UserCardService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/user/card")
public class UserCardController {
    private final UserCardService service;

    public UserCardController(UserCardService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCardDto> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<UserCardDto>> getAll() {
        return new ResponseEntity<>(service.getAllDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserCardDto> create(@RequestBody UserCardDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserCardDto> update(@PathVariable UUID id, @RequestBody UserCardDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
