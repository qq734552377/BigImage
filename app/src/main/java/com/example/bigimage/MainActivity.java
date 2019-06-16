package com.example.bigimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView imageView ;
    List<String > datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(MainActivity.this, BigImageActivity.class);
                if (datas == null) {
                    datas = new ArrayList<>();
                    datas.add("https://upload-images.jianshu.io/upload_images/7704655-5925a9b7743a1526.png?imageMogr2/auto-orient/");
                    datas.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560449962488&di=b480f3077ed8725bcfaee963b3297185&imgtype=0&src=http%3A%2F%2Fimglf0.ph.126.net%2FhM-pIsktLf7EpeGoOiHeOQ%3D%3D%2F868631778229234614.jpg");
                }
                intent.putExtra("images", (ArrayList<String>) datas);//非必须
                intent.putExtra("position", 1);
                int[] location = new int[2];
                imageView.getLocationOnScreen(location);
                intent.putExtra("locationX", location[0]);//必须
                intent.putExtra("locationY", location[1]);//必须

                intent.putExtra("width", imageView.getWidth());//必须
                intent.putExtra("height", imageView.getHeight());//必须
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });










    }
}
