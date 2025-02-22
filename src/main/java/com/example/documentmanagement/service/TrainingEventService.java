package com.example.documentmanagement.service;

import com.example.documentmanagement.model.TrainingEvent;
import com.example.documentmanagement.repository.TrainingEventRepository;

import jakarta.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TrainingEventService {

    @Autowired
    private TrainingEventRepository trainingEventRepository;

    @Autowired
    private EmailService emailService;

    public List<TrainingEvent> getAllTrainings() {
        return trainingEventRepository.findAll();
    }

    public TrainingEvent getTrainingById(UUID id) {
        return trainingEventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Training event not found with ID: " + id));  
    }

    // ✅ Run every day at 9 AM to send reminders
    @Scheduled(cron = "0 0 9 * * ?")
    public void sendTrainingReminders() {
        LocalDateTime tomorrowStart = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime tomorrowEnd = LocalDateTime.now().plusDays(1).withHour(23).withMinute(59).withSecond(59);

        List<TrainingEvent> upcomingTrainings = trainingEventRepository.findByScheduledDateBetween(tomorrowStart, tomorrowEnd);

        for (TrainingEvent training : upcomingTrainings) {
            String email = training.getAssignedUser().getUsername() + "@example.com"; 
            String subject = "Training Reminder: " + training.getTitle();
            String body = "Hello, your training session \"" + training.getTitle() + "\" is scheduled for " + training.getScheduledDate();

            try {
				emailService.sendEmail(email, subject, body);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
