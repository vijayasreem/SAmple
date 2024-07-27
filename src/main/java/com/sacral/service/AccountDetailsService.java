package com.sacral.service;

import com.sacral.model.AccountDetails;
import com.sacral.repository.AccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService {

    private final AccountDetailsRepository accountDetailsRepository;

    @Autowired
    public AccountDetailsService(AccountDetailsRepository accountDetailsRepository) {
        this.accountDetailsRepository = accountDetailsRepository;
    }

    public Object[] getBankDetailsByIfscCode(String ifscCode) {
        return accountDetailsRepository.getBankDetailsByIfscCode(ifscCode);
    }

    // Add other business methods as needed

}