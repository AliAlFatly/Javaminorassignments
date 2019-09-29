package com.example.WeekThree.models;

public class users {
    private int userId;
    private String userName;

    public users(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId(){ return userId;}

    public String getUserName(){ return userName;}
}
