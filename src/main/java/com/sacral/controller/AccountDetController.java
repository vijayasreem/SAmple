package com.sacral.controller;

import com.sacral.model.AccountDet;
import com.sacral.repository.AccountDetRepository;
import com.sacral.service.AccountDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountDetController {

    private final AccountDetService accountDetService;

    @Autowired
    public AccountDetController(AccountDetService accountDetService) {
        this.accountDetService = accountDetService;
    }

    @PostMapping("/populateBankDetails/{ifscCode}")
    public void populateBankDetails(@PathVariable String ifscCode, @RequestBody AccountDet accountDet) {
        accountDetService.populateBankDetails(ifscCode, accountDet);
    }
}