package com.example.WeekThree.controlers;

import com.example.WeekThree.models.*;
import com.example.WeekThree.services.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
public class accounts {

    private database db = new database();

    //NOTE all put/delete are post becouse html doesnt support put/delete. if i were to use put/delete. swapping to put/delete is not that hard, replacing @PostMapping with @PutMapping/@DeleteMapping would do.

    @GetMapping(value = "accounts")
    //added pagination -> note according to assignment only add pagination to accounts.
    //cache 60 sec
    public ArrayList<account> accounts(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size){
        page = page == null ? 1 : page;
        size = size == null ? 5 : size;

        page resultPage = new page(db.getAccountsTable(), size, page);
        if (page > resultPage.TotalPages()) {
            throw new RuntimeException("NOTE -> given page number is out of bound!!!!!");
        }
        return resultPage.getContent();
    }

    @GetMapping("users")
    //cache 60 sec
    public ArrayList<users> users(){
        return db.getUsersTable();
    }

    //create account
    @PostMapping("account/create")
    public String CreateAccount(int id){
        return db.createAccount(id);
    }

    //block account
    @PostMapping("account/block")
    public String blockAccount(int id){
        return db.blockAccount(id);
    }

    //delete account
    @PostMapping("account/delete")
    public String deleteAccount(int id){
        return db.deleteAccount(id);
    }

    //add user to account
    @PostMapping("account/addUser")
    public String addUserToAccount(int accountId, int userId){
        return db.addUserToAccount(accountId, userId);
    }

    //remove user from account
    @PostMapping("account/removeUser")
    public String removeUserFromAccount(int accountId, int userId){
        return db.deleteUserFromAccount(accountId, userId);
    }

    //return all accounts of a user
    //cache 60 sec
    @GetMapping("users/accounts")
    public ArrayList<account> usersAccount(int id){
        return db.getUsersAccounts(id);
    }


}
