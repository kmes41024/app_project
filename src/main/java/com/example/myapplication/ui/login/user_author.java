package com.example.myapplication.ui.login;

import com.example.myapplication.Post;

import java.io.Serializable;
import java.util.ArrayList;

public class user_author implements Serializable {
    public int id;
    public String userid;
    public String password;
    public String email;
    public String category;
    public ArrayList<Post> myFavorite;

    public user_author(int ID, String USERID, String PASSWORD, String EMAIL, String CATEGORY){
        id = ID;
        userid = USERID;
        password = PASSWORD;
        email = EMAIL;
        category = CATEGORY;
    }

    public void addMyFavorite(Post post){ myFavorite.add(post); }

    public void removeMyFavorite(Post post){ myFavorite.remove(post); }

    public void favoriteisEmpty(){ myFavorite.isEmpty(); }

    public ArrayList<Post> getMyFavorite(){ return myFavorite; }
}


