package com.example.nguyenthithungan.listapp;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycleView;

   ArrayAdapter<String> Adapterlist;
   String[] lItem;

   RecyclerView.Adapter adapter;
   RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        recycleView = (RecyclerView) findViewById(R.id.recycleView);

        lItem = res.getStringArray(R.array.itemsJ);


        layoutManager = new LinearLayoutManager( this );
        recycleView.setLayoutManager( layoutManager );


        adapter = new



    }
}
