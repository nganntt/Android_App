package com.example.nguyenthithungan.loadimage;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private  static final String TAG= "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Log.d(TAG,"ImageView show");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        int imageResource = getResources().getIdentifier("@drawable/beach",null,this.getPackageName());

        imageView.setImageResource(imageResource);




    }
}
