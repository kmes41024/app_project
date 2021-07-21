package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.ui.artificial_intelligence.Artificial_IntelligenceViewModel;
import com.example.myapplication.ui.login.user_author;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Next extends AppCompatActivity{
    private user_author user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void gotoIndex(View v){
        Intent intent= new Intent (Next.this, IndexActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoForum(View v){
        Intent intent= new Intent (Next.this, ForumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){
        Intent intent= new Intent (Next.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}




