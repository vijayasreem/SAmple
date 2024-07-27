package com.sacral.controller;

import com.sacral.model.AccountDetails;
import com.sacral.service.AccountDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-details")
public class AccountDetailsController {

    private final AccountDetailsService accountDetailsService;

    @Autowired
    public AccountDetailsController(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @GetMapping("/{ifscCode}")
    public Object[] getBankDetailsByIfscCode(@PathVariable String ifscCode) {
        return accountDetailsService.getBankDetailsByIfscCode(ifscCode);
    }

    // Add other business methods as needed

}