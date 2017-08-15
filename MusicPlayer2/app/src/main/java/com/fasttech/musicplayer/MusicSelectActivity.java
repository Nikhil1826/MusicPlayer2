package com.fasttech.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.RemoteControlClient;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import jp.wasabeef.blurry.Blurry;

public class MusicSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ImageView imageView,songimage,songPlayingImage;
    JazzyListView songslist;
    ArrayAdapter<String> adapter;
    Bottom_now_playing bottom_now_playing;
    FragmentManager fragmentManager;
    TextView musicTitle,artistName;
    String mtitle[];





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_select);
        bottom_now_playing = new Bottom_now_playing();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.upper,bottom_now_playing).commit();

        songimage = (ImageView)findViewById(R.id.album_art_nowplayingcard);
        songPlayingImage = (ImageView)findViewById(R.id.songPlayingImage);
        musicTitle = (TextView)findViewById(R.id.title);
        artistName = (TextView)findViewById(R.id.artist);
        imageView = (ImageView) findViewById(R.id.imageView2);
        songslist = (JazzyListView)findViewById(R.id.musiclist);
        songslist.setTransitionEffect(JazzyHelper.TWIRL);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent rcv = getIntent();
        int image = rcv.getIntExtra("KeyImg",0);
        String name = rcv.getStringExtra("KeyName");
         mtitle = rcv.getStringArrayExtra("KeyTitle");

        getSupportActionBar().setTitle(name);
        imageView.setBackgroundResource(image);
        songPlayingImage.setBackgroundResource(image);



       /* Blurry.with(MusicSelectActivity.this)
                .radius(10)
                .sampling(800)
                .color(Color.argb(66, 255, 255, 0))
                .async()
                .animate(500)
                .capture(findViewById(R.id.songPlayingImage))
                .into((ImageView)findViewById(R.id.songPlayingImage));*/


        switch (name){
            case "Ae Dil Hai Mushkil":
                for (int i =0;i<6;i++) {
                    adapter.add(mtitle[i]);
                }
                break;
            case "Badrinath Ki Dulhania":
                for (int i =0;i<5;i++) {
                    adapter.add(mtitle[i]);
                }
                break;
            /*case "Dangal":

                break;
            case "Sultan":

                break;*/




        }

        songslist.setAdapter(adapter);

        songslist.setOnItemClickListener(this);





    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        switch (i){
            case 0 :
                //musicTitle.setText(mtitle[0]);
                break;
        }

    }
}
