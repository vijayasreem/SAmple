
package com.sacral.service;

import com.sacral.model.KycDocument;
import com.sacral.repository.KycDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KycDocumentService {

    private final KycDocumentRepository kycDocumentRepository;

    @Autowired
    public KycDocumentService(KycDocumentRepository kycDocumentRepository) {
        this.kycDocumentRepository = kycDocumentRepository;
    }

    public Long getContractId(String proposalNo) {
        return kycDocumentRepository.getContractId(proposalNo);
    }

    public Object[] getPersonalDetails(Long contractId) {
        return kycDocumentRepository.getPersonalDetails(contractId);
    }

    // Add other business methods as needed

}
