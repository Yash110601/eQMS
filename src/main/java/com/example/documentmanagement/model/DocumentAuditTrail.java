package com.example.documentmanagement.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "document_audit_trails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentAuditTrail {

    @Id
    @GeneratedValue
    private UUID id;

    private String action;
    private UUID performedBy;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public UUID getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(UUID performedBy) {
		this.performedBy = performedBy;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
}
