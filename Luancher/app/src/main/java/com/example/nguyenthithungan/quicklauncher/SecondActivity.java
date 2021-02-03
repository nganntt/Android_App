package com.example.nguyenthithungan.quicklauncher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        if (getIntent().hasExtra("com.example.nguyenthithungan.quicklauncher.st")){
            TextView tv = (TextView) findViewById(R.id.textView);
            String text = getIntent().getExtras().getString("com.example.nguyenthithungan.quicklauncher.st");
            tv.setText(text);
        }
    }
}
