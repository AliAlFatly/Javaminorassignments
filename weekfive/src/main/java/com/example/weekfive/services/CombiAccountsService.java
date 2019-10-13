package com.example.weekfive.services;

import com.example.weekfive.dao.AccountsRepository;
import com.example.weekfive.dao.ChildAccountsRepository;
import com.example.weekfive.dao.CombiAccountsRepository;
import com.example.weekfive.models.Accounts;
import com.example.weekfive.models.CombiAccounts;
import com.example.weekfive.services.generate.GenerateIBANService;
import com.example.weekfive.services.log.TrackExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CombiAccountsService {
    @Autowired
    CombiAccountsRepository accountsRepository;
    @Autowired
    ChildAccountsRepository childAccountsRepository;
    @TrackExecutionTime
    public List<CombiAccounts> getAllAccounts(){
        return (List<CombiAccounts>)accountsRepository.findAll();
    }
    @TrackExecutionTime
    public CombiAccounts createAccount(CombiAccounts accounts){
        accounts.setIBAN(GenerateIBANService.generateRandomIBAN());
        accounts.setChildAccountsOne();
        accounts.setChildAccountsTwo();
        final CombiAccounts combiAccounts = accountsRepository.save(accounts);
        childAccountsRepository.save(accounts.getChildAccountsOne());
        childAccountsRepository.save(accounts.getChildAccountsTwo());
        return combiAccounts;
    }
    @TrackExecutionTime
    public String updateAccount(int accountsId, CombiAccounts accounts) throws Exception{
        CombiAccounts accounts1 = accountsRepository.findById(accountsId).orElseThrow(() -> new Exception("Account with the given id doesnt exist"));
        accounts1.setIBAN(accounts.getIBAN());
        accounts1.setEmail(accounts.getEmail());
        accounts1.setLastName(accounts.getLastName());
        accounts1.setName(accounts.getName());
        accounts1.setUserName(accounts.getUserName());
        accounts1.setChildAccountsOne(accounts.getChildAccountsOne());
        accounts1.setChildAccountsTwo(accounts.getChildAccountsTwo());
        accountsRepository.save(accounts1);
        return "Success";
    }
    @TrackExecutionTime
    public String deleteAccount(int accountsId) throws Exception{
        CombiAccounts accounts = accountsRepository.findById(accountsId).orElseThrow(() -> new Exception("Account with the given id doesnt exist"));
        childAccountsRepository.delete(accounts.getChildAccountsOne());
        childAccountsRepository.delete(accounts.getChildAccountsTwo());
        accountsRepository.delete(accounts);
        return "Succes";
    }
}
