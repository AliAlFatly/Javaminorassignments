package com.example.weekfive.services;

import com.example.weekfive.dao.AccountsRepository;
import com.example.weekfive.models.Accounts;
import com.example.weekfive.services.generate.GenerateIBANService;
import com.example.weekfive.services.log.TrackExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountsService {
    @Autowired
    AccountsRepository accountsRepository;
    @TrackExecutionTime
    public List<Accounts> getAllAccounts(){
        return (List<Accounts>)accountsRepository.findAll();
    }
    @TrackExecutionTime
    public Accounts createAccount(Accounts accounts){
        accounts.setIBAN(GenerateIBANService.generateRandomIBAN());
        final Accounts accounts1 = accountsRepository.save(accounts);
        return accounts1;
    }
    @TrackExecutionTime
    public String updateAccount(int accountsId, Accounts accounts) throws Exception{
        Accounts accounts1 = accountsRepository.findById(accountsId).orElseThrow(() -> new Exception("Account with the given id doesnt exist"));
        accounts1.setIBAN(accounts.getIBAN());
        accounts1.setBalance(accounts.getBalance());
        accounts1.setEmail(accounts.getEmail());
        accounts1.setLastName(accounts.getLastName());
        accounts1.setName(accounts.getName());
        accounts1.setUserName(accounts.getUserName());
        accountsRepository.save(accounts1);
        return "Success";
    }
    @TrackExecutionTime
    public String deleteAccount(int accountsId) throws Exception{
        Accounts accounts = accountsRepository.findById(accountsId).orElseThrow(() -> new Exception("Account with the given id doesnt exist"));
        accountsRepository.delete(accounts);
        return "Succes";
    }
}
