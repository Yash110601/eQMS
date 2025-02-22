package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.CapaRecord;
import com.example.documentmanagement.service.CapaService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private CapaService capaService;

    // ✅ **All CAPA Reports in Horizontal Table Format**
    @GetMapping("/generate")
    public ResponseEntity<ByteArrayResource> generateAllCapaPdf() {
        List<CapaRecord> capaRecords = capaService.getAllCapas();
        if (capaRecords.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return generateHorizontalCapaPdf(capaRecords, "CAPA_Report_All.pdf");
    }

    // ✅ **Single CAPA Report in Vertical Format**
    @GetMapping("/generate/{id}")
    public ResponseEntity<ByteArrayResource> generateSingleCapaPdf(@PathVariable UUID id) {
        Optional<CapaRecord> capaOptional = capaService.getCapaById(id);
        if (capaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return generateVerticalCapaPdf(capaOptional.get(), "CAPA_Report_" + id + ".pdf");
    }

    // ✅ **Method to Generate Horizontal Table Format for All CAPA Records**
    private ResponseEntity<ByteArrayResource> generateHorizontalCapaPdf(List<CapaRecord> capaRecords, String filename) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // ✅ Title and Date
            document.add(new Paragraph("Corrective and Preventive Action (CAPA) Report").setBold().setFontSize(16));
            document.add(new Paragraph("Generated on: " + LocalDate.now()).setItalic().setFontSize(10));
            document.add(new Paragraph("\n"));

            // ✅ Table Header (Horizontal Format)
            float[] columnWidths = {80f, 200f, 200f, 200f, 200f, 200f, 200f, 200f, 120f, 120f, 120f, 120f};
            Table table = new Table(columnWidths);

            table.addHeaderCell(new Cell().add(new Paragraph("CAPA ID").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Title").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Problem Description").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Root Cause Analysis").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Corrective Action Plan").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Preventive Action Plan").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Implementation Plan").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Effectiveness Verification").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Completion Date").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Approval").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Supporting Docs").setBold()));
            table.addHeaderCell(new Cell().add(new Paragraph("Closure Date").setBold()));

            // ✅ Table Content (Loop through CAPA records)
            for (CapaRecord capa : capaRecords) {
                table.addCell(capa.getId().toString());
                table.addCell(capa.getTitle());
                table.addCell(getNonEmptyValue(capa.getDescription()));
                table.addCell(getNonEmptyValue(capa.getRootCauseAnalysis()));
                table.addCell(getNonEmptyValue(capa.getCorrectiveActionPlan()));
                table.addCell(getNonEmptyValue(capa.getPreventiveActionPlan()));
                table.addCell(getNonEmptyValue(capa.getImplementationPlan()));
                table.addCell(getNonEmptyValue(capa.getEffectivenessVerification()));
                table.addCell(capa.getCompletionDate() != null ? capa.getCompletionDate().toString() : "N/A");
                table.addCell(getNonEmptyValue(capa.getApproval()));
                table.addCell(getNonEmptyValue(capa.getSupportingDocs()));
                table.addCell(capa.getClosureDate() != null ? capa.getClosureDate().toString() : "N/A");
            }

            document.add(table);
            document.close();

            ByteArrayResource resource = new ByteArrayResource(byteArrayOutputStream.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // ✅ **Method to Generate Vertical Format for Single CAPA Record**
    private ResponseEntity<ByteArrayResource> generateVerticalCapaPdf(CapaRecord capa, String filename) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(byteArrayOutputStream);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            document.add(new Paragraph("Corrective and Preventive Action (CAPA) Report").setBold().setFontSize(16));
            document.add(new Paragraph("Generated on: " + LocalDate.now()).setItalic().setFontSize(10));
            document.add(new Paragraph("\n"));

            float[] columnWidths = {200f, 400f};
            Table table = new Table(columnWidths);
            
            table.addCell(new Cell().add(new Paragraph("CAPA ID").setBold()));
            table.addCell(new Cell().add(new Paragraph(capa.getId().toString())));

            table.addCell(new Cell().add(new Paragraph("Title").setBold()));
            table.addCell(new Cell().add(new Paragraph(capa.getTitle())));

            table.addCell(new Cell().add(new Paragraph("Problem Description").setBold()));
            table.addCell(new Cell().add(new Paragraph(getNonEmptyValue(capa.getDescription()))));

            table.addCell(new Cell().add(new Paragraph("Root Cause Analysis").setBold()));
            table.addCell(new Cell().add(new Paragraph(getNonEmptyValue(capa.getRootCauseAnalysis()))));

            table.addCell(new Cell().add(new Paragraph("Corrective Action Plan").setBold()));
            table.addCell(new Cell().add(new Paragraph(getNonEmptyValue(capa.getCorrectiveActionPlan()))));

            table.addCell(new Cell().add(new Paragraph("Preventive Action Plan").setBold()));
            table.addCell(new Cell().add(new Paragraph(getNonEmptyValue(capa.getPreventiveActionPlan()))));

            table.addCell(new Cell().add(new Paragraph("Implementation Plan").setBold()));
            table.addCell(new Cell().add(new Paragraph(getNonEmptyValue(capa.getImplementationPlan()))));

            table.addCell(new Cell().add(new Paragraph("Effectiveness Verification").setBold()));
            table.addCell(new Cell().add(new Paragraph(getNonEmptyValue(capa.getEffectivenessVerification()))));

            document.add(table);
            document.close();

            ByteArrayResource resource = new ByteArrayResource(byteArrayOutputStream.toByteArray());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    private String getNonEmptyValue(String value) {
        return (value != null && !value.trim().isEmpty()) ? value : "N/A";
    }
}
