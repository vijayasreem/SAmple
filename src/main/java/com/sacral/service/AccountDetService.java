package com.sacral.service;

import com.sacral.model.AccountDet;
import com.sacral.repository.AccountDetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetService {

    private final AccountDetRepository accountDetRepository;

    @Autowired
    public AccountDetService(AccountDetRepository accountDetRepository) {
        this.accountDetRepository = accountDetRepository;
    }

    public AccountDet findByIfscCode(String ifscCode) {
        return accountDetRepository.findByIfscCode(ifscCode);
    }

    public List<AccountDet> findPossibleIfscCodes(String ifscCode) {
        return accountDetRepository.findPossibleIfscCodes(ifscCode);
    }
}