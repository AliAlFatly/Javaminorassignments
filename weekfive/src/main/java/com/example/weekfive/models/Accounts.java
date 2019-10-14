package com.example.weekfive.models;

import org.hibernate.validator.constraints.Range;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Cacheable("accounts")
@TableGenerator(name="tab", initialValue=10000001, allocationSize=150)
public class Accounts extends SuperAccounts{
    protected double balance;

    public Accounts() {}

    public Accounts(@NotBlank(message = "name missing") String name, @NotBlank(message = "lastName missing") String lastName, @NotBlank(message = "email missing") @Email String email, @NotBlank(message = "userName missing") String userName, @NotBlank(message = "password missing") String password) {
        super(name, lastName, email, userName, password);
        this.balance = 0;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
