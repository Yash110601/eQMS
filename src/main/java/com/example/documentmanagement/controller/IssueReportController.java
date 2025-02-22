package com.example.documentmanagement.controller;

import com.example.documentmanagement.model.IssueReport;
import com.example.documentmanagement.service.IssueReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/issues")
public class IssueReportController {

    @Autowired
    private IssueReportService issueReportService;

    @GetMapping
    public List<IssueReport> getAllIssues() {
        return issueReportService.getAllIssues();
    }

    @GetMapping("/{id}")
    public Optional<IssueReport> getIssueById(@PathVariable UUID id) {
        return issueReportService.getIssueById(id);
    }

    @PostMapping
    public IssueReport createIssue(@RequestBody IssueReport issueReport) {
        return issueReportService.createIssue(issueReport);
    }

    @DeleteMapping("/{id}")
    public void deleteIssue(@PathVariable UUID id) {
        issueReportService.deleteIssue(id);
    }
}
