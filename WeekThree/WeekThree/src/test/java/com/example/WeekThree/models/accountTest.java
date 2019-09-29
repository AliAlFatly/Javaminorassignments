package com.example.WeekThree.models;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class accountTest {
    account T1 = new account(0, "NL91 INGB 0233 5342 00", 0, new ArrayList<>(Arrays.asList(1,5)));
    account T2 = new account(1, "NL91 INGB 0233 5342 01", 3, new ArrayList<>(Arrays.asList(2,4)));
    account T3 = new account(2, "NL91 INGB 0233 5342 02", 5, new ArrayList<>(Arrays.asList(3,1)));
    account T4 = new account(3, "NL91 INGB 0233 5342 03", 2, new ArrayList<>(Arrays.asList()));

    @Test
    public void getIdTest(){
        assertEquals(0, T1.getId());
        assertEquals(1, T2.getId());
        assertEquals(2, T3.getId());
        assertEquals(3, T4.getId());
    }

    @Test
    public void getIBANTest(){
        assertEquals("NL91 INGB 0233 5342 00", T1.getIBAN());
        assertEquals("NL91 INGB 0233 5342 01", T2.getIBAN());
        assertEquals("NL91 INGB 0233 5342 02", T3.getIBAN());
        assertEquals("NL91 INGB 0233 5342 03", T4.getIBAN());
    }

    @Test
    public void getSaldoTest(){
        assertTrue(0 == T1.getSaldo());
        assertTrue(3 == T2.getSaldo());
        assertTrue(5 == T3.getSaldo());
        assertTrue(2 == T4.getSaldo());
    }

    @Test
    public void getUsersListTest(){
        assertEquals(new ArrayList<>(Arrays.asList(1,5)), T1.getUsersList());
        assertEquals(new ArrayList<>(Arrays.asList(2,4)), T2.getUsersList());
        assertEquals(new ArrayList<>(Arrays.asList(3,1)), T3.getUsersList());
        assertEquals(new ArrayList<>(Arrays.asList()), T4.getUsersList());
    }

    @Test
    public void containsUserTest(){
        assertEquals(true, T1.containsUser(5));
        assertEquals(false, T2.containsUser(3));
        assertEquals(true, T3.containsUser(1));
        assertEquals(false, T4.containsUser(6));
    }

    @Test
    public void addUserTest(){
        assertEquals(false, T1.containsUser(3));
        T1.addUser(3);
        assertEquals(true, T1.containsUser(3));
        assertEquals("User: " + 4 + " is already a owner of the account: " + 1, T2.addUser(4));
        assertEquals("User: " + 1 + " has been added", T2.addUser(1));
    }

    @Test
    public void deleteUserTest(){
        assertEquals(true, T1.containsUser(1));
        T1.deleteUser(1);
        assertEquals(false, T1.containsUser(1));
        assertEquals("User " + 4 + " has been removed", T2.deleteUser(4));
        assertEquals("There is no user " + 1 + " in the selected account", T2.deleteUser(1));
    }

    @Test
    public void isBlockedTest(){
        assertEquals(false, T1.isBlocked());
    }

    @Test
    public void blockAccountTest(){
        assertEquals(false, T1.isBlocked());
        T1.blockAccount();
        assertEquals(true, T1.isBlocked());
    }
}
