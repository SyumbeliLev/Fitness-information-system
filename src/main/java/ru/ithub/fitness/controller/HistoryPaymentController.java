package ru.ithub.fitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ithub.fitness.dto.HistoryPaymentDto;
import ru.ithub.fitness.service.HistoryPaymentService;

import java.util.Set;

@RestController
@RequestMapping("/history/payment")
public class HistoryPaymentController {
    private final HistoryPaymentService service;

    public HistoryPaymentController(HistoryPaymentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoryPaymentDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<HistoryPaymentDto>> getAll() {
        return new ResponseEntity<>(service.getAllDto(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<HistoryPaymentDto> create(@RequestBody HistoryPaymentDto dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
