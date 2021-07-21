package com.example.myapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Signup_OrganizerActivity extends AppCompatActivity {
    private TextView name;
    private TextView password;
    private TextView repassword;
    private TextView email;

    public ArrayList<user_organizer> user_organizer_group;
    public int organizerCount;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_signup);

        name = findViewById(R.id.userid);
        password = findViewById(R.id.userpassword);
        repassword = findViewById(R.id.userrepassword);
        email = findViewById(R.id.useroffmail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user_organizer_group = (ArrayList<user_organizer>)bundle.getSerializable("organizerAccount");
        organizerCount = intent.getIntExtra("organizerCount", 0);
    }

    public void gotologin_o(View v){
        user_organizer_group.add(new user_organizer(organizerCount, name.getText().toString(), password.getText().toString(), email.getText().toString()));
        organizerCount++;

        Intent intent = new Intent(Signup_OrganizerActivity.this, Login_OrganizerActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("organizerAccount", user_organizer_group);
        intent.putExtra("organizerCount", organizerCount);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}