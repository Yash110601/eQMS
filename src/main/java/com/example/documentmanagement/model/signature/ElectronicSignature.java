package com.example.documentmanagement.model.signature;

import java.time.LocalDateTime;
import java.util.UUID;

import com.example.documentmanagement.model.Audit;
import com.example.documentmanagement.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "electronic_signatures")
public class ElectronicSignature {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private Audit audit;

    @ManyToOne
    @JoinColumn(name = "signed_by", nullable = false)
    private User signedBy;

    @Column(nullable = false)
    private LocalDateTime signedAt = LocalDateTime.now();

    @Column(nullable = false)
    private String reason;

    // Getters & Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Audit getAudit() {
        return audit;
    }
    public void setAudit(Audit audit) {
        this.audit = audit;
    }
    public User getSignedBy() {
        return signedBy;
    }
    public void setSignedBy(User signedBy) {
        this.signedBy = signedBy;
    }
    public LocalDateTime getSignedAt() {
        return signedAt;
    }
    public void setSignedAt(LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}
