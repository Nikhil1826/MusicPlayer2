package com.fasttech.musicplayer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import dmax.dialog.SpotsDialog;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;
import jp.wasabeef.blurry.Blurry;

public class MusicSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ImageView imageView,songPlayingImage;
    JazzyListView songslist;
    ArrayAdapter<String> adapter;
    Bottom_now_playing bottom_now_playing;
    FragmentManager fragmentManager;
    String mtitle[];
    String urlaedil[];
    String urlbadri[];
    MediaPlayer mediaPlayer;
    SpotsDialog alertDialog;
    private int mediaFileLength;
    private int realtimeLength;
    //final Handler handler = new Handler();
    String name;
    SmoothProgressBar smoothProgressBar,smoothProgressBar1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_select);
        Intent rcv = getIntent();
        int image = rcv.getIntExtra("KeyImg",0);
        name = rcv.getStringExtra("KeyName");
        mtitle = rcv.getStringArrayExtra("KeyTitle");
        urlaedil = rcv.getStringArrayExtra("KeyAe");
        urlbadri = rcv.getStringArrayExtra("KeyBadri");
        mediaPlayer = new MediaPlayer();

        Bundle bundle = new Bundle();
        bundle.putInt("KeyI",image);



        bottom_now_playing = new Bottom_now_playing();
        bottom_now_playing.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.upper,bottom_now_playing).commit();


        smoothProgressBar = (SmoothProgressBar)findViewById(R.id.progressBar);
        smoothProgressBar1 = (SmoothProgressBar)findViewById(R.id.progressBar1);
        songPlayingImage = (ImageView)findViewById(R.id.songPlayingImage);
        imageView = (ImageView) findViewById(R.id.imageView2);
        songslist = (JazzyListView)findViewById(R.id.musiclist);
        songslist.setTransitionEffect(JazzyHelper.TWIRL);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setTitle(name);
        imageView.setBackgroundResource(image);
        //songPlayingImage.setBackgroundResource(image);

        smoothProgressBar.progressiveStart();
        smoothProgressBar1.progressiveStart();


       /*Blurry.with(MusicSelectActivity.this)
                .radius(1000)
                .sampling(800)
                .color(Color.argb(255, 255, 255, 0))
                .async()
                .animate(1500)
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
                for (int i =0;i<6;i++) {
                    adapter.add(mtitle[i]);
                }

                break;
            case "Sultan":

                break;*/




        }

        songslist.setAdapter(adapter);

        songslist.setOnItemClickListener(this);

    }




    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        switch (name){
            case "Ae Dil Hai Mushkil":
                switch (i){
                    case 0 :
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlaedil[0]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play.execute();

                        break;
                    case 1:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play1 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlaedil[1]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play1.execute();
                        break;
                    case 2:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play2 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlaedil[2]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play2.execute();
                        break;
                    case 3 :
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play3 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlaedil[3]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play3.execute();
                        break;
                    case 4:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play4 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlaedil[4]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play4.execute();
                        break;
                    case 5:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play5 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlaedil[5]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play5.execute();
                        break;
                }
                break;


            case "Badrinath Ki Dulhania":
                switch (i){
                    case 0:
                    alertDialog = new SpotsDialog(this, R.style.Custom);
                    AsyncTask<String,String,String> mp3Play = new AsyncTask<String, String, String>() {

                        @Override
                        protected void onPreExecute() {
                            pre();
                        }
                        @Override
                        protected String doInBackground(String... strings) {
                            try {
                                mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlbadri[0]));
                                mediaPlayer.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            return "";
                        }
                        @Override
                        protected void onPostExecute(String s) {
                            post();
                        }
                    };
                    mp3Play.execute();
                    break;
                    case 1:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play1 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlbadri[1]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play1.execute();
                        break;
                    case 2:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play2 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlbadri[2]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play2.execute();
                        break;
                    case 3:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play3 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlbadri[3]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play3.execute();
                        break;
                    case 4:
                        alertDialog = new SpotsDialog(this, R.style.Custom);
                        AsyncTask<String,String,String> mp3Play4 = new AsyncTask<String, String, String>() {

                            @Override
                            protected void onPreExecute() {
                                pre();
                            }
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    mediaPlayer.setDataSource(MusicSelectActivity.this, Uri.parse(urlbadri[4]));
                                    mediaPlayer.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                return "";
                            }
                            @Override
                            protected void onPostExecute(String s) {
                                post();
                            }
                        };
                        mp3Play4.execute();
                        break;
                }
                break;


            case "Dangal":



        }

        }

        public void pre(){
            alertDialog.setMessage("Please Wait...");
            alertDialog.show();

        }

        public void post(){
            //mediaFileLength = mediaPlayer.getDuration();
            //realtimeLength = mediaFileLength;
            if(!mediaPlayer.isPlaying()){
                mediaPlayer.start();
            }else{
                mediaPlayer.pause();
            }
            alertDialog.dismiss();
        }

    }


