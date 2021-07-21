package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.ui.login.user_author;
import com.example.myapplication.ui.login.user_organizer;

import java.util.ArrayList;

public class MakePost extends AppCompatActivity {


    private EditText title;
    private EditText sub;
    private EditText noti;
    private EditText Final;
    private EditText start;
    private EditText end;
    private EditText place;
    private EditText c1;
    private EditText c2;
    private EditText c3;
    private EditText link;
    private EditText content;
    private user_organizer user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_ke_post);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user =  (user_organizer) bundle.getSerializable("organizerAccount");

        title = (EditText) findViewById(R.id.title);
        sub = (EditText) findViewById(R.id.subnission);
        noti = (EditText) findViewById(R.id.notification);
        Final = (EditText) findViewById(R.id.finalversion);
        start = (EditText) findViewById(R.id.startdate);
        end = (EditText) findViewById(R.id.endate);
        place = (EditText) findViewById(R.id.place);
        content = (EditText) findViewById(R.id.content);
        c1 = (EditText) findViewById(R.id.c1);
        c2 = (EditText) findViewById(R.id.c2);
        c3 = (EditText) findViewById(R.id.c3);
        link  = (EditText) findViewById(R.id.link);


    }

    public void post() {

        Post p = new Post(title.getText().toString(), start.getText().toString(), end.getText().toString(), place.getText().toString(), sub.getText().toString(), noti.getText().toString(),
                Final.getText().toString(), c1.getText().toString(), c2.getText().toString(), c3.getText().toString(), "1", link.getText().toString());

        Intent intent2 = new Intent(MakePost.this, OrganizerIndexActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        bundle.putSerializable("post", p);
        bundle.putString("tag", "1");
        intent2.putExtras(bundle);
        startActivity(intent2);

    }

    public void gotoAccount(View v){

        Intent intent2 = new Intent(MakePost.this, Organizer_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);

        intent2.putExtras(bundle);
        startActivity(intent2);

    }

    public void gotoIndex(View v){


        Intent intent2 = new Intent(MakePost.this, myPost.class);
        startActivity(intent2);


    }

}