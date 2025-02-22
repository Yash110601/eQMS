package com.example.documentmanagement.service.signature;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.documentmanagement.model.signature.ElectronicSignature;
import com.example.documentmanagement.repository.signature.ElectronicSignatureRepository;

@Service
public class ElectronicSignatureService {

    @Autowired
    private ElectronicSignatureRepository repository;

    public List<ElectronicSignature> getAllSignatures() {
        return repository.findAll();
    }

    public ElectronicSignature createSignature(ElectronicSignature signature) {
        return repository.save(signature);
    }
}
