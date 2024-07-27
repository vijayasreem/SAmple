package com.sacral.controller;

import com.sacral.model.BankDetails;
import com.sacral.repository.BankDetailsRepository;
import com.sacral.service.BankDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank-details")
public class BankDetailsController {

    private final BankDetailsService bankDetailsService;

    @Autowired
    public BankDetailsController(BankDetailsService bankDetailsService) {
        this.bankDetailsService = bankDetailsService;
    }

    @PostMapping("/save")
    public void saveBankDetails(@RequestBody BankDetails bankDetails) {
        bankDetailsService.saveBankDetails(bankDetails.getPolicyRef(), bankDetails.getContractId(), bankDetails.getPartnerId(), bankDetails.getAccountNo(), bankDetails.getCollBranch(), bankDetails.getIfscCode(), bankDetails.getAccHolderName(), bankDetails.getBankName(), bankDetails.getPayeeRelation(), bankDetails.getMicr(), bankDetails.getPayMode(), bankDetails.getAccTppRelation(), bankDetails.getRrbBankAccount(), bankDetails.getIpRelWithPp());
    }
}