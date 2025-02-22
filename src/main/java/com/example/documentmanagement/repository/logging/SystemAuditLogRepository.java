package com.example.documentmanagement.repository.logging;

import com.example.documentmanagement.model.logging.SystemAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SystemAuditLogRepository extends JpaRepository<SystemAuditLog, UUID> {
}
