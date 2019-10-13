package com.example.weekfive.models;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
@SequenceGenerator(initialValue = 10000001, name = "id")
public class SuperAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Range(min = 10000000, max = 999999999)    //8 digits
    protected int accountsNumber;
    @NotBlank(message = "name missing")
    protected String name;
    @NotBlank(message = "lastName missing")
    protected String lastName;
    @NotBlank(message = "email missing")
    @Email
    protected String email;
    @NotBlank(message = "userName missing")
    protected String userName;
    @NotBlank(message = "password missing")
    protected String password;
    public String IBAN;
    public SuperAccounts(){}; //default constructor

    public SuperAccounts(@NotBlank(message = "name missing") String name, @NotBlank(message = "lastName missing") String lastName, @NotBlank(message = "email missing") @Email String email, @NotBlank(message = "userName missing") String userName, @NotBlank(message = "password missing") String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public int getAccountsNumber() {
        return accountsNumber;
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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setAccountsNumber(int accountsNumber) {
        this.accountsNumber = accountsNumber;
    }
}
