package com.fasttech.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.name;


/**
 * Created by dell on 7/27/2017.
 */

public class CategorySelectedAdapter extends RecyclerView.Adapter<CategorySelectedAdapter.ViewHolder> {

    ArrayList<CategorySelected> albumslist;
    Context context;



    public CategorySelectedAdapter(ArrayList<CategorySelected> albumslist, Context context) {
        this.albumslist = albumslist;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_albums,parent,false);
        ViewHolder vh = new ViewHolder(view,context,albumslist);

        return vh;
    }

    @Override
    public void onBindViewHolder(CategorySelectedAdapter.ViewHolder holder, int position) {
        CategorySelected categorySelected = albumslist.get(position);
        holder.imageView.setBackgroundResource(categorySelected.getImage());
        holder.textView.setText(categorySelected.getAlbumname());

    }

    @Override
    public int getItemCount() {
        return albumslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        ArrayList<CategorySelected> albumslist;
        Context context;

        public ViewHolder(View itemView, Context context, ArrayList<CategorySelected> albumslist) {
            super(itemView);
            this.albumslist = albumslist;
            this.context = context;
            itemView.setOnClickListener(this);
            imageView = (ImageView)itemView.findViewById(R.id.albumsimage);
            textView = (TextView)itemView.findViewById(R.id.albumstext);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            CategorySelected categorySelected = this.albumslist.get(position);
            Intent intent = new Intent(this.context,LoadingSongsActivity.class);
            intent.putExtra("KeyImg",categorySelected.getImage());
            intent.putExtra("KeyName",categorySelected.getAlbumname());


            this.context.startActivity(intent);
        }
    }
}
