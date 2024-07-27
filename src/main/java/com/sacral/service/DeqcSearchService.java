package com.sacral.service;

import com.sacral.model.DeqcSearch;
import com.sacral.repository.DeqcSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeqcSearchService {

    @Autowired
    private DeqcSearchRepository deqcSearchRepository;

    public int countRecordsInDeqcDisplay() {
        return deqcSearchRepository.countRecordsInDeqcDisplay();
    }

    public List<String> getApplicationNumbersWithChY() {
        return deqcSearchRepository.getApplicationNumbersWithChY();
    }

    public String getReasonLinkByApplicationNumber(String applicationNumber) {
        return deqcSearchRepository.getReasonLinkByApplicationNumber(applicationNumber);
    }

    public void updateReasonLinkByApplicationNumber(String reasonLink, String applicationNumber) {
        deqcSearchRepository.updateReasonLinkByApplicationNumber(reasonLink, applicationNumber);
    }

    public void autoRejectApplication(String applicationNumber) {
        deqcSearchRepository.autoRejectApplication(applicationNumber);
    }

    public String getContractIdByApplicationNumber(String applicationNumber) {
        return deqcSearchRepository.getContractIdByApplicationNumber(applicationNumber);
    }

    public void insertNewComment(String eventNo, String contractId, String policyNo, String policyStatus, String comments) {
        deqcSearchRepository.insertNewComment(eventNo, contractId, policyNo, policyStatus, comments);
    }

    public void rejectApplications() {
        int recordCount = countRecordsInDeqcDisplay();
        List<String> rejectedApplicationNumbers = new ArrayList<>();

        for (String applicationNumber : getApplicationNumbersWithChY()) {
            String reasonLink = getReasonLinkByApplicationNumber(applicationNumber);
            if (reasonLink.isEmpty() || recordCount == 0) {
                // Prompt user for comments and halt process
                break;
            }

            autoRejectApplication(applicationNumber);
            String contractId = getContractIdByApplicationNumber(applicationNumber);
            insertNewComment("eventNo", contractId, "policyNo", "policyStatus", "comments");

            rejectedApplicationNumbers.add(applicationNumber);
        }

        // Display message
        System.out.println("Number of records rejected: " + rejectedApplicationNumbers.size());
        System.out.println("Rejected application numbers: " + rejectedApplicationNumbers);
    }
}