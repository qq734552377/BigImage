package com.example.bigimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class BigImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_big_image);


        List<String> mDatas = (ArrayList<String>) getIntent().getSerializableExtra("images");
        int mPosition = getIntent().getIntExtra("position", 0);
        int mLocationX = getIntent().getIntExtra("locationX", 0);
        int mLocationY = getIntent().getIntExtra("locationY", 0);
        int mWidth = getIntent().getIntExtra("width", 0);
        int mHeight = getIntent().getIntExtra("height", 0);

        SmoothImageView imageView = new SmoothImageView(this);
        imageView.setOriginalInfo(mWidth, mHeight, mLocationX, mLocationY);
        imageView.transformIn();
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        setContentView(imageView);
        Glide.with(this).load(mDatas.get(mPosition)).into(imageView);
        setContentView(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });

    }
}
