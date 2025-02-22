package com.example.documentmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

import com.example.documentmanagement.enums.TrainingStatus;

import java.time.LocalDate;

@Entity
@Table(name = "training_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingRecord {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id", referencedColumnName = "id", nullable = false)
    private Document document;

    @Column(nullable = false)
    private LocalDate trainingDate;

    @Enumerated(EnumType.STRING)
    private TrainingStatus status; // PENDING, COMPLETED

    private String certificateUrl;

	public String getCertificateUrl() {
		return certificateUrl;
	}

	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public LocalDate getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(LocalDate trainingDate) {
		this.trainingDate = trainingDate;
	}

	public TrainingStatus getStatus() {
		return status;
	}

	public void setStatus(TrainingStatus status) {
		this.status = status;
	}
	
}
