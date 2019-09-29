package com.example.WeekThree.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class usersTest {

        users T1 = new users(0, "first user");
        users T2 = new users(1, "second user");

        @Test
        public void getUserIdTest(){
                assertTrue(0 == T1.getUserId());
                assertFalse(2 == T1.getUserId());
                assertEquals(1, T2.getUserId());
        }

        @Test
        public void getUserNameTest(){
                assertTrue("first user" == T1.getUserName());
                assertFalse("second user" == T1.getUserName());
                assertEquals("second user", T2.getUserName());
        }

}
