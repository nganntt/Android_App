package com.example.nguyenthithungan.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    private static final String TAG = "Fragment1";

    private  Button btnNavFrag1;
    private Button btnNavFrag2;
    private Button btnNavFrag3;
    private Button btnNavSecondAct;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

      View view = inflater.inflate( R.layout.fragment1,container,false );
      btnNavFrag1 = (Button) view.findViewById(R.id.button1);
      btnNavFrag2 = (Button) view.findViewById( R.id.button2 );
      btnNavFrag3 = (Button) view.findViewById( R.id.button3 );
      btnNavSecondAct = (Button) view.findViewById( R.id.button4 );

      btnNavFrag1.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Log.d(TAG,"Going to Fragment 1");
              Toast.makeText(getActivity(),"Going to Activity 1",Toast.LENGTH_SHORT).show();

              //navigation to Fragment1
              ((MainActivity)getActivity()).setViewPager(0);

          }
      } );


        btnNavFrag2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Going to Fragment 2");
                Toast.makeText(getActivity(),"Going to Activity 2",Toast.LENGTH_SHORT).show();

                //navigation to Fragment1
                ((MainActivity)getActivity()).setViewPager(1);

            }
        } );

        btnNavFrag3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Going to Fragment 3");
                Toast.makeText(getActivity(),"Going to Activity 3",Toast.LENGTH_SHORT).show();

                //navigation to Fragment1
                ((MainActivity)getActivity()).setViewPager(2);

            }
        } );

        btnNavSecondAct.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Going to Second Activity");
                Toast.makeText(getActivity(),"Going to Second Activity",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(),SecondActivity.class);
                startActivity(intent);

            }
        } );

        return view;
    }
}
