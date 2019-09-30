package com.example.WeekThree.models;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

public class account {
    private int id;
    private String IBAN;
    private float saldo;
    private ArrayList<Integer> usersList;
    private boolean blocked;

    public account(int id, String IBAN, float saldo, ArrayList<Integer> usersList){
        this.id = id;
        this.IBAN = IBAN;
        this.saldo = saldo;
        this.usersList = usersList;
        this.blocked = false;
    }

    public int getId(){
        return id;
    }

    public String getIBAN(){
        return IBAN;
    }

    public float getSaldo(){
        return saldo;
    }

    public List<Integer> getUsersList(){
        return usersList;
    }

    public boolean containsUser(int id){
        for (int i = 0; i < usersList.size();i++){
            if (usersList.get(i) == id){
                return true;
            }
        }
        return false;
    }

    public String addUser(int id){
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i) == id) {
                return "User: " + id + " is already a owner of the account: " + this.id;
            }
        }
        usersList.add(id);
        return "User: " + id + " has been added";
    }

    public String deleteUser(int id){
        for (int i = 0; i < usersList.size(); i++){
            if (usersList.get(i) == id){
                usersList.remove(i);
                return "User " + id + " has been removed";
            }
        }
        return "There is no user " + id + " in the selected account";
    }

    public boolean isBlocked(){
        return blocked;
    }

    public void blockAccount(){
        blocked = true;
    }

}
