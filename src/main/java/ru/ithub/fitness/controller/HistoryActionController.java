package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.HistoryActionDto;
import ru.ithub.fitness.service.HistoryActionService;

import java.util.Set;

@RestController
@RequestMapping("/history/action")
public class HistoryActionController {
    private final HistoryActionService service;

    public HistoryActionController(HistoryActionService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryActionDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<HistoryActionDto>> getAll() {
        return new ResponseEntity<>(service.getAllDto(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HistoryActionDto> create(@RequestBody HistoryActionDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
