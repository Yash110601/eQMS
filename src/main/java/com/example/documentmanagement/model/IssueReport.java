package com.example.documentmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

import com.example.documentmanagement.enums.IssueStatus;

@Entity
@Table(name = "issue_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueReport {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "reported_by", referencedColumnName = "id")
    private User reportedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IssueStatus status; // Open, Investigating, Resolved

    @ManyToOne
    @JoinColumn(name = "capa_id", referencedColumnName = "id")
    private CapaRecord capa;

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

	public User getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(User reportedBy) {
		this.reportedBy = reportedBy;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public CapaRecord getCapa() {
		return capa;
	}

	public void setCapa(CapaRecord capa) {
		this.capa = capa;
	}
    
}
