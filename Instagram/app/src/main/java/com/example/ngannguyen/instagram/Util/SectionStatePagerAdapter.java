package com.example.ngannguyen.instagram.Util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter  extends FragmentStatePagerAdapter{

    List<Fragment> fragmentList = new ArrayList<>(  );

    HashMap<Fragment,Integer> mFragment = new HashMap<>(  );
    HashMap<Integer,String> fragmentName = new HashMap<>(  );
    HashMap<String,Integer> fragmentNumber = new HashMap<>(  );


    public Integer getFragmentNum (String mFragmentName){
        if (fragmentNumber.containsKey( mFragmentName )){
            return fragmentNumber.get( mFragmentName );
        }else {
            return null;
        }
    }


    public String getFragmentName (int mFragmentNum){
        if (fragmentName.containsKey( mFragmentNum )){
            return fragmentName.get( mFragmentNum );
        }else {
            return null;
        }
    }


    public Integer getFragmentMember (Fragment fragment){
        if (mFragment.containsKey( fragment )){
            return mFragment.get( fragment );
        }else {
            return null;
        }
    }

    public void addFragment(Fragment fragment, String mFragmentName){
        fragmentList.add( fragment );
        mFragment.put( fragment,fragmentList.size()-1 );
        fragmentName.put( fragmentList.size()-1,mFragmentName );
        fragmentNumber.put( mFragmentName,fragmentList.size()-1 );
    }



    public SectionStatePagerAdapter(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get( position );
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
