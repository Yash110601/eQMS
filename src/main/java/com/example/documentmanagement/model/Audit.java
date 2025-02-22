package com.example.documentmanagement.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import com.example.documentmanagement.enums.AuditStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "audits")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Audit {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(name = "audit_date", nullable = false) // ✅ Ensures correct mapping
    private LocalDate auditDate;

    @ManyToOne
    @JoinColumn(name = "auditor_id", referencedColumnName = "id", nullable = false)
    private User auditor;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditStatus status; // PLANNED, IN_PROGRESS, COMPLETED

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id", nullable = true)
    private Document document;
    
    @Version
    @Column(nullable = false)
    private Long version = 0L;  // ✅ Ensure version is initialized

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    // ✅ Getter & Setter Methods
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(LocalDate auditDate) {
        this.auditDate = auditDate;
    }

    public User getAuditor() {
        return auditor;
    }

    public void setAuditor(User auditor) {
        this.auditor = auditor;
    }

    public AuditStatus getStatus() {
        return status;
    }

    public void setStatus(AuditStatus status) {
        this.status = status;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Audit [id=" + id + ", title=" + title + ", auditDate=" + auditDate + ", auditor=" + auditor
                + ", status=" + status + ", document=" + document + ", version=" + version + "]";
    }
    
    
    @OneToMany(mappedBy = "audit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CapaRecord> capaRecords;  // ✅ Link Audit to CAPA records
}
