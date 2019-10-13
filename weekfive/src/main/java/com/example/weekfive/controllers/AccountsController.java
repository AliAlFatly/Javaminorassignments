package com.example.weekfive.controllers;

import com.example.weekfive.models.Accounts;
import com.example.weekfive.models.dto.AccountsDto;
import com.example.weekfive.services.AccountsService;
import com.example.weekfive.services.log.TrackExecutionTime;
import com.example.weekfive.services.transformers.AccountsTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@Cacheable
public class AccountsController {
    @Autowired
    AccountsService accountsService;

    @GetMapping("")
    @Cacheable
    @TrackExecutionTime
    public List<AccountsDto> getAllAccount(){
        return AccountsTransfer.listToDto(accountsService.getAllAccounts());
    }

    @PostMapping("/create")
    @TrackExecutionTime
    public AccountsDto createAccount(@Valid @RequestBody Accounts accounts){
        return AccountsTransfer.toDto(accountsService.createAccount(accounts));
    }

    @DeleteMapping("/delete/{id}")
    @TrackExecutionTime
    public String deleteAccount(@PathVariable("id") int accountsId) throws Exception{
        return accountsService.deleteAccount(accountsId);
    }

    @PutMapping("/update/{id}")
    @TrackExecutionTime
    public String updateAccount(@PathVariable("id") int accountsId, @Valid @RequestBody Accounts accounts) throws Exception {
        return accountsService.updateAccount(accountsId, accounts);
    }
}
