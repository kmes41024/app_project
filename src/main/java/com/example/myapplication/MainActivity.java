package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.myapplication.ui.login.Login_AuthorActivity;
import com.example.myapplication.ui.login.Login_OrganizerActivity;
import com.example.myapplication.ui.login.Signup_AuthorActivity;
import com.example.myapplication.ui.login.user_author;
import com.example.myapplication.ui.login.user_organizer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<user_author> user_author_group = new ArrayList<>();
    public int authorCount = 0;

    public ArrayList<user_organizer> user_organizer_group = new ArrayList<>();
    public int organizerCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_author_group.add(new user_author(authorCount, "lookForPaper", "1234", "test@gmail.com", "Computer Science"));
        authorCount++;
        user_author_group.add(new user_author(authorCount, "user2", "1234", "useruser222@gmail.com", "Big Data"));
        authorCount++;

        user_organizer_group.add(new user_organizer(organizerCount, "callForPaper", "1234", "test@gmail.com"));
        organizerCount++;
        user_organizer_group.add(new user_organizer(organizerCount, "organizer22", "1234", "orgorg222@gmail.com"));
        organizerCount++;
    }

    public void gotoOrganzition(View v){
        Intent intent = new Intent(MainActivity.this, Login_OrganizerActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("organizerAccount", user_organizer_group);
        intent.putExtra("organizerCount", organizerCount);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void gotoAuthor(View v){
        Intent intent = new Intent(MainActivity.this, Login_AuthorActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user_author_group);
        intent.putExtra("authorCouornt", authorCount);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}