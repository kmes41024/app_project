package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ui.login.user_author;

import java.util.ArrayList;

public class FavoriteNextActivity extends AppCompatActivity {


    private RecyclerView recycler_view;
    private Button btnAdd;
    private MyAdapter adapter;
    private ArrayList<Post> mData;
    private user_author user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_next);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user =  (user_author)bundle.getSerializable("authorAccount");


        // 設置格線
        Resources res = getResources();
        String[] title = getResources().getStringArray(R.array.title);
        String[] start = res.getStringArray(R.array.startdate);
        String[] end = res.getStringArray(R.array.enddate);
        String[] place = res.getStringArray(R.array.place);
        String[] sub = res.getStringArray(R.array.subdeadline);
        String[] noti = res.getStringArray(R.array.notificationdue);
        String[] Final = res.getStringArray(R.array.finalVersiondue);
        String[] c1 = res.getStringArray(R.array.category1);
        String[] c2 = res.getStringArray(R.array.category2);
        String[] c3 = res.getStringArray(R.array.category3);
        String[] link = res.getStringArray(R.array.link);
        String[] icon = res.getStringArray(R.array.icon);
    }

    public void gotoForum(View v){

        Intent intent= new Intent (FavoriteNextActivity.this, ForumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){

        Intent intent= new Intent (FavoriteNextActivity.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoIndex(View v){
        Intent intent= new Intent (FavoriteNextActivity.this, IndexActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void gotoDetail(View v){
        Intent intent= new Intent (FavoriteNextActivity.this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

}