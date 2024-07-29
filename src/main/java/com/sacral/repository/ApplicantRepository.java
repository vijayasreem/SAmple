
package com.sacral.repository;

import com.sacral.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    @Query("SELECT a FROM Applicant a WHERE a.creditScore >= :minCreditScore")
    List<Applicant> findByCreditScoreGreaterThanEqual(int minCreditScore);

    @Query("SELECT a FROM Applicant a WHERE a.loanAmount >= :minLoanAmount AND a.loanAmount <= :maxLoanAmount")
    List<Applicant> findByLoanAmountBetween(double minLoanAmount, double maxLoanAmount);

    @Query("SELECT a FROM Applicant a WHERE a.interestRate >= :minInterestRate AND a.interestRate <= :maxInterestRate")
    List<Applicant> findByInterestRateBetween(double minInterestRate, double maxInterestRate);

    // Other required methods (save, delete, etc.)
}
