package com.example.nguyenthithungan.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button secondActivityBtn = (Button) findViewById(R.id.secondActivityBtn);
        Button googleBtn = (Button) findViewById(R.id.googleBtn);

        // Attempt to launch an activity within your own app
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("com.example.nguyenthithungan.quicklauncher.st", "Hello workd");

                startActivity(startIntent);

            }
        });


        //Attempt to launch an activity outside your app
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String googleLink = "http://google.com";
                Uri addrGoogle = Uri.parse(googleLink);
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, addrGoogle);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogle);

                }


            }
        });
    }
}
