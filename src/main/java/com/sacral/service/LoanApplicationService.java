package com.sacral.service;

import com.sacral.model.LoanApplication;
import com.sacral.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public List<LoanApplication> findByCustomerId(Long customerId) {
        return loanApplicationRepository.findByCustomerId(customerId);
    }

    public List<LoanApplication> findByStatus(String status) {
        return loanApplicationRepository.findByStatus(status);
    }

    public List<LoanApplication> findByLoanAmountRange(Double minAmount, Double maxAmount) {
        return loanApplicationRepository.findByLoanAmountRange(minAmount, maxAmount);
    }

    public List<LoanApplication> findByEmploymentStatus(String employmentStatus) {
        return loanApplicationRepository.findByEmploymentStatus(employmentStatus);
    }

    public List<LoanApplication> findByCreditScoreRange(Integer minScore, Integer maxScore) {
        return loanApplicationRepository.findByCreditScoreRange(minScore, maxScore);
    }

    public List<LoanApplication> findByApprovalStatus(String approvalStatus) {
        return loanApplicationRepository.findByApprovalStatus(approvalStatus);
    }

    public List<LoanApplication> findBySubmissionDateRange(LocalDate startDate, LocalDate endDate) {
        return loanApplicationRepository.findBySubmissionDateRange(startDate, endDate);
    }
}