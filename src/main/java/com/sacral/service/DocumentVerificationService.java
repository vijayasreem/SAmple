package com.sacral.service;

import com.sacral.model.DocumentVerification;
import com.sacral.repository.DocumentVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentVerificationService {

    private final DocumentVerificationRepository documentVerificationRepository;

    @Autowired
    public DocumentVerificationService(DocumentVerificationRepository documentVerificationRepository) {
        this.documentVerificationRepository = documentVerificationRepository;
    }

    public void openDocumentVerificationApp() {
        System.out.println("Welcome to the Document Verification App!");
    }

    public String verifyIdentity(String identity) {
        // Perform identity verification logic here
        if (identity.equals("verified")) {
            return "yes";
        } else {
            return "no";
        }
    }

    public String verifyAddress(String address) {
        // Perform address verification logic here
        if (address.equals("verified")) {
            return "yes";
        } else {
            return "no";
        }
    }

    public void determineEligibilityForBankingServices(String identityVerificationResult, String addressVerificationResult) {
        if (identityVerificationResult.equals("yes") && addressVerificationResult.equals("yes")) {
            System.out.println("Congratulations! You are eligible for banking services.");
        } else {
            System.out.println("Incomplete document verification. You are not eligible for banking services.");
        }
    }

    public void validateCreditEvaluation(int annualIncome, int creditScore) {
        if (annualIncome >= 30000 && creditScore >= 700) {
            System.out.println("Congratulations! You are eligible for a high-limit credit score.");
        } else if (annualIncome >= 20000 && creditScore >= 600) {
            System.out.println("You are eligible for a moderate-limit credit score.");
        } else {
            System.out.println("You are not eligible for a credit score.");
        }
    }

    public void closeDocumentVerificationApp() {
        // Close any resources here
        System.out.println("Closing the Document Verification App. Goodbye!");
    }
}