package com.example.WeekThree.services;

import static org.hamcrest.CoreMatchers.instanceOf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.WeekThree.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class databaseTest {

    database db = new database();


    @Test
    public void getUserTableTest(){
        assertTrue(db.getUsersTable().get(0) instanceof users);
        assertTrue(db.getUsersTable().get(0) != null);
    }

    @Test
    public void getAccountTableTest(){
        db.createAccount(1);  //toegevoegd op index 15
        assertTrue(1 == db.getAccountsTable().get(15).getUsersList().get(0));
    }

    @Test
    public void createAccountTest(){
        db.createAccount(2);  //toegevoegd op index 15
        assertTrue(2 == db.getAccountsTable().get(15).getUsersList().get(0));
    }

    @Test
    public void getUserAccountsTest(){
        db.createAccount(3);
        assertTrue(db.getUsersAccounts(3).get(0) instanceof account);
    }

    @Test
    public void addUserToAccountTest(){
        db.createAccount(2);
        int accountId = db.getAccountsTable().get(15).getId();
        db.addUserToAccount(accountId, 1);  //note-> accountId then userId
        db.addUserToAccount(accountId, 3);

        assertEquals((Integer) 1, db.getAccountsTable().get(15).getUsersList().get(1));
        assertEquals((Integer) 2, db.getAccountsTable().get(15).getUsersList().get(0));
        assertEquals((Integer) 3, db.getAccountsTable().get(15).getUsersList().get(2));

        assertEquals("Account: " + 16 + " doesnt exist", db.addUserToAccount(accountId + 1, 1));
        assertEquals("User: " + 4 + " has been added", db.addUserToAccount(accountId, 4));
        assertEquals("User: " + 1 + " is already a owner of the account: " + accountId, db.addUserToAccount(accountId, 1));
        assertEquals("User: " + 999 + " doesnt exist", db.addUserToAccount(accountId, 999));

    }

    @Test
    public void deleteUserFromAccountTest(){
        db.createAccount(2);
        int accountId = db.getAccountsTable().get(15).getId();
        db.addUserToAccount(accountId, 1);  //note-> accountId then userId
        db.addUserToAccount(accountId, 3);

        db.deleteUserFromAccount(accountId, 1);
        assertEquals((Integer) 3, db.getAccountsTable().get(15).getUsersList().get(1));

        assertEquals("Account: " + 16 + " doesnt exist", db.deleteUserFromAccount(accountId + 1, 3));
        assertEquals("User " + 3 + " has been removed", db.deleteUserFromAccount(accountId, 3));
        assertEquals("There is no user " + 999 + " in the selected account", db.deleteUserFromAccount(accountId, 999));
    }

    @Test
    public void deleteAccountTest(){

    }

    @Test
    public void blockAccountTest(){
        assertFalse(db.getAccountsTable().get(0).isBlocked());
        int accountId = db.getAccountsTable().get(0).getId();
        db.blockAccount(accountId);
        assertTrue(db.getAccountsTable().get(0).isBlocked());

        assertEquals("Account: " + accountId +" is already blocked", db.blockAccount(accountId));
        assertEquals("Account: " + db.getAccountsTable().get(1).getId() + " has been blocked", db.blockAccount(db.getAccountsTable().get(1).getId()));
        assertEquals("Account: " + 999 + " doesnt exit", db.blockAccount(999));

    }

    @Test
    public void userExistsTest(){
        //user 0-29 exist by default. there was no assignment to create a function to add/delete users.
        assertTrue(db.userExists(1));
        assertTrue(db.userExists(0));
        assertTrue(db.userExists(29));
        assertTrue(db.userExists(25));

        assertFalse(db.userExists(30));
        assertFalse(db.userExists(40));
        assertFalse(db.userExists(31));
        assertFalse(db.userExists(333));
    }


}
