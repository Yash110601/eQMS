package com.example.documentmanagement.model;


import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "company_profiles")
public class CompanyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String logoUrl;
    private String bannerUrl;
    private String location;

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private UUID createdBy;

    private UUID modifiedBy;

    public CompanyProfile() {}

    public CompanyProfile(UUID id, String title, String logoUrl, String bannerUrl, String location, boolean isDeleted, UUID createdBy, UUID modifiedBy) {
        this.id = id;
        this.title = title;
        this.logoUrl = logoUrl;
        this.bannerUrl = bannerUrl;
        this.location = location;
        this.isDeleted = isDeleted;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    // ✅ Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLogoUrl() { return logoUrl; }
    public void setLogoUrl(String logoUrl) { this.logoUrl = logoUrl; }

    public String getBannerUrl() { return bannerUrl; }
    public void setBannerUrl(String bannerUrl) { this.bannerUrl = bannerUrl; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean deleted) { isDeleted = deleted; }

    public UUID getCreatedBy() { return createdBy; }
    public void setCreatedBy(UUID createdBy) { this.createdBy = createdBy; }

    public UUID getModifiedBy() { return modifiedBy; }
    public void setModifiedBy(UUID modifiedBy) { this.modifiedBy = modifiedBy; }
}
