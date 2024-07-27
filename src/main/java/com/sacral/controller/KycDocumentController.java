
package com.sacral.controller;

import com.sacral.model.KycDocument;
import com.sacral.service.KycDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kyc")
public class KycDocumentController {

    private final KycDocumentService kycDocumentService;

    @Autowired
    public KycDocumentController(KycDocumentService kycDocumentService) {
        this.kycDocumentService = kycDocumentService;
    }

    @GetMapping("/contractId/{proposalNo}")
    public Long getContractId(@PathVariable String proposalNo) {
        return kycDocumentService.getContractId(proposalNo);
    }

    @GetMapping("/personalDetails/{contractId}")
    public Object[] getPersonalDetails(@PathVariable Long contractId) {
        return kycDocumentService.getPersonalDetails(contractId);
    }

    // Add other business methods as needed

}
