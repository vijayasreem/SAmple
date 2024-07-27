package com.sacral.controller;

import com.sacral.model.DeqcSearch;
import com.sacral.repository.DeqcSearchRepository;
import com.sacral.service.DeqcSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deqc-search")
public class DeqcSearchController {

    @Autowired
    private DeqcSearchService deqcSearchService;

    @GetMapping("/count-records")
    public int countRecordsInDeqcDisplay() {
        return deqcSearchService.countRecordsInDeqcDisplay();
    }

    @GetMapping("/application-numbers")
    public List<String> getApplicationNumbersWithChY() {
        return deqcSearchService.getApplicationNumbersWithChY();
    }

    @GetMapping("/reason-link/{applicationNumber}")
    public String getReasonLinkByApplicationNumber(@PathVariable String applicationNumber) {
        return deqcSearchService.getReasonLinkByApplicationNumber(applicationNumber);
    }

    @PutMapping("/reason-link/{applicationNumber}")
    public void updateReasonLinkByApplicationNumber(@PathVariable String applicationNumber, @RequestBody String reasonLink) {
        deqcSearchService.updateReasonLinkByApplicationNumber(reasonLink, applicationNumber);
    }

    @PutMapping("/auto-reject/{applicationNumber}")
    public void autoRejectApplication(@PathVariable String applicationNumber) {
        deqcSearchService.autoRejectApplication(applicationNumber);
    }

    @GetMapping("/contract-id/{applicationNumber}")
    public String getContractIdByApplicationNumber(@PathVariable String applicationNumber) {
        return deqcSearchService.getContractIdByApplicationNumber(applicationNumber);
    }

    @PostMapping("/new-comment")
    public void insertNewComment(@RequestBody DeqcSearch deqcSearch) {
        deqcSearchService.insertNewComment(deqcSearch.getEventNo(), deqcSearch.getContractId(), deqcSearch.getPolicyNo(), deqcSearch.getPolicyStatus(), deqcSearch.getComments());
    }

    @PostMapping("/reject-applications")
    public void rejectApplications() {
        deqcSearchService.rejectApplications();
    }
}