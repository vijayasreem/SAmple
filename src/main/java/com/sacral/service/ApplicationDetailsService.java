
package com.sacral.service;

import com.sacral.model.ApplicationDetails;
import com.sacral.repository.ApplicationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationDetailsService {

    private final ApplicationDetailsRepository applicationDetailsRepository;

    @Autowired
    public ApplicationDetailsService(ApplicationDetailsRepository applicationDetailsRepository) {
        this.applicationDetailsRepository = applicationDetailsRepository;
    }

    public List<ApplicationDetails> searchApplicationDetails(String applicationNo, String partnerType, Date fromDate, Date toDate) {
        return applicationDetailsRepository.searchApplicationDetails(applicationNo, partnerType, fromDate, toDate);
    }

    public int countMissingDocuments(String appno) {
        return applicationDetailsRepository.countMissingDocuments(appno);
    }

    public int countBIDocuments(String appno) {
        return applicationDetailsRepository.countBIDocuments(appno);
    }

    public int countPFDocuments(String appno) {
        return applicationDetailsRepository.countPFDocuments(appno);
    }

    public int countPhotoDocuments(String appno) {
        return applicationDetailsRepository.countPhotoDocuments(appno);
    }

    public int countAgeProofDocuments(String appno) {
        return applicationDetailsRepository.countAgeProofDocuments(appno);
    }

    public int countAddressProofDocuments(String appno) {
        return applicationDetailsRepository.countAddressProofDocuments(appno);
    }
}
