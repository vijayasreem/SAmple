
package com.sacral.service;

import com.sacral.model.ApplicationDetails;
import com.sacral.repository.ApplicationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationDetailsService {

    private final ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    public ApplicationDetailsService(ApplicationDetailsRepository applicationDetailsRepository) {
        this.applicationDetailsRepository = applicationDetailsRepository;
    }

    @Transactional
    public void updateStatusToPendingForAutoBbu(String applicationNumber) {
        applicationDetailsRepository.updateStatusToPendingForAutoBbu(applicationNumber);
    }

    @Transactional
    public void updateStatusToFrAr(String applicationNumber) {
        applicationDetailsRepository.updateStatusToFrAr(applicationNumber);
    }

    public String getContractId(String applicationNumber) {
        return applicationDetailsRepository.getContractId(applicationNumber);
    }

    public int getRuleErrorCount(Long activityId) {
        return applicationDetailsRepository.getRuleErrorCount(activityId);
    }

    // Add more business methods as needed
}
