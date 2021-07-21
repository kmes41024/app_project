package com.example.myapplication.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class Signup_AuthorActivity extends AppCompatActivity {
    private String userid;
    private String password;
    private String email;
    private String category;

    public ArrayList<user_author> user_author_group;
    public int authorCount;

    private Spinner spinner01; //喧告Spinner物件
    private String[] list = {"Computer Science","Artificial Intelligence",
            "Machine Learning","Security",
            "Software Engineering","Data Mining","Information Technology",
            "Communications", "Networking",
            "Big Data","Cloud Computing",
            "Signal Processing","Image Processing",
            "NLP","Multimedia", "Computer Vision"}; //喧告字串陣列
    private ArrayAdapter<String> listAdapter; //喧告listAdapter物件

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_signup);

        spinner01=(Spinner)findViewById(R.id.category); //指向畫面上id為changetype1的Spinner物件
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spinner01.setAdapter(listAdapter);

        spinner01.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                category = spinner01.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView arg0) { }

        });


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user_author_group = (ArrayList<user_author>)bundle.getSerializable("authorAccount");
        userid = intent.getStringExtra("userid");
        password = intent.getStringExtra("password");
        email = intent.getStringExtra("useroffmail");
        authorCount = intent.getIntExtra("authorCount", 0);
    }

    public void gotologinA(View v){
        user_author_group.add(new user_author(authorCount, userid, password, email, category));
        authorCount++;

        Intent intent = new Intent(Signup_AuthorActivity.this, Login_AuthorActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user_author_group);
        intent.putExtra("authorCount", authorCount);
        intent.putExtras(bundle);

        startActivity(intent);
    }


}