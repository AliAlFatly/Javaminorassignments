package com.example.weekfive.models.dto;

import com.example.weekfive.models.ChildAccounts;

public class CombiAccountsDto {
    protected String name;
    protected String lastName;
    protected String email;
    protected String userName;

    protected ChildAccounts childAccountOne;
    protected ChildAccounts childAccountTwo;

    protected String IBAN;

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ChildAccounts getChildAccountOne() {
        return childAccountOne;
    }

    public ChildAccounts getChildAccountTwo() {
        return childAccountTwo;
    }

    public void setChildAccountOne(ChildAccounts childAccountOne) {
        this.childAccountOne = childAccountOne;
    }

    public void setChildAccountTwo(ChildAccounts childAccountTwo) {
        this.childAccountTwo = childAccountTwo;
    }
}
