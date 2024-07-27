
package com.sacral.controller;

import com.sacral.model.AccountDet;
import com.sacral.service.AccountDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountDetController {

    private final AccountDetService accountDetService;

    @Autowired
    public AccountDetController(AccountDetService accountDetService) {
        this.accountDetService = accountDetService;
    }

    @GetMapping("/{ifscCode}")
    public AccountDet findByIfscCode(@PathVariable String ifscCode) {
        return accountDetService.findByIfscCode(ifscCode);
    }

    @GetMapping("/possible/{ifscCode}")
    public List<AccountDet> findPossibleIfscCodes(@PathVariable String ifscCode) {
        return accountDetService.findPossibleIfscCodes(ifscCode);
    }
}
