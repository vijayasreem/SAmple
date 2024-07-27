package com.sacral.service;

import com.sacral.model.BankDetails;
import com.sacral.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDetailsService {

    private final BankDetailsRepository bankDetailsRepository;

    @Autowired
    public BankDetailsService(BankDetailsRepository bankDetailsRepository) {
        this.bankDetailsRepository = bankDetailsRepository;
    }

    public void saveBankDetails(String policyRef, String contractId, String partnerId, String accountNo, String collBranch, String ifscCode, String accHolderName, String bankName, String payeeRelation, String micr, String payMode, String accTppRelation, String rrbBankAccount, String ipRelWithPp) {
        // Check for existing bank details
        int count = bankDetailsRepository.countByPolicyRef(policyRef);
        
        if (count > 0) {
            // Delete existing bank details if found
            bankDetailsRepository.deleteByPolicyRef(policyRef);
        }
        
        // Insert new bank details
        bankDetailsRepository.saveBankDetails(policyRef, contractId, partnerId, accountNo, collBranch, ifscCode, accHolderName, bankName, payeeRelation, micr, payMode, accTppRelation, rrbBankAccount, ipRelWithPp);
    }
}