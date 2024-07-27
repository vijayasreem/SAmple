
package com.sacral.service;

import com.sacral.model.DeqcDisplay;
import com.sacral.repository.DeqcDisplayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeqcDisplayService {

    private final DeqcDisplayRepository deqcDisplayRepository;

    @Autowired
    public DeqcDisplayService(DeqcDisplayRepository deqcDisplayRepository) {
        this.deqcDisplayRepository = deqcDisplayRepository;
    }

    public void getCaseDetails(String applicationNumber) {
        deqcDisplayRepository.getCaseDetails(applicationNumber);
    }

    public void getProductId(String applicationNumber) {
        deqcDisplayRepository.getProductId(applicationNumber);
    }

    public void getCaseCount(String applicationNumber) {
        deqcDisplayRepository.getCaseCount(applicationNumber);
    }

    public void insertFormData(String applicationNumber) {
        deqcDisplayRepository.insertFormData(applicationNumber);
    }

    public void getQcCount() {
        deqcDisplayRepository.getQcCount();
    }
}
