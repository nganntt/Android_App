package com.example.ngannguyen.instagram.Home;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment ;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngannguyen.instagram.R;

public class HomeFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate( R.layout.fragment_home,container,false );
        return view;
    }
}
