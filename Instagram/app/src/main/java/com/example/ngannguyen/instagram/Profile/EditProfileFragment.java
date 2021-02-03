package com.example.ngannguyen.instagram.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Util.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";

    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate( R.layout.fragment_edit_profile,container,false );
        Log.d(TAG,"OncreateView");

        imageView = (ImageView) view.findViewById( R.id.image_profile );
       // initImage();
        setProfileImage();

        ImageView imageBack = (ImageView) view.findViewById( R.id.back_arrow_edit );
        imageBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"OnClickListener backIcon");
                (getActivity()).finish();
            }
        } );

        return view;
    }

    private void setProfileImage(){
        String imgaeURL = "http://baochinhphu.vn/Uploaded/dangdinhnam/2018_07_11/cam-danh-bat-ca-vinh-ha-long.jpg";

        UniversalImageLoader.setImage( imgaeURL,imageView,null,"" );

    }
/*
    private void initImage(){
        UniversalImageLoader configuration = new UniversalImageLoader(getContext());
        ImageLoader.getInstance().init( configuration.getConfig() );


    }
*/



}
