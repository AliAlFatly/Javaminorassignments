package com.example.WeekThree.services;


import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class pageTest {
    ArrayList<Integer> tempList = new ArrayList<>(Arrays.asList(3,5,7,2,3,4,5));
    page T1 = new page(tempList, 5, 1);
    page T2 = new page(tempList, 5, 2);
    page T3 = new page(tempList, 5, 3);
    page T4 = new page(tempList, 30, 1);
    @Test
    public void totalPagesTest(){
        assertTrue((int) Math.ceil((double) tempList.size() / 5) == T1.TotalPages());
    }

    @Test
    public void getContentTest(){
        assertEquals(new ArrayList<Integer>(Arrays.asList(3,5,7,2,3)), T1.getContent());
        assertEquals(new ArrayList<Integer>(Arrays.asList(4, 5)), T2.getContent());
        assertEquals(new ArrayList<Integer>(Arrays.asList()), T3.getContent());
        assertEquals(new ArrayList<Integer>(Arrays.asList(3,5,7,2,3,4,5)), T4.getContent());
    }

}
