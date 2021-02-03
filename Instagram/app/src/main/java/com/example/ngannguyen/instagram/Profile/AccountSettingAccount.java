package com.example.ngannguyen.instagram.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Util.BottomNavigationViewHelper;
import com.example.ngannguyen.instagram.Util.SectionStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class AccountSettingAccount extends AppCompatActivity {
    private static final String TAG = "AccountSettingAccount";
    private static final int ACTIVITY_NUM=3;
    private Context context = AccountSettingAccount.this;

    //fragment
    private SectionStatePagerAdapter apdapter;
    private ViewPager pager;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_account_setting );
        Log.d(TAG,"onCreate AccountSettingProfile");


        ImageView backImage = (ImageView) findViewById( R.id.arrow_back);
        backImage.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick navigation back to profileActivity");
                finish();
            }
        } );


        //setup listview with statePaperAdapter
        pager = (ViewPager) findViewById( R.id.container_center );
        relativeLayout = (RelativeLayout) findViewById( R.id.rel_account_setting_layout_all );

        setupFragment();
        setupSettingList();
        //setup bottomNavigation
        setupBottomNavigationView();


    }


    public void setupFragment(){
        apdapter = new SectionStatePagerAdapter( getSupportFragmentManager() );
        apdapter.addFragment( new EditProfileFragment(), getString( R.string.edit_option ) );
        apdapter.addFragment( new SignOutProfileFragment(), getString( R.string.sign_out ) );

    }
    public void setupViewPager(int fragmentNum){
        relativeLayout.setVisibility( View.GONE );
        pager.setAdapter( apdapter );
        pager.setCurrentItem( fragmentNum );

    }



    public void setupSettingList(){
        ListView listView = (ListView) findViewById( R.id.list_account_setting);

        ArrayList<String> option = new ArrayList<>(  );
        option.add( getString( R.string.edit_option ) );
        option.add(getString( R.string.sign_out ));

        ArrayAdapter adapter = new ArrayAdapter( context,android.R.layout.simple_list_item_1,option );
        listView.setAdapter( adapter );


        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setupViewPager( position );
                Log.d( TAG, "setOnItemClickListener onItemClick" );
            }
        } );


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



}
