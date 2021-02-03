package com.example.ngannguyen.instagram.Search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Util.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class SearchActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int ACTIVITY_NUM=1;
    private Context context = SearchActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        Log.d(TAG,"onCreate started");
        setupBottomNavigationView();
    }

    public void setupBottomNavigationView(){
        Log.d(TAG,"Setup Bottom Navigation View");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.navigation_bar);
        BottomNavigationViewHelper.setupBottonNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNagivationContext( context,bottomNavigationViewEx );
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem( ACTIVITY_NUM );
        menuItem.setChecked( true );

    }
}
