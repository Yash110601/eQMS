package com.example.documentmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "connection_mappings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionMapping {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String connectionType;

    private String details;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
