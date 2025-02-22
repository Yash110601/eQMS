package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.DocumentComment;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentCommentRepository extends BaseRepository<DocumentComment, UUID> {

    List<DocumentComment> findByDocumentId(UUID documentId);

    void deleteByDocumentId(UUID documentId);
}
