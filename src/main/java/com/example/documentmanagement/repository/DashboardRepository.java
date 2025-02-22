package com.example.documentmanagement.repository;



import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.documentmanagement.model.Reminder;

@Repository
public interface DashboardRepository extends BaseRepository<Reminder, UUID> {
    // ✅ Finds reminders within a given date range
    List<Reminder> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
