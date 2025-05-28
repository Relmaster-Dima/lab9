package com.taxi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taxi.entity.DriverEntity;
import com.taxi.repository.DriverRepository;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverRestController {

    private final DriverRepository repo;

    public DriverRestController(DriverRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<DriverEntity> listAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverEntity> getOne(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DriverEntity create(@RequestBody DriverEntity driver) {
        driver.setDeleted(false);
        return repo.save(driver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriverEntity> update(@PathVariable Long id, @RequestBody DriverEntity driver) {
        return repo.findById(id)
                .map(existing -> {
                    driver.setDriverId(id);
                    driver.setDeleted(existing.isDeleted());
                    return ResponseEntity.ok(repo.save(driver));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        return repo.findById(id)
                .map(driver -> {
                    driver.setDeleted(true);
                    repo.save(driver);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
