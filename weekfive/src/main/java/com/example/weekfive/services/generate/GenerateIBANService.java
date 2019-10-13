package com.example.weekfive.services.generate;

import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class GenerateIBANService {
    public static String generateRandomIBAN(){
        ArrayList<String> banksSignature = new ArrayList<>(Arrays.asList("NL91 INGB 0", "NL91 ABNA 0", "NL91 RABO 0"));
        Random rn = new Random();
        String IBAN = "" + banksSignature.get(rn.nextInt(banksSignature.size())) + recNumber(3) + " " + recNumber(4) + " " + recNumber(2);
        return IBAN;
    }

    public static String recNumber(int digits){
        Random rn = new Random();
        if (digits <= 0){
            return "";
        }
        return rn.nextInt(10) + recNumber(digits - 1);
    }
}
