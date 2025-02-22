package com.example.documentmanagement.controller;

import com.example.documentmanagement.service.AuditReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/audits")
public class AuditReportController {

    @Autowired
    private AuditReportService auditReportService;

    @GetMapping("/{id}/report")
    public ResponseEntity<byte[]> generateAuditReport(@PathVariable UUID id) {
        byte[] pdfBytes = auditReportService.generateAuditReport(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=audit_report_" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
