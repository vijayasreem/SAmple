package com.sacral.service;

import com.sacral.model.DeqcSearch;
import com.sacral.repository.DeqcSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeqcSearchService {

    private final DeqcSearchRepository deqcSearchRepository;

    @Autowired
    public DeqcSearchService(DeqcSearchRepository deqcSearchRepository) {
        this.deqcSearchRepository = deqcSearchRepository;
    }

    public List<DeqcSearch> findRejectApplications() {
        return deqcSearchRepository.findRejectApplications();
    }

    public void updateComments(String comments, String applicationNumber) {
        deqcSearchRepository.updateComments(comments, applicationNumber);
    }

    public void rejectApplication(String applicationNumber) {
        deqcSearchRepository.rejectApplication(applicationNumber);
    }

    public List<String> getApplicationNumbers() {
        return deqcSearchRepository.getApplicationNumbers();
    }

    public int getRecordCount() {
        return deqcSearchRepository.getRecordCount();
    }

    public List<DeqcSearch> getRecordsWithChMarked() {
        return deqcSearchRepository.getRecordsWithChMarked();
    }

    public DeqcSearch findByApplicationNumberAndTransactionType(String applicationNumber) {
        return deqcSearchRepository.findByApplicationNumberAndTransactionType(applicationNumber);
    }

    public String getReasonLink() {
        return deqcSearchRepository.getReasonLink();
    }

    public void insertComment(String eventNo, String contractId, String policyNo, String policyStatus, String userId, String comments) {
        deqcSearchRepository.insertComment(eventNo, contractId, policyNo, policyStatus, userId, comments);
    }

    public String getContractId(String applicationNumber) {
        return deqcSearchRepository.getContractId(applicationNumber);
    }

    public void processRejectApplications() {
        List<DeqcSearch> rejectApplications = findRejectApplications();
        List<String> rejectedApplicationNumbers = new ArrayList<>();
        int counter = 0;

        for (DeqcSearch application : rejectApplications) {
            if (application.getCh().equals("Y")) {
                rejectedApplicationNumbers.add(application.getApplicationNumber());
                counter++;
            }
        }

        if (rejectedApplicationNumbers.isEmpty()) {
            System.out.println("No applications to reject.");
            return;
        }

        String reasonLink = getReasonLink();
        if (reasonLink.isEmpty()) {
            System.out.println("Please enter comments for rejection.");
            return;
        }

        for (String applicationNumber : rejectedApplicationNumbers) {
            rejectApplication(applicationNumber);
        }

        for (DeqcSearch application : rejectApplications) {
            if (!application.getReasonLink().isEmpty()) {
                String contractId = getContractId(application.getApplicationNumber());
                insertComment(application.getEventNo(), contractId, application.getPolicyNo(), application.getPolicyStatus(), application.getUserId(), application.getReasonLink());
            }
        }

        System.out.println("Number of records rejected: " + counter);
        System.out.println("Rejected application numbers: " + rejectedApplicationNumbers);
    }
}