package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Audit;
import com.example.documentmanagement.model.CapaRecord;
import com.example.documentmanagement.model.IssueReport;
import com.example.documentmanagement.repository.AuditRepository;
import com.example.documentmanagement.repository.CapaRepository;
import com.example.documentmanagement.repository.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CapaService {

    @Autowired
    private CapaRepository capaRepository;

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private IssueReportRepository issueReportRepository;

    public List<CapaRecord> getAllCapas() {
        return capaRepository.findAll();
    }

    public Optional<CapaRecord> getCapaById(UUID id) {
        return capaRepository.findById(id);
    }

    public CapaRecord createCapa(CapaRecord capa) {
        if (capa.getTitle() == null || capa.getStatus() == null) {
            throw new IllegalArgumentException("Title and status cannot be null.");
        }

        // ✅ Debugging: Print received UUIDs before processing
        System.out.println("Received Audit ID: " + (capa.getAudit() != null ? capa.getAudit().getId() : "NULL"));

        if (capa.getAudit() != null && capa.getAudit().getId() != null) {
            Optional<Audit> audit = auditRepository.findById(capa.getAudit().getId());
            if (audit.isPresent()) {
                capa.setAudit(audit.get());
            } else {
                throw new IllegalArgumentException("Audit ID not found: " + capa.getAudit().getId());
            }
        }

        return capaRepository.save(capa);
    }


    public CapaRecord updateCapa(UUID id, CapaRecord capaDetails) {
        return capaRepository.findById(id).map(capa -> {
            capa.setTitle(capaDetails.getTitle());
            capa.setDescription(capaDetails.getDescription());
            capa.setStatus(capaDetails.getStatus());
            capa.setDueDate(capaDetails.getDueDate());

            // ✅ Ensure Audit is updated correctly
            if (capaDetails.getAudit() != null) {
                Optional<Audit> audit = auditRepository.findById(capaDetails.getAudit().getId());
                audit.ifPresent(capa::setAudit);
            }

            // ✅ Ensure Issue Report is updated correctly
            if (capaDetails.getIssueReport() != null) {
                Optional<IssueReport> issueReport = issueReportRepository.findById(capaDetails.getIssueReport().getId());
                issueReport.ifPresent(capa::setIssueReport);
            }

            return capaRepository.save(capa);
        }).orElseThrow(() -> new RuntimeException("CAPA Record not found"));
    }

    public void deleteCapa(UUID id) {
        if (!capaRepository.existsById(id)) {
            throw new RuntimeException("CAPA not found.");
        }
        capaRepository.deleteById(id);
    }
}
