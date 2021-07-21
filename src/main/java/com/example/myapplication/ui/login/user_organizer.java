package com.example.myapplication.ui.login;

import java.io.Serializable;

public class user_organizer implements Serializable {
    public int id;
    public String userid;
    public String password;
    public String email;

    public user_organizer(int ID, String USERID, String PASSWORD, String EMAIL){
        id = ID;
        userid = USERID;
        password = PASSWORD;
        email = EMAIL;
    }
}
