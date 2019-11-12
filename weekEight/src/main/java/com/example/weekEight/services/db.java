package com.example.weekEight.services;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class db {

    public HashMap<String, String> getGreeting(){
        HashMap<String, String> map = new HashMap<>();
        map.put("greeting","Hello, world!");
        return map;
    }
}
