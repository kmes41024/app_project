package com.example.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.myapplication.ui.login.Login_AuthorActivity;
import com.example.myapplication.ui.login.user_author;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class IndexActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    user_author user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user =  (user_author)bundle.getSerializable("user");
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);




        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_artificial_intelligence, R.id.nav_big_data, R.id.nav_cloud_computing, R.id.nav_communications,
                R.id.nav_computer_science, R.id.nav_computer_vision, R.id.nav_data_mining, R.id.nav_image_processing,
                R.id.nav_information_technology, R.id.nav_machine_learning, R.id.nav_multimedia, R.id.nav_networking,
                R.id.nav_NLP, R.id.nav_security, R.id.nav_signal_processing, R.id.nav_software_engineering)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration);
    }

    public void gotoForum(View v){
        Intent intent= new Intent (IndexActivity.this, ForumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void gotoFavorite(View v){

        Intent intent= new Intent (IndexActivity.this, FavoriteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){

        Intent intent= new Intent (IndexActivity.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}