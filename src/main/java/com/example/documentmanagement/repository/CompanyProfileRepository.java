package com.example.documentmanagement.repository;


import java.util.UUID;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.documentmanagement.model.CompanyProfile;

@Repository
public interface CompanyProfileRepository extends BaseRepository<CompanyProfile, UUID> {
    
    CompanyProfile findFirstByOrderByIdAsc();
}
