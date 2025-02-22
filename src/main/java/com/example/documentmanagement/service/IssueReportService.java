package com.example.documentmanagement.service;

import com.example.documentmanagement.model.IssueReport;
import com.example.documentmanagement.repository.IssueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class IssueReportService {

    @Autowired
    private IssueReportRepository issueReportRepository;

    public List<IssueReport> getAllIssues() {
        return issueReportRepository.findAll();
    }

    public Optional<IssueReport> getIssueById(UUID id) {
        return issueReportRepository.findById(id);
    }

    public IssueReport createIssue(IssueReport issueReport) {
        return issueReportRepository.save(issueReport);
    }

    public void deleteIssue(UUID id) {
        issueReportRepository.deleteById(id);
    }
}
