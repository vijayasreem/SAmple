package com.sacral.controller;

import com.sacral.model.DeqcSearch;
import com.sacral.service.DeqcSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deqc-search")
public class DeqcSearchController {

    private final DeqcSearchService deqcSearchService;

    @Autowired
    public DeqcSearchController(DeqcSearchService deqcSearchService) {
        this.deqcSearchService = deqcSearchService;
    }

    @GetMapping("/reject-applications")
    public List<DeqcSearch> findRejectApplications() {
        return deqcSearchService.findRejectApplications();
    }

    @PutMapping("/update-comments")
    public void updateComments(@RequestParam String comments, @RequestParam String applicationNumber) {
        deqcSearchService.updateComments(comments, applicationNumber);
    }

    @PutMapping("/reject-application")
    public void rejectApplication(@RequestParam String applicationNumber) {
        deqcSearchService.rejectApplication(applicationNumber);
    }

    @GetMapping("/application-numbers")
    public List<String> getApplicationNumbers() {
        return deqcSearchService.getApplicationNumbers();
    }

    @GetMapping("/record-count")
    public int getRecordCount() {
        return deqcSearchService.getRecordCount();
    }

    @GetMapping("/records-with-ch-marked")
    public List<DeqcSearch> getRecordsWithChMarked() {
        return deqcSearchService.getRecordsWithChMarked();
    }

    @GetMapping("/find-by-application-number")
    public DeqcSearch findByApplicationNumberAndTransactionType(@RequestParam String applicationNumber) {
        return deqcSearchService.findByApplicationNumberAndTransactionType(applicationNumber);
    }

    @GetMapping("/reason-link")
    public String getReasonLink() {
        return deqcSearchService.getReasonLink();
    }

    @PostMapping("/insert-comment")
    public void insertComment(@RequestParam String eventNo, @RequestParam String contractId, @RequestParam String policyNo, @RequestParam String policyStatus, @RequestParam String userId, @RequestParam String comments) {
        deqcSearchService.insertComment(eventNo, contractId, policyNo, policyStatus, userId, comments);
    }

    @GetMapping("/contract-id")
    public String getContractId(@RequestParam String applicationNumber) {
        return deqcSearchService.getContractId(applicationNumber);
    }

    @PostMapping("/process-reject-applications")
    public void processRejectApplications() {
        deqcSearchService.processRejectApplications();
    }
}