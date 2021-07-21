package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.ui.login.user_author;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private Post post;
    private user_author user;
    private String[] url;
    private String[] link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user = (user_author)bundle.getSerializable("authorAccount");
        post = (Post)bundle.getSerializable("post");

        Resources res = getResources();
        url = getResources().getStringArray(R.array.download_url);
        link = getResources().getStringArray(R.array.link);

    }

    public void download(View v){

        Intent intent= new Intent (DetailActivity.this, DownloadActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", url[5]);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void official_link(View v){

        Intent intent= new Intent (DetailActivity.this, DownloadActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", link[5]);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoIndex(View v){

        Intent intent= new Intent (DetailActivity.this, IndexActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoForum(View v){

        Intent intent= new Intent (DetailActivity.this, ForumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){

        Intent intent= new Intent (DetailActivity.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}