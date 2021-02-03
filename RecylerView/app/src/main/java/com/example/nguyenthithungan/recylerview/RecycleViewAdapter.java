package com.example.nguyenthithungan.recylerview;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

// after create ViewHolder, extend RecyclerViewAdapter with type of adapter is Viewhold which is created before
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    //this variable for debug purpose
    private static final String TAG="RecycleViewAdapter";


    private ArrayList<String> imageList = new ArrayList<>( );
    private ArrayList<String> textList = new ArrayList<>();
    private Context context;

    public RecycleViewAdapter(Context context,ArrayList<String> imageList, ArrayList<String> textList ) {
        this.imageList = imageList;
        this.textList = textList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view ,parent,false);
        ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
       Log.d(TAG,"called method OnBindViewHolder");
        Glide.with( context )
                .asBitmap()
                .load(imageList.get(position))  // load image URL
                .into(holder.image);   // into image holder
        holder.text.setText( textList.get( position ) );
        holder.parentLayout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"ON Click Listener"+ textList.get(position));
                Toast.makeText(context, textList.get(position), Toast.LENGTH_LONG).show();
            }
        } );



    }

    @Override
    // getting how many items in the list  -> important, if return 0, nothing is showed
    public int getItemCount() {

        return imageList.size();
    }


    //ViewHolder holp widgets in memory of each individual entry( item in the list )
    //hold that view and getting to add it to the next one....
    public class ViewHolder extends RecyclerView.ViewHolder{

        //define widgets
        ImageView image;
        TextView text;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super( itemView );

            image = itemView.findViewById( R.id.image_item );
            text = itemView.findViewById(R.id.name_item);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
