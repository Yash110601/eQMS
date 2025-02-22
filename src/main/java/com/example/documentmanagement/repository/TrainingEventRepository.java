package com.example.documentmanagement.repository;

import com.example.documentmanagement.enums.TrainingStatus;
import com.example.documentmanagement.model.TrainingEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TrainingEventRepository extends JpaRepository<TrainingEvent, UUID> {
    List<TrainingEvent> findByAssignedUserId(UUID userId);
    List<TrainingEvent> findByStatus(TrainingStatus status);
    Optional<TrainingEvent> findById(UUID id);

    // ✅ Fix: Add method to filter by scheduled date range
    List<TrainingEvent> findByScheduledDateBetween(LocalDateTime start, LocalDateTime end);
}
