package com.example.documentmanagement.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentmanagement.model.Reminder;
import com.example.documentmanagement.repository.DashboardRepository;

@Service
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;

    public List<Reminder> getRemindersByMonthAndYear(int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        return dashboardRepository.findByDateBetween(startDate, endDate);
    }
}
