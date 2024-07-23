
package com.sacral.repository;

import com.sacral.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a WHERE a.status = 'VERIFICATION' AND a.createdDate >= :startTime AND a.createdDate <= :endTime")
    List<Application> findApplicationsForVerificationWithinTimeframe(Date startTime, Date endTime);

    @Query("SELECT a FROM Application a WHERE a.status = 'APPROVAL' AND a.riskAssessmentResult = 'ACCEPTED'")
    List<Application> findApprovedApplications();

    @Query("SELECT a FROM Application a WHERE a.status = 'APPROVAL' AND a.riskAssessmentResult = 'ACCEPTED' AND a.policyPeriod = :policyPeriod")
    List<Application> findApprovedApplicationsByPolicyPeriod(int policyPeriod);

    @Query("SELECT a FROM Application a WHERE a.status = 'APPROVAL' AND a.riskAssessmentResult = 'ACCEPTED' AND a.policyPeriod = :policyPeriod AND a.coverageAmount >= :minCoverageAmount AND a.coverageAmount <= :maxCoverageAmount")
    List<Application> findApprovedApplicationsByPolicyPeriodAndCoverageAmount(int policyPeriod, double minCoverageAmount, double maxCoverageAmount);

    @Query("SELECT a FROM Application a WHERE a.customerId = :customerId")
    List<Application> findApplicationsByCustomerId(String customerId);

    @Query("SELECT a FROM Application a WHERE a.status = 'APPROVAL' AND a.customerId = :customerId")
    List<Application> findApprovedApplicationsByCustomerId(String customerId);

}
