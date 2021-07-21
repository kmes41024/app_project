package com.example.myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.login.user_author;
import com.example.myapplication.ui.login.user_organizer;

import java.io.FileNotFoundException;

public class Organizer_AccountActivity  extends AppCompatActivity {
    private TextView userName;
    private user_organizer member;
    private TextView language;
    private TextView languageText;
    private TextView postText;
    private TextView nightText;
    private TextView messageText;
    private ImageView userImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer__account);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        member = (user_organizer)bundle.getSerializable("organizerAccount");

        userName = findViewById(R.id.userName);
        userName.setText(member.userid);

        language = findViewById(R.id.language);
        languageText = findViewById(R.id.languageText);
        postText = findViewById(R.id.postText);
        nightText = findViewById(R.id.nightText);
        messageText = findViewById(R.id.messageText);

        userImg = findViewById(R.id.imageView2);
    }

    public void changeImg(View v){
        Intent intent = new Intent();
        //開啟Pictures畫面Type設定為image
        intent.setType("image/*");
        //使用Intent.ACTION_GET_CONTENT這個Action                                            //會開啟選取圖檔視窗讓您選取手機內圖檔
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //取得相片後返回本畫面
        startActivityForResult(intent, 1);
    }

    //取得相片後返回的監聽式
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //當使用者按下確定後
        if (resultCode == RESULT_OK) {
            //取得圖檔的路徑位置
            Uri uri = data.getData();
            //寫log
            Log.e("uri", uri.toString());
            //抽象資料的接口
            ContentResolver cr = this.getContentResolver();
            try {
                //由抽象資料接口轉換圖檔路徑為Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                //取得圖片控制項ImageView
                ImageView imageView = (ImageView) findViewById(R.id.imageView2);
                // 將Bitmap設定到ImageView
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("Exception", e.getMessage(),e);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void languageBtnClick(View v){
        if(language.getText().toString().equals("English")){
            language.setText("繁體中文");
            languageText.setText(" 語言");
            postText.setText(" 我的發文");
            nightText.setText(" 夜間模式");
            messageText.setText(" 消息通知");
        }
        else{
            language.setText("English");
            languageText.setText(" Language");
            postText.setText(" My Post");
            nightText.setText(" Night Shift");
            messageText.setText(" Message");
        }
    }

    public void gotoIndex(View v){

        Intent intent= new Intent (Organizer_AccountActivity.this, OrganizerIndexActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("organizerAccount", member);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}
