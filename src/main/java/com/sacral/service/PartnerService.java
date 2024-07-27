
package com.sacral.service;

import com.sacral.model.Partner;
import com.sacral.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {

    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public Partner findPartnerDetailsByPanCard(String ipPh, Long ipPartId, Long phPartId) {
        return partnerRepository.findPartnerDetailsByPanCard(ipPh, ipPartId, phPartId);
    }

    public int validatePanCardAgainstPolicies(String panCard, Long phPartId) {
        return partnerRepository.validatePanCardAgainstPolicies(panCard, phPartId);
    }
}
