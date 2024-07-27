package com.sacral.service;

import com.sacral.model.AccountDet;
import com.sacral.repository.AccountDetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDetService {

    private final AccountDetRepository accountDetRepository;

    @Autowired
    public AccountDetService(AccountDetRepository accountDetRepository) {
        this.accountDetRepository = accountDetRepository;
    }

    public void populateBankDetails(String ifscCode, AccountDet accountDet) {
        accountDetRepository.populateBankDetails(ifscCode, accountDet);
    }
}