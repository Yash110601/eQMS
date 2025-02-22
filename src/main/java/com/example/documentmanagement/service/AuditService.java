package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Audit;
import com.example.documentmanagement.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    public List<Audit> getAllAudits() {
        return auditRepository.findAll();
    }

    public Optional<Audit> getAuditById(UUID id) {
        return auditRepository.findById(id);
    }

    public Audit createAudit(Audit audit) {
        if (audit.getStatus() == null) {  // ✅ Prevent NULL values
            throw new IllegalArgumentException("Status cannot be null");
        }
        return auditRepository.save(audit);
    }

    public void deleteAudit(UUID id) {
        auditRepository.deleteById(id);
    }
}
