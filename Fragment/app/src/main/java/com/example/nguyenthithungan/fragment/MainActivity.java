package com.example.nguyenthithungan.fragment;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SectionStatePagerAdapter mSectionStatePagerAdapter;
    private ViewPager mviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Log.d(TAG,"Start Main Activity");


        mSectionStatePagerAdapter = new SectionStatePagerAdapter( getSupportFragmentManager() );
        mviewPager = (ViewPager) findViewById( R.id.container );

        //setup viewPager

        setupViewPager( mviewPager );
    }

    private void setupViewPager(ViewPager viewPager){
        SectionStatePagerAdapter adapter = new SectionStatePagerAdapter( getSupportFragmentManager() );
        adapter.addFragment(new Fragment1(), "Fragment1");
        adapter.addFragment(new Fragment2(),"Fragement2" );
        adapter.addFragment(new Fragment3(),"Fragement3" );
        viewPager.setAdapter( adapter );
    }

    public void setViewPager(int fragmentNumber){
        mviewPager.setCurrentItem( fragmentNumber );
    }
}
