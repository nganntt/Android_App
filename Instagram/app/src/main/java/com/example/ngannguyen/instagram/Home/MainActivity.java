package com.example.ngannguyen.instagram.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.example.ngannguyen.instagram.LoginActivity;
import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Util.BottomNavigationViewHelper;
import com.example.ngannguyen.instagram.Util.SectionPagerAdapter;
import com.example.ngannguyen.instagram.Util.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( com.example.ngannguyen.instagram.R.layout.activity_main );
        setupBottomNavigationView();
        setupViewPage();
        initImage();
    }

    public void setupBottomNavigationView() {
        Log.d( TAG, "Setup Bottom Navigation View" );
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById( R.id.navigation_bar );
        BottomNavigationViewHelper.setupBottonNavigationView( bottomNavigationViewEx );
        BottomNavigationViewHelper.enableNagivationContext( context, bottomNavigationViewEx );
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem( ACTIVITY_NUM );
        menuItem.setChecked( true );
    }

    @SuppressLint("ResourceType")
    public void setupViewPage() {
        SectionPagerAdapter adapter = new SectionPagerAdapter( getSupportFragmentManager() );
        adapter.addFragment( new CameraFragment() );
        adapter.addFragment( new HomeFragment() );
        adapter.addFragment( new MessageFragment() );

        ViewPager viewPager = (ViewPager) findViewById( com.example.ngannguyen.instagram.R.id.container_center );
        viewPager.setAdapter( adapter );

        TabLayout tabLayout = (TabLayout) findViewById( com.example.ngannguyen.instagram.R.id.tab_bar );
        tabLayout.setupWithViewPager( viewPager );

        tabLayout.getTabAt( 0 ).setIcon( R.drawable.ic_camera );
        tabLayout.getTabAt( 1 ).setIcon( R.drawable.ic_instagram );
        tabLayout.getTabAt( 2 ).setIcon( R.drawable.ic_message );

    }

    private void initImage(){
        UniversalImageLoader configuration = new UniversalImageLoader(context);
        ImageLoader.getInstance().init( configuration.getConfig() );


    }

}
