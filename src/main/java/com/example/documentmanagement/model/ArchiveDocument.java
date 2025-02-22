package com.example.documentmanagement.model;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "archive_documents")
public class ArchiveDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String url;

    @Column(nullable = false)
    private boolean isArchived;

    @Column(nullable = false)
    private UUID createdBy;

    public ArchiveDocument() {}

    public ArchiveDocument(UUID id, String name, String description, String url, boolean isArchived, UUID createdBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.isArchived = isArchived;
        this.createdBy = createdBy;
    }

    // ✅ Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public boolean isArchived() { return isArchived; }
    public void setArchived(boolean archived) { isArchived = archived; }

    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }
}
