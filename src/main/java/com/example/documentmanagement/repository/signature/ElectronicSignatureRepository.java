package com.example.documentmanagement.repository.signature;

import com.example.documentmanagement.model.signature.ElectronicSignature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ElectronicSignatureRepository extends JpaRepository<ElectronicSignature, UUID> {
}
