package com.example.documentmanagement.controller.signature;

import com.example.documentmanagement.model.signature.ElectronicSignature;
import com.example.documentmanagement.service.signature.ElectronicSignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signatures")
public class ElectronicSignatureController {

    @Autowired
    private ElectronicSignatureService signatureService;

    @GetMapping
    public List<ElectronicSignature> getAllSignatures() {
        return signatureService.getAllSignatures();
    }

    @PostMapping
    public ElectronicSignature createSignature(@RequestBody ElectronicSignature signature) {
        return signatureService.createSignature(signature);
    }
}
