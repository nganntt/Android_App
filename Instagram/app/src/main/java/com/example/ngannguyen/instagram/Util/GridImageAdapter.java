package com.example.ngannguyen.instagram.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.ngannguyen.instagram.R;
import com.example.ngannguyen.instagram.Util.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

public class GridImageAdapter  extends ArrayAdapter<String> {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private int layoutResource;
    private String append;
    private ArrayList<String > imgURLs = new ArrayList<>(  );


    public GridImageAdapter(Context mContext,  int layoutResource, String append, ArrayList<String> imgURLs) {
        super(mContext,layoutResource,imgURLs);
        this.mContext = mContext;
        this.mLayoutInflater = (LayoutInflater)mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        this.layoutResource = layoutResource;
        this.append = append;
        this.imgURLs = imgURLs;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate( layoutResource,parent,false );
            viewHolder = new ViewHolder();
            viewHolder.mProgress = (ProgressBar) convertView.findViewById( R.id.grid_image_progess );   // in layout grid Image
            viewHolder.mImageView = (SquareImage) convertView.findViewById(R.id.grid_imageview  );             // in layout grid image
            convertView.setTag( viewHolder );
        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        String image = getItem( position );

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage( append + image, viewHolder.mImageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                if (viewHolder.mProgress == null){
                    viewHolder.mProgress.setVisibility( View.VISIBLE );
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                if (viewHolder.mProgress == null){
                    viewHolder.mProgress.setVisibility( View.GONE );
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                if (viewHolder.mProgress == null){
                    viewHolder.mProgress.setVisibility( View.GONE );
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                if (viewHolder.mProgress == null){
                    viewHolder.mProgress.setVisibility( View.GONE );
                }
            }
        } );


        return convertView;
    }

    public static class ViewHolder{
        SquareImage mImageView;
        ProgressBar mProgress;
    }



}
