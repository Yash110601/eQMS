package com.example.documentmanagement.controller;

import com.example.documentmanagement.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-training-reminder")
    public ResponseEntity<String> sendTrainingReminder(@RequestBody Map<String, String> request) {
        String toEmail = request.get("toEmail");
        String subject = request.get("subject");
        String body = request.get("body");

        try {
            emailService.sendEmail(toEmail, subject, body);
            return ResponseEntity.ok("Email sent successfully to " + toEmail);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Email sending failed: " + e.getMessage());
        }
    }
}
