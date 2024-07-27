
package com.sacral.controller;

import com.sacral.service.PANCardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pancard")
public class PANCardDetailsController {

    private final PANCardDetailsService panCardDetailsService;

    @Autowired
    public PANCardDetailsController(PANCardDetailsService panCardDetailsService) {
        this.panCardDetailsService = panCardDetailsService;
    }

    @GetMapping("/dateofbirth")
    public Object[] getDateOfBirth(@RequestParam String applnNo) {
        return panCardDetailsService.getDateOfBirth(applnNo);
    }

    @GetMapping("/dateofbirthfallback")
    public Object[] getDateOfBirthFallback(@RequestParam String applnNo) {
        return panCardDetailsService.getDateOfBirthFallback(applnNo);
    }

    @GetMapping("/validate")
    public String validatePANCardFormat(@RequestParam String panCard) {
        return panCardDetailsService.validatePANCardFormat(panCard);
    }

    @GetMapping("/fathername")
    public String getFatherName(@RequestParam String ipPh, @RequestParam String ipPartId, @RequestParam String phPartId) {
        return panCardDetailsService.getFatherName(ipPh, ipPartId, phPartId);
    }

    @GetMapping("/details")
    public Object[] getPanDetails(@RequestParam String panSeqNo) {
        return panCardDetailsService.getPanDetails(panSeqNo);
    }

    @GetMapping("/partnerdetails")
    public Object[] getPartnerDetails(@RequestParam String partId) {
        return panCardDetailsService.getPartnerDetails(partId);
    }
}
