package com.example.documentmanagement.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reminder_scheduler")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReminderScheduler {

    @Id
    @GeneratedValue
    private UUID id;

    private String frequency;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
}
