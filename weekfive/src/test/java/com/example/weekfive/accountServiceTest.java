package com.example.weekfive;
import com.example.weekfive.models.Accounts;
import com.example.weekfive.services.AccountsService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.instanceOf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class accountServiceTest {
    //NOTE- run each test indiviualy.
    @Autowired
    AccountsService accountsService;

    @Test
    public void getAllAccountsTest(){
        Accounts accounts = new Accounts(
                "name", "lastname", "name@hotmail.com", "username", "password"
        );
        accountsService.createAccount(accounts);
        assertEquals(Accounts.class, accountsService.getAllAccounts().get(0).getClass());

    }

    @Test
    public void createAccountsTest(){
        Accounts accounts = new Accounts(
                "name", "lastname", "name@hotmail.com", "username", "password"
        );
        accountsService.createAccount(accounts);
        assertEquals(Accounts.class, accountsService.getAllAccounts().get(0).getClass());
    }

    @Test
    public void updateAccountTest() throws Exception{
        Accounts accounts = new Accounts(
                "name", "lastname", "name@hotmail.com", "username", "password"
        );
        accountsService.createAccount(accounts);
        Accounts accountsTwo = new Accounts(
                "name2", "lastname2", "name2@hotmail.com", "username2", "password2"
        );
        accountsTwo.setAccountsNumber(accountsService.getAllAccounts().get(0).getAccountsNumber());
        accountsService.updateAccount(accountsService.getAllAccounts().get(0).getAccountsNumber(), accountsTwo);
        assertEquals(accountsTwo.getClass(), accountsService.getAllAccounts().get(0).getClass());
        assertEquals(accountsTwo.getIBAN(), accountsService.getAllAccounts().get(0).getIBAN());
        assertEquals(accountsTwo.getName(), accountsService.getAllAccounts().get(0).getName());
        assertEquals(accountsTwo.getLastName(), accountsService.getAllAccounts().get(0).getLastName());
        assertEquals(accountsTwo.getEmail(), accountsService.getAllAccounts().get(0).getEmail());
        assertEquals(accountsTwo.getUserName(), accountsService.getAllAccounts().get(0).getUserName());
        assertEquals(accountsTwo.getPassword(), accountsService.getAllAccounts().get(0).getPassword());
        assertEquals(accountsTwo.getAccountsNumber(), accountsService.getAllAccounts().get(0).getAccountsNumber());
    }

    @Test
    public void deleteAccountTest() throws Exception{
        Accounts accounts = new Accounts(
                "name", "lastname", "name@hotmail.com", "username", "password"
        );
        accountsService.createAccount(accounts);
        assertEquals(Accounts.class, accountsService.getAllAccounts().get(0).getClass());
        accountsService.deleteAccount(accountsService.getAllAccounts().get(0).getAccountsNumber());
        assertNotEquals(Accounts.class, accountsService.getAllAccounts());
    }


}
