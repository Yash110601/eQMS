package com.example.documentmanagement.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "document_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentComment {
    
    @Id
    @GeneratedValue
    private UUID id;

    private String comment;
    private UUID createdBy;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public UUID getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}
}
