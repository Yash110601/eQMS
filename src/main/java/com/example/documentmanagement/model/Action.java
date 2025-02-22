package com.example.documentmanagement.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "actions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Action {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String actionName;
}
