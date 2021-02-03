package com.example.nguyenthithungan.intent;

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
        setContentView( R.layout.activity_main );

        Button button1 =(Button)findViewById( R.id.button1 );
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "On click Listener 1");
                Intent intent = new Intent( MainActivity.this, SecondScreen.class );
                startActivity( intent );
            }
        } );
    }
}
