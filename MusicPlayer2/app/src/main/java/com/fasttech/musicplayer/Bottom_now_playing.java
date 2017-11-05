package com.fasttech.musicplayer;


import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ohoussein.playpause.PlayPauseView;
import com.twotoasters.jazzylistview.JazzyListView;

import co.mobiwise.library.MusicPlayerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bottom_now_playing extends Fragment {

    ImageView songimage;
    TextView songName,artist1;
    ProgressBar progressBar;
    PlayPauseView playPauseView;
    String[] name;
    String[] artistname;
    int image;
    Animation animation,animation2;
    boolean p = false;




    public Bottom_now_playing() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = null;
         view = inflater.inflate(R.layout.fragment_bottom_now_playing, container, false);
        songimage = (ImageView)view.findViewById(R.id.album_art_nowplayingcard);
        playPauseView = (PlayPauseView)view.findViewById(R.id.play_pause_view);
        progressBar = (ProgressBar)view.findViewById(R.id.song_progress_normal);
        songName = (TextView)view.findViewById(R.id.title12);
        artist1 = (TextView)view.findViewById(R.id.artist12);
        image = this.getArguments().getInt("KeyI");
        name = this.getArguments().getStringArray("KeyTitl");
        artistname = this.getArguments().getStringArray("KeyArt");
        songimage.setBackgroundResource(image);
        animation = AnimationUtils.loadAnimation(getContext(),android.R.anim.fade_out);
        animation2 = AnimationUtils.loadAnimation(getContext(),android.R.anim.fade_in);

        //songName.setText(name);
        playPauseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playPauseView.isPlay()){
                    p=true;
                    playPauseView.toggle();
                }else {
                    p=false;
                    playPauseView.toggle();
                }
            }
        });

        return view;
    }

    public void fragmentTitle(int i){
        songName.setText(name[i]);
    }

    public void fragmentArtist(int i){
        artist1.setText(artistname[i]);
    }

    public void fragmentButton(){
        playPauseView.toggle();
    }

    public void expand(){
        songimage.setVisibility(View.INVISIBLE);
        playPauseView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        songName.setVisibility(View.INVISIBLE);
        artist1.setVisibility(View.INVISIBLE);
    }

    public void collapse(){
        songimage.setVisibility(View.VISIBLE);
        playPauseView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        songName.setVisibility(View.VISIBLE);
        artist1.setVisibility(View.VISIBLE);
    }
    public void fadeOut(){
        songimage.startAnimation(animation);
        playPauseView.startAnimation(animation);
        progressBar.startAnimation(animation);
        songName.startAnimation(animation);
        artist1.startAnimation(animation);
    }

    public void fadeIn(){
        songimage.startAnimation(animation2);
        playPauseView.startAnimation(animation2);
        progressBar.startAnimation(animation2);
        songName.startAnimation(animation2);
        artist1.startAnimation(animation2);
    }





}
