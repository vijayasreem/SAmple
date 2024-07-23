package com.sacral.service;

import com.sacral.model.Application;
import com.sacral.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> findApplicationsForVerificationWithinTimeframe(Date startTime, Date endTime) {
        return applicationRepository.findApplicationsForVerificationWithinTimeframe(startTime, endTime);
    }

    public List<Application> findApprovedApplications() {
        return applicationRepository.findApprovedApplications();
    }

    public List<Application> findApprovedApplicationsByPolicyPeriod(int policyPeriod) {
        return applicationRepository.findApprovedApplicationsByPolicyPeriod(policyPeriod);
    }

    public List<Application> findApprovedApplicationsByPolicyPeriodAndCoverageAmount(int policyPeriod, double minCoverageAmount, double maxCoverageAmount) {
        return applicationRepository.findApprovedApplicationsByPolicyPeriodAndCoverageAmount(policyPeriod, minCoverageAmount, maxCoverageAmount);
    }

    public List<Application> findApplicationsByCustomerId(String customerId) {
        return applicationRepository.findApplicationsByCustomerId(customerId);
    }

    public List<Application> findApprovedApplicationsByCustomerId(String customerId) {
        return applicationRepository.findApprovedApplicationsByCustomerId(customerId);
    }
}