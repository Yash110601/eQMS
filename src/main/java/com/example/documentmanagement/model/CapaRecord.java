package com.example.documentmanagement.model;

import com.example.documentmanagement.enums.CapaStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "capa_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CapaRecord {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CapaStatus status;

    @ManyToOne
    @JoinColumn(name = "assigned_to", referencedColumnName = "id")
    private User assignedTo;

    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "audit_id", referencedColumnName = "id")
    private Audit audit;

    @ManyToOne
    @JoinColumn(name = "issue_report_id", referencedColumnName = "id")
    private IssueReport issueReport;

    @Column(columnDefinition = "TEXT")
    private String rootCauseAnalysis;

    @Column(columnDefinition = "TEXT")
    private String correctiveActionPlan;

    @Column(columnDefinition = "TEXT")
    private String preventiveActionPlan;

    @Column(columnDefinition = "TEXT")
    private String implementationPlan;

    @Column(columnDefinition = "TEXT")
    private String effectivenessVerification;

    private LocalDate completionDate;

    @Column(columnDefinition = "TEXT")
    private String approval;

    @Column(columnDefinition = "TEXT")
    private String supportingDocs;

    private LocalDate closureDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CapaStatus getStatus() {
		return status;
	}

	public void setStatus(CapaStatus status) {
		this.status = status;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Audit getAudit() {
		return audit;
	}

	public void setAudit(Audit audit) {
		this.audit = audit;
	}

	public IssueReport getIssueReport() {
		return issueReport;
	}

	public void setIssueReport(IssueReport issueReport) {
		this.issueReport = issueReport;
	}

	public String getRootCauseAnalysis() {
		return rootCauseAnalysis;
	}

	public void setRootCauseAnalysis(String rootCauseAnalysis) {
		this.rootCauseAnalysis = rootCauseAnalysis;
	}

	public String getCorrectiveActionPlan() {
		return correctiveActionPlan;
	}

	public void setCorrectiveActionPlan(String correctiveActionPlan) {
		this.correctiveActionPlan = correctiveActionPlan;
	}

	public String getPreventiveActionPlan() {
		return preventiveActionPlan;
	}

	public void setPreventiveActionPlan(String preventiveActionPlan) {
		this.preventiveActionPlan = preventiveActionPlan;
	}

	public String getImplementationPlan() {
		return implementationPlan;
	}

	public void setImplementationPlan(String implementationPlan) {
		this.implementationPlan = implementationPlan;
	}

	public String getEffectivenessVerification() {
		return effectivenessVerification;
	}

	public void setEffectivenessVerification(String effectivenessVerification) {
		this.effectivenessVerification = effectivenessVerification;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public String getApproval() {
		return approval;
	}

	public void setApproval(String approval) {
		this.approval = approval;
	}

	public String getSupportingDocs() {
		return supportingDocs;
	}

	public void setSupportingDocs(String supportingDocs) {
		this.supportingDocs = supportingDocs;
	}

	public LocalDate getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(LocalDate closureDate) {
		this.closureDate = closureDate;
	}
    
}
