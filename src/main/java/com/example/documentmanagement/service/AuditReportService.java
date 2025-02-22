package com.example.documentmanagement.service;

import com.example.documentmanagement.model.Audit;
import com.example.documentmanagement.repository.AuditRepository;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuditReportService {

    @Autowired
    private AuditRepository auditRepository;

    public byte[] generateAuditReport(UUID auditId) {
        Optional<Audit> auditOptional = auditRepository.findById(auditId);
        if (!auditOptional.isPresent()) {
            throw new RuntimeException("Audit not found with ID: " + auditId);
        }

        Audit audit = auditOptional.get();
        
        // PDF ByteArray Stream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        // Title
        document.add(new Paragraph("Audit Report").setBold().setFontSize(18));
        document.add(new Paragraph("Audit ID: " + audit.getId()));
        document.add(new Paragraph("Title: " + audit.getTitle()));
        document.add(new Paragraph("Status: " + audit.getStatus().toString()));
        document.add(new Paragraph("Audit Date: " + audit.getAuditDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));

        if (audit.getAuditor() != null) {
            document.add(new Paragraph("Auditor: " + audit.getAuditor().getUsername()));
        }

        if (audit.getDocument() != null) {
            document.add(new Paragraph("Related Document: " + audit.getDocument().getName()));
        }

        document.close();
        return byteArrayOutputStream.toByteArray();
    }
}
