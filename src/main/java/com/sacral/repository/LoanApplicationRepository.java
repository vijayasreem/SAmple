
package com.sacral.repository;

import com.sacral.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    // Query to retrieve loan applications by customer ID
    @Query("SELECT la FROM LoanApplication la WHERE la.customerId = :customerId")
    List<LoanApplication> findByCustomerId(Long customerId);

    // Query to retrieve loan applications by status
    @Query("SELECT la FROM LoanApplication la WHERE la.status = :status")
    List<LoanApplication> findByStatus(String status);

    // Query to retrieve loan applications by loan amount range
    @Query("SELECT la FROM LoanApplication la WHERE la.loanAmount >= :minAmount AND la.loanAmount <= :maxAmount")
    List<LoanApplication> findByLoanAmountRange(Double minAmount, Double maxAmount);

    // Query to retrieve loan applications by employment status
    @Query("SELECT la FROM LoanApplication la WHERE la.employmentStatus = :employmentStatus")
    List<LoanApplication> findByEmploymentStatus(String employmentStatus);

    // Query to retrieve loan applications by credit score range
    @Query("SELECT la FROM LoanApplication la WHERE la.creditScore >= :minScore AND la.creditScore <= :maxScore")
    List<LoanApplication> findByCreditScoreRange(Integer minScore, Integer maxScore);

    // Query to retrieve loan applications by approval status
    @Query("SELECT la FROM LoanApplication la WHERE la.approvalStatus = :approvalStatus")
    List<LoanApplication> findByApprovalStatus(String approvalStatus);

    // Query to retrieve loan applications by submission date range
    @Query("SELECT la FROM LoanApplication la WHERE la.submissionDate >= :startDate AND la.submissionDate <= :endDate")
    List<LoanApplication> findBySubmissionDateRange(LocalDate startDate, LocalDate endDate);
}
