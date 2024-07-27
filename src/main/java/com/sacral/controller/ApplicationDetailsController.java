
package com.sacral.controller;

import com.sacral.model.ApplicationDetails;
import com.sacral.service.ApplicationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ApplicationDetailsController {

    private final ApplicationDetailsService applicationDetailsService;

    @Autowired
    public ApplicationDetailsController(ApplicationDetailsService applicationDetailsService) {
        this.applicationDetailsService = applicationDetailsService;
    }

    @GetMapping("/searchApplicationDetails")
    public List<ApplicationDetails> searchApplicationDetails(
            @RequestParam(required = false) String applicationNo,
            @RequestParam(required = false) String partnerType,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate
    ) {
        return applicationDetailsService.searchApplicationDetails(applicationNo, partnerType, fromDate, toDate);
    }

    @GetMapping("/countMissingDocuments")
    public int countMissingDocuments(@RequestParam String appno) {
        return applicationDetailsService.countMissingDocuments(appno);
    }

    @GetMapping("/countBIDocuments")
    public int countBIDocuments(@RequestParam String appno) {
        return applicationDetailsService.countBIDocuments(appno);
    }

    @GetMapping("/countPFDocuments")
    public int countPFDocuments(@RequestParam String appno) {
        return applicationDetailsService.countPFDocuments(appno);
    }

    @GetMapping("/countPhotoDocuments")
    public int countPhotoDocuments(@RequestParam String appno) {
        return applicationDetailsService.countPhotoDocuments(appno);
    }

    @GetMapping("/countAgeProofDocuments")
    public int countAgeProofDocuments(@RequestParam String appno) {
        return applicationDetailsService.countAgeProofDocuments(appno);
    }

    @GetMapping("/countAddressProofDocuments")
    public int countAddressProofDocuments(@RequestParam String appno) {
        return applicationDetailsService.countAddressProofDocuments(appno);
    }
}
