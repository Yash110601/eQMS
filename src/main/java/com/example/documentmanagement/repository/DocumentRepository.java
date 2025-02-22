package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DocumentRepository extends JpaRepository<Document, UUID> {

    Page<Document> findAllByIsDeletedFalse(Pageable pageable);

    Optional<Document> findByIdAndIsDeletedFalse(UUID id);
}
