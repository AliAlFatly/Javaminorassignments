package com.example.weekfive.models;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

@Entity
@Cacheable("childaccounts")
public class ChildAccounts {
    @Id
    @GeneratedValue
    public int accountsNumber;
    public double balance;
    @OneToOne(cascade = CascadeType.ALL)
    public CombiAccounts parentAccount;

    public ChildAccounts(){};

    public ChildAccounts(CombiAccounts parentAccount) {
        this.balance = 0;
        this.parentAccount = parentAccount;
    }
}
