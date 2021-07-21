package com.example.myapplication;

import com.example.myapplication.ui.login.user_organizer;

import java.io.Serializable;
import java.util.ArrayList;

public class Posts  implements Serializable {
    public int id;
    public String postName;
    public String content;
    public ArrayList<String> reply;
    boolean noReply;
    public String name;

    public Posts(int ID, String POSTNAME, String CONTENT, ArrayList<String>REPLY, boolean NOREPLY, String NAME){
        id = ID;
        postName = POSTNAME;
        content = CONTENT;
        reply = new ArrayList<>(REPLY);
        noReply = NOREPLY;
        name = NAME;
    }
}
