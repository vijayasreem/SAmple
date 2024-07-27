
package com.sacral.controller;

import com.sacral.service.ApplicationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationDetailsController {

    private final ApplicationDetailsService applicationDetailsService;

    @Autowired
    public ApplicationDetailsController(ApplicationDetailsService applicationDetailsService) {
        this.applicationDetailsService = applicationDetailsService;
    }

    @PostMapping("/updateStatusToPendingForAutoBbu")
    public void updateStatusToPendingForAutoBbu(@RequestBody String applicationNumber) {
        applicationDetailsService.updateStatusToPendingForAutoBbu(applicationNumber);
    }

    @PostMapping("/updateStatusToFrAr")
    public void updateStatusToFrAr(@RequestBody String applicationNumber) {
        applicationDetailsService.updateStatusToFrAr(applicationNumber);
    }

    @PostMapping("/getContractId")
    public String getContractId(@RequestBody String applicationNumber) {
        return applicationDetailsService.getContractId(applicationNumber);
    }

    @PostMapping("/getRuleErrorCount")
    public int getRuleErrorCount(@RequestBody Long activityId) {
        return applicationDetailsService.getRuleErrorCount(activityId);
    }

    // Add more business methods as needed
}
