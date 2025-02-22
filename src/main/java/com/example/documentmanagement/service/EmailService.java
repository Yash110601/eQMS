package com.example.documentmanagement.service;

import org.springframework.stereotype.Service;
import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.util.Properties;

@Service
public class EmailService {

    public void sendEmail(String toEmail, String subject, String body) throws MessagingException {
        // Assuming SMTP configuration is set up
        String fromEmail = "patil.yashraje@gmail.com";
        String host = "smtp.gmail.com";
        final String username = "patil.yashraje@gmail.com";
        final String password = "exeq jnjw vney bbcq";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
    }
}
