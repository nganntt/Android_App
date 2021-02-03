package com.example.nguyenthithungan.recylerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";  //type logt
    private static final ArrayList mImage = new ArrayList();
    private static final ArrayList mName = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Log.d(TAG,"OnCreate Started");
        initImage();


    }

    private void initImage(){
        mImage.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        
        mName.add("Havasu Falls");

        mImage.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mName.add("Trondheim");

        mImage.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mName.add("Portugal");

        mImage.add("https://i.redd.it/j6myfqglup501.jpg");
        mName.add("Rocky Mountain National Park");


        mImage.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mName.add("Mahahual");

        mImage.add("https://i.redd.it/k98uzl68eh501.jpg");
        mName.add("Frozen Lake");


        mImage.add("https://i.redd.it/glin0nwndo501.jpg");
        mName.add("White Sands Desert");

        mImage.add("https://i.redd.it/obx4zydshg601.jpg");
        mName.add("Austrailia");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d( TAG, "initRecyclerView: " );
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        RecycleViewAdapter adapter = new RecycleViewAdapter( this, mImage, mName );
        recyclerView.setAdapter( adapter );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ));


    }

}
