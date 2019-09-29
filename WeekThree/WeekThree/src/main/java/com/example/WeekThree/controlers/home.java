package com.example.WeekThree.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class home {

    @RequestMapping("/")
    //swagger pagina met documentatie
    public String home(){
        return "index";
    }

}
