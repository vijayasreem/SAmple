package com.sacral.service;

import com.sacral.model.Applicant;
import com.sacral.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public List<Applicant> findByCreditScoreGreaterThanEqual(int minCreditScore) {
        return applicantRepository.findByCreditScoreGreaterThanEqual(minCreditScore);
    }

    public List<Applicant> findByLoanAmountBetween(double minLoanAmount, double maxLoanAmount) {
        return applicantRepository.findByLoanAmountBetween(minLoanAmount, maxLoanAmount);
    }

    public List<Applicant> findByInterestRateBetween(double minInterestRate, double maxInterestRate) {
        return applicantRepository.findByInterestRateBetween(minInterestRate, maxInterestRate);
    }

    // Other required methods (save, delete, etc.)
}