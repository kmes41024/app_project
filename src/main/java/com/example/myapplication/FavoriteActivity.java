package com.example.myapplication;

        import android.content.Intent;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.Menu;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.Toast;

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

public class FavoriteActivity extends AppCompatActivity{

    private RecyclerView recycler_view;
    private Button btnAdd;
    private MyAdapter adapter;
    private ArrayList<Post> mData;
    private user_author user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

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

    public void gotoIndex(View v){

        Intent intent= new Intent (FavoriteActivity.this, IndexActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoForum(View v){

        Intent intent= new Intent (FavoriteActivity.this, ForumActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){

        Intent intent= new Intent (FavoriteActivity.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoNext(View v){
        Toast.makeText(this, "Remove NeCoM 2021 : 13th International Conference on Networks & Communications" + " from your favorite !!", Toast.LENGTH_SHORT).show();

        Intent intent= new Intent (FavoriteActivity.this, FavoriteNextActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}