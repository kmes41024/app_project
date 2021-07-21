package com.example.myapplication;

import android.content.res.Resources;

import java.util.ArrayList;

public class PostExisted {

    private ArrayList<Post> mData = new ArrayList<Post>();

    public PostExisted(String[] title, String[] start, String[] end, String[] place, String[] sub, String[] noti, String[] Final, String[] c1, String[] c2, String[] c3, String[] link, String icon[], String type){

        for (int i = 0;i<10;i++){

            if(c1[i].equals(type) || c2[i].equals(type) || c3[i].equals(type))
                mData.add(new Post(title[i], start[i], end[i], place[i], sub[i],
                        noti[i], Final[i], c1[i], c2[i], c3[i], icon[i], link[i]));
        }

    }

    public ArrayList<Post> getself(){

        return mData;
    }
}
