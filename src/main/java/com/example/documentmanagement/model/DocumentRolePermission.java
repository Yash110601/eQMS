package com.example.documentmanagement.model;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "document_role_permissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRolePermission {

    @Id
    @GeneratedValue
    private UUID id;

    private String roleName;
    private String permissionType;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
}
