// src/main/java/com/taxi/controller/PassengerRestController.java
package com.taxi.controller;

import com.taxi.entity.PassengerEntity;
import com.taxi.repository.PassengerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerRestController {

    private final PassengerRepository repo;

    public PassengerRestController(PassengerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<PassengerEntity> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerEntity> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PassengerEntity create(@RequestBody PassengerEntity passenger) {
        passenger.setId(null); // на всякий случай, чтобы не перезаписать существующую запись
        return repo.save(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerEntity> update(
            @PathVariable Long id,
            @RequestBody PassengerEntity passenger
    ) {
        return repo.findById(id)
                .map(existing -> {
                    passenger.setId(id);
                    return ResponseEntity.ok(repo.save(passenger));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return repo.findById(id)
                .map(p -> {
                    repo.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
