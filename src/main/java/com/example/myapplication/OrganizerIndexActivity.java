package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.ui.login.user_author;
import com.example.myapplication.ui.login.user_organizer;

public class OrganizerIndexActivity extends AppCompatActivity {

    private user_organizer user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_index);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
		
        user = (user_organizer) bundle.getSerializable("organizerAccount");
    }


    public void gotoMyAccount(View v){

        Intent intent = new Intent(OrganizerIndexActivity.this, Organizer_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("organizerAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoMakePost(View v){

        Intent intent= new Intent (OrganizerIndexActivity.this, MakePost.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("organizerAccount", user);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}