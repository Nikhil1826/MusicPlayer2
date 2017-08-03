package com.fasttech.musicplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 7/26/2017.
 */

public class CategoryAdapter extends ArrayAdapter<Category> {
    Context context;
    int resource;
    ArrayList<Category> objects;

    public CategoryAdapter( Context context,  int resource,  ArrayList<Category> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view = null;
        view = LayoutInflater.from(context).inflate(resource,parent,false);


        ImageView imageView = view.findViewById(R.id.categoryimage);
        TextView textView = view.findViewById(R.id.categorytext);

        Category category = objects.get(position);
        imageView.setBackgroundResource(category.getImage());
        textView.setText(category.getName());

        return view;
    }


}
