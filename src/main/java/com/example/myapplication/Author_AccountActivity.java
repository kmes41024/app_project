package com.example.myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import org.w3c.dom.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Author_AccountActivity extends AppCompatActivity{
    private TextView userName;
    private user_author member;
    private TextView language;
    private TextView languageText;
    private TextView historyText;
    private TextView nightText;
    private TextView messageText;
    private ImageView userImg;
    private TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_account);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        member = (user_author)bundle.getSerializable("authorAccount");
//
        userName = findViewById(R.id.userName);
        userName.setText(member.userid);

        language = findViewById(R.id.language);
        languageText = findViewById(R.id.languageText);
        historyText = findViewById(R.id.historyText);
        nightText = findViewById(R.id.nightText);
        messageText = findViewById(R.id.messageText);
        titleText = findViewById(R.id.title);

        userImg = findViewById(R.id.imageView2);
    }

    public void changeImg(View v){
        Intent intent = new Intent();
        //??????Pictures??????Type?????????image
        intent.setType("image/*");
        //??????Intent.ACTION_GET_CONTENT??????Action                                            //??????????????????????????????????????????????????????
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //??????????????????????????????
        startActivityForResult(intent, 1);
    }

    //?????????????????????????????????
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //???????????????????????????
        if (resultCode == RESULT_OK) {
            //???????????????????????????
            Uri uri = data.getData();
            //???log
            Log.e("uri", uri.toString());
            //?????????????????????
            ContentResolver cr = this.getContentResolver();
            try {
                //??????????????????????????????????????????Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                //?????????????????????ImageView
                ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                // ???Bitmap?????????ImageView
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void historyBtnClick(View v){

    }

    public void languageBtnClick(View v){
        if(language.getText().toString().equals("English")){
            language.setText("????????????");
            languageText.setText(" ??????");
            historyText.setText(" ????????????");
            nightText.setText(" ????????????");
            messageText.setText(" ????????????");
            titleText.setText("????????????");
        }
        else{
            language.setText("English");
            languageText.setText(" Language");
            historyText.setText(" History");
            nightText.setText(" Night Shift");
            messageText.setText(" Message");
            titleText.setText("My Account");
        }
    }

    public void gotoForum(View v){

        Intent intent= new Intent (Author_AccountActivity.this, ForumActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", member);
        intent.putExtras(bundle);

        startActivity(intent);

    }

    public void gotoFavorite(View v){

        Intent intent= new Intent (Author_AccountActivity.this, FavoriteActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", member);
        intent.putExtras(bundle);

        startActivity(intent);

    }

    public void gotoIndex(View v){

        Intent intent= new Intent (Author_AccountActivity.this, IndexActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("authorAccount", member);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}
