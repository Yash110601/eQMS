package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.DocumentAuditTrail;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentAuditTrailRepository extends BaseRepository<DocumentAuditTrail, UUID> {

    List<DocumentAuditTrail> findByDocumentId(UUID documentId);
}
