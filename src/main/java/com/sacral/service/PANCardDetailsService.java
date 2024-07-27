
package com.sacral.service;

import com.sacral.model.PANCardDetails;
import com.sacral.repository.PANCardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PANCardDetailsService {

    private final PANCardDetailsRepository panCardDetailsRepository;

    @Autowired
    public PANCardDetailsService(PANCardDetailsRepository panCardDetailsRepository) {
        this.panCardDetailsRepository = panCardDetailsRepository;
    }

    public Object[] getDateOfBirth(String applnNo) {
        return panCardDetailsRepository.getDateOfBirth(applnNo);
    }

    public Object[] getDateOfBirthFallback(String applnNo) {
        return panCardDetailsRepository.getDateOfBirthFallback(applnNo);
    }

    public String validatePANCardFormat(String panCard) {
        return panCardDetailsRepository.validatePANCardFormat(panCard);
    }

    public String getFatherName(String ipPh, String ipPartId, String phPartId) {
        return panCardDetailsRepository.getFatherName(ipPh, ipPartId, phPartId);
    }

    public Object[] getPanDetails(String panSeqNo) {
        return panCardDetailsRepository.getPanDetails(panSeqNo);
    }

    public Object[] getPartnerDetails(String partId) {
        return panCardDetailsRepository.getPartnerDetails(partId);
    }
}
