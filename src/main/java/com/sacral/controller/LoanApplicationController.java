package com.sacral.controller;

import com.sacral.model.LoanApplication;
import com.sacral.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/customer/{customerId}")
    public List<LoanApplication> findByCustomerId(@PathVariable Long customerId) {
        return loanApplicationService.findByCustomerId(customerId);
    }

    @GetMapping("/status/{status}")
    public List<LoanApplication> findByStatus(@PathVariable String status) {
        return loanApplicationService.findByStatus(status);
    }

    @GetMapping("/loan-amount-range")
    public List<LoanApplication> findByLoanAmountRange(@RequestParam("minAmount") Double minAmount, @RequestParam("maxAmount") Double maxAmount) {
        return loanApplicationService.findByLoanAmountRange(minAmount, maxAmount);
    }

    @GetMapping("/employment-status/{employmentStatus}")
    public List<LoanApplication> findByEmploymentStatus(@PathVariable String employmentStatus) {
        return loanApplicationService.findByEmploymentStatus(employmentStatus);
    }

    @GetMapping("/credit-score-range")
    public List<LoanApplication> findByCreditScoreRange(@RequestParam("minScore") Integer minScore, @RequestParam("maxScore") Integer maxScore) {
        return loanApplicationService.findByCreditScoreRange(minScore, maxScore);
    }

    @GetMapping("/approval-status/{approvalStatus}")
    public List<LoanApplication> findByApprovalStatus(@PathVariable String approvalStatus) {
        return loanApplicationService.findByApprovalStatus(approvalStatus);
    }

    @GetMapping("/submission-date-range")
    public List<LoanApplication> findBySubmissionDateRange(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return loanApplicationService.findBySubmissionDateRange(startDate, endDate);
    }
}