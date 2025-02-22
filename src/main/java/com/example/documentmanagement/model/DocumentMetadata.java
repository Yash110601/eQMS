package com.example.documentmanagement.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "document_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentMetadata {
    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "metadata_key", nullable = false) // ✅ Renamed from "key" to "metadata_key"
    private String key;

    private String value;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
