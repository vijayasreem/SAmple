package com.sacral.controller;

import com.sacral.model.Application;
import com.sacral.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/verification")
    public List<Application> findApplicationsForVerificationWithinTimeframe(@RequestParam("startTime") Date startTime, @RequestParam("endTime") Date endTime) {
        return applicationService.findApplicationsForVerificationWithinTimeframe(startTime, endTime);
    }

    @GetMapping("/approved")
    public List<Application> findApprovedApplications() {
        return applicationService.findApprovedApplications();
    }

    @GetMapping("/approved/{policyPeriod}")
    public List<Application> findApprovedApplicationsByPolicyPeriod(@PathVariable("policyPeriod") int policyPeriod) {
        return applicationService.findApprovedApplicationsByPolicyPeriod(policyPeriod);
    }

    @GetMapping("/approved/{policyPeriod}/{minCoverageAmount}/{maxCoverageAmount}")
    public List<Application> findApprovedApplicationsByPolicyPeriodAndCoverageAmount(@PathVariable("policyPeriod") int policyPeriod, @PathVariable("minCoverageAmount") double minCoverageAmount, @PathVariable("maxCoverageAmount") double maxCoverageAmount) {
        return applicationService.findApprovedApplicationsByPolicyPeriodAndCoverageAmount(policyPeriod, minCoverageAmount, maxCoverageAmount);
    }

    @GetMapping("/customer/{customerId}")
    public List<Application> findApplicationsByCustomerId(@PathVariable("customerId") String customerId) {
        return applicationService.findApplicationsByCustomerId(customerId);
    }

    @GetMapping("/customer/{customerId}/approved")
    public List<Application> findApprovedApplicationsByCustomerId(@PathVariable("customerId") String customerId) {
        return applicationService.findApprovedApplicationsByCustomerId(customerId);
    }
}