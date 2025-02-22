package com.example.documentmanagement.model;

import com.example.documentmanagement.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @JsonIgnore  // ✅ Prevent infinite loop
    @OneToMany(mappedBy = "assignedUser", fetch = FetchType.LAZY)
    private List<TrainingEvent> trainingEvents;

    // ✅ Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public List<TrainingEvent> getTrainingEvents() { return trainingEvents; }
    public void setTrainingEvents(List<TrainingEvent> trainingEvents) { this.trainingEvents = trainingEvents; }
}
