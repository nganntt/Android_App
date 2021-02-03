package com.example.ngannguyen.instagram.Util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.ngannguyen.instagram.Home.MainActivity;
import com.example.ngannguyen.instagram.Profile.ProfileActivity;
import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Search.SearchActivity;
import com.example.ngannguyen.instagram.Share.ShareActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";
    public static void setupBottonNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);

    }
    public static void enableNagivationContext(final Context mcontext, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_house:                                              //ACTIVITY_NUM=0
                        Intent intent1 = new Intent(mcontext, MainActivity.class);
                        mcontext.startActivity(intent1 );

                        break;

                    case R.id.ic_search:
                        Intent intent2 = new Intent( mcontext, SearchActivity.class ); //ACTIVITY_NUM=1
                        mcontext.startActivity( intent2);
                        break;


                    case R.id.ic_circle:
                        Intent intent3 = new Intent( mcontext, ShareActivity.class ); //ACTIVITY_NUM=2
                        mcontext.startActivity( intent3);
                        break;


                    case R.id.ic_profile:
                        Intent intent4 = new Intent( mcontext, ProfileActivity.class ); //ACTIVITY_NUM=3
                        mcontext.startActivity( intent4);
                        break;


                }
                return false;
            }

        });
    }
}
