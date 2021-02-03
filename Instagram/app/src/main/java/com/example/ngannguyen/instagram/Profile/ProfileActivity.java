package com.example.ngannguyen.instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;


import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Util.BottomNavigationViewHelper;
import com.example.ngannguyen.instagram.Util.GridImageAdapter;
import com.example.ngannguyen.instagram.Util.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int ACTIVITY_NUM=3;
    private  static final int NUM_COLUMN =3;
    private Context context = ProfileActivity.this;
    private ImageView imageView;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_profile );
        Log.d(TAG,"onCreate started");
        setupBottomNavigationView(); // this will generate error

        setupToolBar();

        setUpWidget();
        setupImageProfile();

        tempGridSetup();

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

    public void setupToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profile_bar);
        setSupportActionBar(toolbar);
        ImageView menuProfile = (ImageView) findViewById( R.id.menu_profile_image );
        menuProfile.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AccountSettingAccount.class );
                startActivity( intent );
            }
        } );

    }

    public void setUpWidget(){
        imageView = (ImageView)findViewById( R.id.image_profile );
        ProgressBar progressBar = (ProgressBar)findViewById( R.id.progressbar_profile_activity ) ;
        progressBar.setVisibility( View.GONE );

    }

    public void setupImageProfile(){
        String imgaeURL = "http://baochinhphu.vn/Uploaded/dangdinhnam/2018_07_11/cam-danh-bat-ca-vinh-ha-long.jpg";
        UniversalImageLoader.setImage( imgaeURL,imageView,null,"" );
    }


    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>(  );
        imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

        setupImageGrid( imgURLs );

    }

    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById( R.id.grid_image_profile );
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth /NUM_COLUMN;
        gridView.setColumnWidth( imageWidth );

        GridImageAdapter adaper = new GridImageAdapter( context,R.layout.layout_grid_image,"",imgURLs );
        gridView.setAdapter( adaper );
    }
}
