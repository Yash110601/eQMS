package com.example.documentmanagement.model;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reminders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String reminderText;

    @Column(nullable = false)
    private LocalDate date;  // ✅ Added date field

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;
}
