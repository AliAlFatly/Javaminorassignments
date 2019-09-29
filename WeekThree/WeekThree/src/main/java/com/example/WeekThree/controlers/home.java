package com.example.WeekThree.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class home {

    @RequestMapping("/")
    //swagger pagina met documentatie
    public String home(){
//        return "<html>" +
//                "<body>" +
//                "<p>WELCOME TO THIS REST API WEB PROJECT</p>"+
//                "<p><strong>Accounts acces:</strong></p>" +
//                "<p></p>" +
//                "<p>/accounts -> returns accounts with default ?page=1&size=5 , change /accounts/page=n&size=n for different data amount</p>" +
//                "<p></p>" +
//                "<p>create</p>" +
//                "<p></p>" +
//                "" +
//                "<p><strong>Users acces: </strong><p>" +
//                "<p></p>" +
//                "<p>/users -> returns all users</p>" +
//
//                "</body>" +
//                "</html>";
        return "index";
    }

}
