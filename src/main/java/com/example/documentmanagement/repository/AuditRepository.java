package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.Audit;
import com.example.documentmanagement.enums.AuditStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface AuditRepository extends JpaRepository<Audit, UUID> {
    List<Audit> findByStatus(AuditStatus status);
    List<Audit> findByAuditorId(UUID auditorId);
}
