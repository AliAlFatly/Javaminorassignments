package com.example.weekEight.controllers;

import com.example.weekEight.services.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.weekEight.services.db;
import java.util.HashMap;

@RestController
public class home {

//    @Autowired
//    public db db;

    @GetMapping("/home")
    @CrossOrigin(origins = "http://localhost:4200")
    public HashMap<String, String> home(){
        HashMap<String, String> map = new HashMap<>();
        map.put("greeting","Hello, world!");
        return map;
    }

}
