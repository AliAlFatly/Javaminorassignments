package com.example.weekfive.services.transformers;

import com.example.weekfive.models.Accounts;
import com.example.weekfive.models.dto.AccountsDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountsTransfer {
    public static AccountsDto toDto(Accounts accounts){
        AccountsDto dto = new AccountsDto();
        dto.setName(accounts.getName());
        dto.setLastName(accounts.getLastName());
        dto.setUserName(accounts.getUserName());
        dto.setBalance(accounts.getBalance());
        dto.setEmail(accounts.getEmail());
        dto.setIBAN(accounts.getIBAN());
        return dto;
    }

    public static List<AccountsDto> listToDto(List<Accounts> accountsList){
        List<AccountsDto> dtos = new ArrayList<>();
        for (int i = 0; i < accountsList.size(); i++){
            dtos.add(AccountsTransfer.toDto(accountsList.get(i)));
        }
        return dtos;
    }
}
