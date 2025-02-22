package com.example.documentmanagement.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.documentmanagement.model.Audit;
import com.example.documentmanagement.service.AuditService;

@RestController
@RequestMapping("/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PreAuthorize("hasAnyRole('ADMIN', 'AUDITOR')")
    @GetMapping
    public List<Audit> getAllAudits() {
        return auditService.getAllAudits();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Audit createAudit(@RequestBody Audit audit) {
        return auditService.createAudit(audit);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAudit(@PathVariable UUID id) {
        auditService.deleteAudit(id);
        return ResponseEntity.ok("Audit deleted successfully");
    }
}
