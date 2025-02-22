package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Document;
import com.example.documentmanagement.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Page<Document> getAllDocuments(Pageable pageable) {
        return documentRepository.findAllByIsDeletedFalse(pageable);
    }

    public Optional<Document> getDocumentById(UUID id) {
        return documentRepository.findByIdAndIsDeletedFalse(id);
    }

    public Document createDocument(Document document) {
        document.setDeleted(false);
        return documentRepository.save(document);
    }

    public Document updateDocument(UUID id, Document updatedDocument) {
        return documentRepository.findById(id).map(existingDoc -> {
            existingDoc.setName(updatedDocument.getName());
            existingDoc.setDescription(updatedDocument.getDescription());
            existingDoc.setUrl(updatedDocument.getUrl());
            existingDoc.setLocation(updatedDocument.getLocation());
            return documentRepository.save(existingDoc);
        }).orElseThrow(() -> new RuntimeException("Document not found"));
    }

    public Document softDeleteDocument(UUID id) {
        return documentRepository.findById(id).map(doc -> {
            doc.setDeleted(true);
            return documentRepository.save(doc);
        }).orElseThrow(() -> new RuntimeException("Document not found"));
    }

    public Document restoreDocument(UUID id) {
        return documentRepository.findById(id).map(doc -> {
            doc.setDeleted(false);
            return documentRepository.save(doc);
        }).orElseThrow(() -> new RuntimeException("Document not found"));
    }
}
