package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.TrainingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TrainingRecordRepository extends JpaRepository<TrainingRecord, UUID> {

    // Fetch all training records for a specific user
    List<TrainingRecord> findByUserId(UUID userId);

    // Fetch all training records by status (Pending, Completed)
    List<TrainingRecord> findByStatus(String status);
}
