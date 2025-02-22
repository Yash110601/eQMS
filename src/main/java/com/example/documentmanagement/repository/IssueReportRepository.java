package com.example.documentmanagement.repository;

import com.example.documentmanagement.model.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IssueReportRepository extends JpaRepository<IssueReport, UUID> {

    // Fetch all issues by a specific status
    List<IssueReport> findByStatus(String status);

    // Fetch all issues reported by a specific user
    List<IssueReport> findByReportedById(UUID reportedById);
}
