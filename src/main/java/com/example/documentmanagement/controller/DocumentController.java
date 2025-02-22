package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.Document;
import com.example.documentmanagement.service.DocumentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @GetMapping
    public ResponseEntity<Page<Document>> getAllDocuments(Pageable pageable) {
        return ResponseEntity.ok(documentService.getAllDocuments(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable UUID id) {
        Optional<Document> document = documentService.getDocumentById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Document> createDocument(@Valid @RequestBody Document document) {
        return ResponseEntity.ok(documentService.createDocument(document));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable UUID id, @Valid @RequestBody Document document) {
        return ResponseEntity.ok(documentService.updateDocument(id, document));
    }

    @PatchMapping("/{id}/delete")
    public ResponseEntity<Document> softDeleteDocument(@PathVariable UUID id) {
        return ResponseEntity.ok(documentService.softDeleteDocument(id));
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<Document> restoreDocument(@PathVariable UUID id) {
        return ResponseEntity.ok(documentService.restoreDocument(id));
    }
}
