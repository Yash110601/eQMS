package com.example.documentmanagement.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "document_user_permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentUserPermission {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;
    private String permissionType;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
}
