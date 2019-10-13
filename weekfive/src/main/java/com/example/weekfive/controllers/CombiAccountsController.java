package com.example.weekfive.controllers;

import com.example.weekfive.models.Accounts;
import com.example.weekfive.models.CombiAccounts;
import com.example.weekfive.models.dto.AccountsDto;
import com.example.weekfive.models.dto.CombiAccountsDto;
import com.example.weekfive.services.AccountsService;
import com.example.weekfive.services.CombiAccountsService;
import com.example.weekfive.services.log.TrackExecutionTime;
import com.example.weekfive.services.transformers.AccountsTransfer;
import com.example.weekfive.services.transformers.CombiAccountsTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/combiaccount")
@Cacheable
public class CombiAccountsController {
    @Autowired
    CombiAccountsService accountsService;

    @GetMapping("")
    @Cacheable
    @TrackExecutionTime
    public List<CombiAccountsDto> getAllAccount(){
        return CombiAccountsTransfer.listToDto(accountsService.getAllAccounts());
    }

    @PostMapping("/create")
    @TrackExecutionTime
    public CombiAccountsDto createAccount(@Valid @RequestBody CombiAccounts accounts){
        return CombiAccountsTransfer.toDto(accountsService.createAccount(accounts));
    }

    @DeleteMapping("/delete/{id}")
    @TrackExecutionTime
    public String deleteAccount(@PathVariable("id") int accountsId) throws Exception{
        return accountsService.deleteAccount(accountsId);
    }

    @PutMapping("/update/{id}")
    @TrackExecutionTime
    public String updateAccount(@PathVariable("id") int accountsId, @Valid @RequestBody CombiAccounts accounts) throws Exception {
        return accountsService.updateAccount(accountsId, accounts);
    }
}
