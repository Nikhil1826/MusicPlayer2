package com.fasttech.musicplayer;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ohoussein.playpause.PlayPauseView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bottom_now_playing extends Fragment {

    ImageView songimage;
    //TextView songName;
    PlayPauseView playPauseView;


    public Bottom_now_playing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = null;
         view = inflater.inflate(R.layout.fragment_bottom_now_playing, container, false);
        songimage = (ImageView)view.findViewById(R.id.album_art_nowplayingcard);
        playPauseView = (PlayPauseView)view.findViewById(R.id.play_pause_view);
        //songName = (TextView)view.findViewById(R.id.title);
        int image = this.getArguments().getInt("KeyI");
        String name = this.getArguments().getString("KeySongName");
        songimage.setBackgroundResource(image);
        //songName.setText(name);
        playPauseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playPauseView.toggle();
            }
        });

        return view;
    }

}
