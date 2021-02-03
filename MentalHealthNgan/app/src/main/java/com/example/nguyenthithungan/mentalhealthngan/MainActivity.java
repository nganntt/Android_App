package com.example.nguyenthithungan.mentalhealthngan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
      //  setContentView( R.layout.activity_main );
        setContentView( R.layout.activity_main );

        Button btnLoginMain = (Button) findViewById(R.id.login_main);
        Button btnView = (Button)findViewById(R.id.btnView);
       btnLoginMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "on Click button Login");
                Intent mIntent = new Intent(MainActivity.this, Login.class);
                startActivity(mIntent);
            }
        });




    }




}




