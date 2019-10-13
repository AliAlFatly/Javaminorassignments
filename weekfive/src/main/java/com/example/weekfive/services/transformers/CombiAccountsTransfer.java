package com.example.weekfive.services.transformers;

import com.example.weekfive.models.CombiAccounts;
import com.example.weekfive.models.dto.CombiAccountsDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CombiAccountsTransfer {
    public static CombiAccountsDto toDto(CombiAccounts accounts){
        CombiAccountsDto dto = new CombiAccountsDto();
        dto.setName(accounts.getName());
        dto.setLastName(accounts.getLastName());
        dto.setUserName(accounts.getUserName());
        dto.setEmail(accounts.getEmail());
        dto.setChildAccountOne(accounts.getChildAccountsOne());
        dto.setChildAccountTwo(accounts.getChildAccountsTwo());
        dto.setIBAN(accounts.getIBAN());
        return dto;
    }

    public static List<CombiAccountsDto> listToDto(List<CombiAccounts> accountsList){
        List<CombiAccountsDto> dtos = new ArrayList<>();
        for (int i = 0; i < accountsList.size(); i++){
            dtos.add(CombiAccountsTransfer.toDto(accountsList.get(i)));
        }
        return dtos;
    }
}
