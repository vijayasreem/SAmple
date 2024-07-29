package com.sacral.controller;

import com.sacral.model.Applicant;
import com.sacral.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/credit-score/{minCreditScore}")
    public List<Applicant> findByCreditScoreGreaterThanEqual(@PathVariable int minCreditScore) {
        return applicantService.findByCreditScoreGreaterThanEqual(minCreditScore);
    }

    @GetMapping("/loan-amount/{minLoanAmount}/{maxLoanAmount}")
    public List<Applicant> findByLoanAmountBetween(@PathVariable double minLoanAmount, @PathVariable double maxLoanAmount) {
        return applicantService.findByLoanAmountBetween(minLoanAmount, maxLoanAmount);
    }

    @GetMapping("/interest-rate/{minInterestRate}/{maxInterestRate}")
    public List<Applicant> findByInterestRateBetween(@PathVariable double minInterestRate, @PathVariable double maxInterestRate) {
        return applicantService.findByInterestRateBetween(minInterestRate, maxInterestRate);
    }

    // Other required methods (save, delete, etc.)
}