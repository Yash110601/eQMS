package com.example.documentmanagement.repository;

import com.example.documentmanagement.enums.CapaStatus;
import com.example.documentmanagement.model.CapaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CapaRepository extends JpaRepository<CapaRecord, UUID> {
	
	  Optional<CapaRecord> findById(UUID id);

    // ✅ Fetch CAPA records by status
    List<CapaRecord> findByStatus(CapaStatus status);

    // ✅ Fetch CAPA records by Audit ID
    List<CapaRecord> findByAuditId(UUID auditId);

    // ✅ Fetch CAPA records by Issue Report ID
    List<CapaRecord> findByIssueReportId(UUID issueReportId);

    // ✅ Fetch CAPA records by due date
    List<CapaRecord> findByDueDate(LocalDate dueDate);

    // ✅ Fetch CAPA records by closure date
    List<CapaRecord> findByClosureDate(LocalDate closureDate);
}
