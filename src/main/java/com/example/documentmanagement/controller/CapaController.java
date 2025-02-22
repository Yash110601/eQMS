package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.CapaRecord;
import com.example.documentmanagement.service.CapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/capas")
public class CapaController {

    @Autowired
    private CapaService capaService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('AUDITOR')")
    @GetMapping
    public ResponseEntity<List<CapaRecord>> getAllCapas() {
        return ResponseEntity.ok(capaService.getAllCapas());
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('AUDITOR')")
    @GetMapping("/{id}")
    public ResponseEntity<CapaRecord> getCapaById(@PathVariable UUID id) {
        Optional<CapaRecord> capa = capaService.getCapaById(id);
        return capa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCapa(@Valid @RequestBody CapaRecord capa) {
        try {
            return ResponseEntity.ok(capaService.createCapa(capa));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCapa(@PathVariable UUID id, @Valid @RequestBody CapaRecord capa) {
        try {
            return ResponseEntity.ok(capaService.updateCapa(id, capa));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCapa(@PathVariable UUID id) {
        try {
            capaService.deleteCapa(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}

