package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.CollectionDto;
import ru.ithub.fitness.dto.UserDto;
import ru.ithub.fitness.service.UserService;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> get(@PathVariable UUID id) {
        return new ResponseEntity<>(service.getDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<UserDto>> getAll() {
        return new ResponseEntity<>(service.getAllDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable UUID id, @RequestBody UserDto dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody CollectionDto<UUID> dto) {
        service.delete(dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
