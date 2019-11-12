package com.example.weekEight;

import com.example.weekEight.controllers.home;
import com.example.weekEight.services.db;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.weekEight.services.db;
import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class homeTest {

    //note, run whole class.

    @InjectMocks
    private home homeController;

    @InjectMocks
    private db db;

    //integratie test:
    @Test
    public void homeTest(){
        assertEquals(db.getGreeting(), homeController.home());
    }

    //unitTest:
    @Test
    public void dbTest() {
        HashMap<String, String> map = new HashMap<>();
        map.put("greeting","Hello, world!");
        assertEquals(map, db.getGreeting());
    }
}
