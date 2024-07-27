
package com.sacral.controller;

import com.sacral.model.Partner;
import com.sacral.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partners")
public class PartnerController {

    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping("/{ipPh}/{ipPartId}/{phPartId}")
    public Partner findPartnerDetailsByPanCard(@PathVariable String ipPh, @PathVariable Long ipPartId, @PathVariable Long phPartId) {
        return partnerService.findPartnerDetailsByPanCard(ipPh, ipPartId, phPartId);
    }

    @GetMapping("/{panCard}/{phPartId}")
    public int validatePanCardAgainstPolicies(@PathVariable String panCard, @PathVariable Long phPartId) {
        return partnerService.validatePanCardAgainstPolicies(panCard, phPartId);
    }
}
