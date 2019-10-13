package com.example.weekfive.models;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Cacheable("combiaccounts")
public class CombiAccounts extends SuperAccounts {
    @OneToOne(cascade = CascadeType.ALL)
    protected ChildAccounts childAccountsOne;
    @OneToOne(cascade = CascadeType.ALL)
    protected ChildAccounts childAccountsTwo;

    public CombiAccounts() {}

    public CombiAccounts(@NotBlank(message = "name missing") String name, @NotBlank(message = "lastName missing") String lastName, @NotBlank(message = "email missing") @Email String email, @NotBlank(message = "userName missing") String userName, @NotBlank(message = "password missing") String password) {
        super(name, lastName, email, userName, password);
    }

    public ChildAccounts getChildAccountsOne() {
        return childAccountsOne;
    }

    public ChildAccounts getChildAccountsTwo() {
        return childAccountsTwo;
    }

    public void setChildAccountsOne() {
        this.childAccountsOne = new ChildAccounts(this);
    }

    public void setChildAccountsTwo() {
        this.childAccountsOne = new ChildAccounts(this);
    }

    public void setChildAccountsOne(ChildAccounts accountsOne) {
        this.childAccountsOne = accountsOne;
    }

    public void setChildAccountsTwo(ChildAccounts accountsTwo) {
        this.childAccountsOne = accountsTwo;
    }
}
