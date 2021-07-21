package com.example.myapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Vector;

public class Signup_Author_NextActivity extends AppCompatActivity {

    public ArrayList<user_author> user_author_group;
    public int authorCount;

    private TextView userid;
    private TextView password;
    private TextView repassword;
    private TextView useroffmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_next_signup);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user_author_group = (ArrayList<user_author>)bundle.getSerializable("authorAccount");
        authorCount = intent.getIntExtra("authorCount", 0);

        userid = findViewById(R.id.userid);
        password = findViewById(R.id.userpassword);
        repassword = findViewById(R.id.userrepassword);
        useroffmail = findViewById(R.id.useroffmail);
    }

    public void gotonext(View v){
        Intent intent = new Intent(Signup_Author_NextActivity.this, Signup_AuthorActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user_author_group);
        intent.putExtra("userid", userid.getText().toString());
        intent.putExtra("password", password.getText().toString());
        intent.putExtra("useroffmail", useroffmail.getText().toString());
        intent.putExtra("authorCount", authorCount);
        intent.putExtras(bundle);

        startActivity(intent);
    }


}
