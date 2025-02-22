package com.example.documentmanagement.service.logging;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentmanagement.model.User;
import com.example.documentmanagement.model.logging.SystemAuditLog;
import com.example.documentmanagement.repository.logging.SystemAuditLogRepository;

@Service
public class AuditLoggingService {

    @Autowired
    private SystemAuditLogRepository logRepository;

    public void logAction(String entityName, UUID entityId, String action, User performedBy, String oldValue, String newValue) {
        SystemAuditLog log = new SystemAuditLog();
        log.setEntityName(entityName);
        log.setEntityId(entityId);
        log.setAction(action);
        log.setPerformedBy(performedBy);
        log.setOldValue(oldValue);
        log.setNewValue(newValue);
        logRepository.save(log);
    }
}
