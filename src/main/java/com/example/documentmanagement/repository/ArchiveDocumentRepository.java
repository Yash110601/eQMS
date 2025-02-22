package com.example.documentmanagement.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.documentmanagement.model.ArchiveDocument;

@Repository
public interface ArchiveDocumentRepository extends BaseRepository<ArchiveDocument, UUID> {

    @Query("SELECT d FROM ArchiveDocument d WHERE d.isArchived = true")
    List<ArchiveDocument> getArchiveDocuments();
    
    long countByIsArchivedTrue();
    
    void deleteById(UUID id);
}
