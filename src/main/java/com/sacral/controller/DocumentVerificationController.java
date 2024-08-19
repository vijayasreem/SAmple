package com.sacral.controller;

import com.sacral.service.DocumentVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentVerificationController {

    private final DocumentVerificationService documentVerificationService;

    @Autowired
    public DocumentVerificationController(DocumentVerificationService documentVerificationService) {
        this.documentVerificationService = documentVerificationService;
    }

    @GetMapping("/openApp")
    public void openDocumentVerificationApp() {
        documentVerificationService.openDocumentVerificationApp();
    }

    @GetMapping("/verifyIdentity/{identity}")
    public String verifyIdentity(@PathVariable String identity) {
        return documentVerificationService.verifyIdentity(identity);
    }

    @GetMapping("/verifyAddress/{address}")
    public String verifyAddress(@PathVariable String address) {
        return documentVerificationService.verifyAddress(address);
    }

    @GetMapping("/determineEligibility/{identityVerificationResult}/{addressVerificationResult}")
    public void determineEligibilityForBankingServices(@PathVariable String identityVerificationResult, @PathVariable String addressVerificationResult) {
        documentVerificationService.determineEligibilityForBankingServices(identityVerificationResult, addressVerificationResult);
    }

    @GetMapping("/validateCredit/{annualIncome}/{creditScore}")
    public void validateCreditEvaluation(@PathVariable int annualIncome, @PathVariable int creditScore) {
        documentVerificationService.validateCreditEvaluation(annualIncome, creditScore);
    }

    @GetMapping("/closeApp")
    public void closeDocumentVerificationApp() {
        documentVerificationService.closeDocumentVerificationApp();
    }
}