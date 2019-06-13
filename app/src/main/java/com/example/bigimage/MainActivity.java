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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);

        List<String > datas = new ArrayList<>();
        datas.add("https://upload-images.jianshu.io/upload_images/7704655-5925a9b7743a1526.png?imageMogr2/auto-orient/");

        final Intent intent = new Intent(MainActivity.this, BigImageActivity.class);

        intent.putExtra("images", (ArrayList<String>) datas);//非必须
        intent.putExtra("position", 0);
        int[] location = new int[2];
        imageView.getLocationOnScreen(location);
        intent.putExtra("locationX", location[0]);//必须
        intent.putExtra("locationY", location[1]);//必须

        intent.putExtra("width", imageView.getWidth());//必须
        intent.putExtra("height", imageView.getHeight());//必须
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });










    }
}
