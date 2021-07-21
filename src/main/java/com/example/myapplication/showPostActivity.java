package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.login.user_author;
import com.example.myapplication.ui.login.user_organizer;

import java.util.ArrayList;

public class showPostActivity  extends AppCompatActivity {
    private Posts clickPost;
    public ArrayList<String>reply = new  ArrayList<>();
    private TextView title;
    private TextView content;
    private TextView poster;
    private TextView reply1;
    private TextView reply2;
    private TextView reply3;
    private TextView reply4;
    private TextView dash1;
    private TextView dash2;
    private TextView dash3;
    private TextView inputReply;
    private user_author user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_post);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        user =  (user_author)bundle.getSerializable("authorAccount");

        clickPost = (Posts)bundle.getSerializable("clickPost");

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        poster = findViewById(R.id.poster);
        reply1 = findViewById(R.id.reply1);
        reply2 = findViewById(R.id.reply2);
        reply3 = findViewById(R.id.reply3);
        reply4 = findViewById(R.id.reply4);
        dash1 = findViewById(R.id.dash1);
        dash2 = findViewById(R.id.dash2);
        dash3 = findViewById(R.id.dash3);
        inputReply = findViewById(R.id.inputReply);

        title.setText("標題: \n" + clickPost.postName);
        content.setText(clickPost.content);
        poster.setText(clickPost.name);
        if(clickPost.noReply == false){
            reply = clickPost.reply;
            reply1.setText(clickPost.reply.get(0));
            reply2.setText(clickPost.reply.get(1));
            reply3.setText(clickPost.reply.get(2));
            dash1.setText("--------------------------------------------------------------------------------------------------------");
            dash2.setText("--------------------------------------------------------------------------------------------------------");
        }
        else {
            reply1.setText("尚無任何回應");
            reply2.setText("");
            reply3.setText("");
            dash1.setText("");
            dash2.setText("");
        }
    }

    public void reply(View v){
        if(clickPost.noReply == false){
            reply4.setText(inputReply.getText().toString());
            dash3.setText("--------------------------------------------------------------------------------------------------------");
        }
        else {
            reply1.setText(inputReply.getText().toString());
        }
        inputReply.setText("");
    }


    public void gotoForum(View v){

        Intent intent= new Intent (showPostActivity.this, ForumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoFavorite(View v){

        Intent intent= new Intent (showPostActivity.this, FavoriteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){

        Intent intent= new Intent (showPostActivity.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
