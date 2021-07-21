package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.example.myapplication.ui.login.Login_AuthorActivity;
import com.example.myapplication.ui.login.Signup_Author_NextActivity;
import com.example.myapplication.ui.login.user_author;
import com.example.myapplication.ui.login.user_organizer;
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

public class ForumActivity extends AppCompatActivity{
    private TextView postName;
    public ArrayList<Posts> allPost = new ArrayList<>();;
    public ArrayList<String>tmp = new ArrayList<>();;
    private user_author user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        user =  (user_author)bundle.getSerializable("authorAccount");

        allPost.add(new Posts(0,"投期刊要注意的事項","最近想投一篇期刊\n但以前沒接觸過，是個大新手\n請問投稿有什麼需要注意的地方嗎", tmp, true, "Mandy"));
        allPost.add(new Posts(1,"哪些會議今年改成線上","如題，\n今年因為疫情的關係很多都改線上\n有哪些是已經確定的嗎", tmp, true, "Mark"));
        tmp.add("年末文章多\n返修1~2月正常\n請樓主耐心等待");
        tmp.add("我剛有一篇大修返回兩個半月的小修\n原因是換了一個審稿人");
        tmp.add("這種情況很多");
        allPost.add(new Posts(2,"SCI大修後沒消息","一篇論文大修後12/11返回\n12/20送審後到現在都沒消息\n不知道是什麼情況\n請大家給一下意見", tmp, false, "Judy"));
        tmp.clear();
        allPost.add(new Posts(3,"有人投過AISC嗎","如題，\n有人投稿過AISC嗎?\n求給點意見", tmp, true, "Jade"));
        allPost.add(new Posts(4,"CCML 需要用英文寫嗎","如題，\nCCML期刊的內容需要用英文寫嗎?", tmp, true, "Eric"));
        allPost.add(new Posts(5,"第一次投稿該怎麼準備","如題，\n本人第一次投稿，請問有什麼準備的小訣竅嗎?", tmp, true, "Peter"));
        tmp.add("再等等看吧\n我之前也等了一陣子");
        tmp.add("樓主的目前怎麼樣了\n我也是這個狀態");
        tmp.add("我記得這個期刊初審都審很久");
        allPost.add(new Posts(6,"請問MDPI一般初審多久", "聽說最近MDPI秒拒特別多\n問問大家一般初審要多久?\n投了一個期刊，目前48小時沒消息", tmp,false, "Chris"));
        tmp.clear();
        allPost.add(new Posts(7,"TMHH投稿要注意啥","如題，\nTMHH投稿要注意啥\n求高手分享", tmp, true, "Kevin"));
    }

    public void btnClick0(View v){
        Posts clickPost = allPost.get(0);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick1(View v){
        Posts clickPost = allPost.get(1);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick2(View v){
        Posts clickPost = allPost.get(2);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick3(View v){
        Posts clickPost = allPost.get(3);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick4(View v){
        Posts clickPost = allPost.get(4);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick5(View v){
        Posts clickPost = allPost.get(5);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick6(View v){
        Posts clickPost = allPost.get(6);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }
	
    public void btnClick7(View v){
        Posts clickPost = allPost.get(7);
        Intent intent = new Intent(ForumActivity.this, showPostActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("clickPost", clickPost);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void gotoIndex(View v){

        Intent intent= new Intent (ForumActivity.this, IndexActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoFavorite(View v){

        Intent intent= new Intent (ForumActivity.this, FavoriteActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void gotoAccount(View v){

        Intent intent= new Intent (ForumActivity.this, Author_AccountActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
