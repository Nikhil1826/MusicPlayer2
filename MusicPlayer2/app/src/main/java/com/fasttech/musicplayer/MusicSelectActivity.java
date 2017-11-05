package com.fasttech.musicplayer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.ohoussein.playpause.PlayPauseView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;


import java.io.IOException;


import co.mobiwise.library.MusicPlayerView;
import dmax.dialog.SpotsDialog;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable;

public class MusicSelectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ImageView imageView,songPlayingImage,backimage;
    JazzyListView songslist;
    ArrayAdapter<String> adapter;
    Bottom_now_playing bottom_now_playing;
    FragmentManager fragmentManager;
    SlidingUpPanelLayout slidingUpPanelLayout;
    String mtitle[];
    String martist[];
    String urlaedil[];
    String urlbadri[];
    public static MediaPlayer mediaPlayer;
    SpotsDialog alertDialog;
    String name;
    SmoothProgressBar smoothProgressBar,smoothProgressBar1;
    int image;
    TextView textView;
    MusicPlayerView mpv;
    Button play;
    Button next;
    SeekBar seekBar;

    //Handler handler = new Handler();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_select);
        Intent rcv = getIntent();
        image = rcv.getIntExtra("KeyImg",0);
        name = rcv.getStringExtra("KeyName");
        mtitle = rcv.getStringArrayExtra("KeyTitle");
        martist = rcv.getStringArrayExtra("KeyArtist");
        urlaedil = rcv.getStringArrayExtra("KeyAe");
        urlbadri = rcv.getStringArrayExtra("KeyBadri");
        mediaPlayer = new MediaPlayer();

        Bundle bundle = new Bundle();
        bundle.putInt("KeyI",image);
        bundle.putStringArray("KeyTitl",mtitle);
        bundle.putStringArray("KeyArt",martist);



        bottom_now_playing = new Bottom_now_playing();
        bottom_now_playing.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.upper,bottom_now_playing).commit();
        slidingUpPanelLayout = (SlidingUpPanelLayout)findViewById(R.id.sliding_layout);

        mpv = (MusicPlayerView) findViewById(R.id.mpv);
        backimage = (ImageView)findViewById(R.id.backimage);
        smoothProgressBar = (SmoothProgressBar)findViewById(R.id.progressBar);
        smoothProgressBar1 = (SmoothProgressBar)findViewById(R.id.progressBar1);
        songPlayingImage = (ImageView)findViewById(R.id.songPlayingImage);
        imageView = (ImageView) findViewById(R.id.imageView2);
        songslist = (JazzyListView)findViewById(R.id.musiclist);
        textView = (TextView)findViewById(R.id.fragsong);
        songslist.setTransitionEffect(JazzyHelper.TWIRL);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().setTitle(name);
        getSupportActionBar().hide();
        imageView.setBackgroundResource(image);

        smoothProgressBar.progressiveStart();
        smoothProgressBar1.progressiveStart();

        play = (Button)findViewById(R.id.playbutton);
        next = (Button)findViewById(R.id.nextbutton);





        switch (name) {
            case "Ae Dil Hai Mushkil":
                for (int i = 0; i < 6; i++) {
                    adapter.add(mtitle[i]);
                }
                break;
            case "Badrinath Ki Dulhania":
                for (int i = 0; i < 5; i++) {
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
        panel1();

        mpv.setCoverDrawable(image);





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
                                bottom_now_playing.fragmentTitle(0);
                                bottom_now_playing.fragmentArtist(0);
                                textView.setText(mtitle[0]);
                            }
                        };
                        mp3Play.execute();

                        break;
                    case 1:
                        //final int ip1=1;
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
                                bottom_now_playing.fragmentTitle(1);
                                bottom_now_playing.fragmentArtist(1);
                                textView.setText(mtitle[1]);
                            }
                        };
                        mp3Play1.execute();
                        break;
                    case 2:
                        //final int ip2=2;
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
                                bottom_now_playing.fragmentTitle(2);
                                bottom_now_playing.fragmentArtist(2);
                                textView.setText(mtitle[2]);
                            }
                        };
                        mp3Play2.execute();
                        break;
                    case 3 :
                        //final int ip3=3;
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
                                bottom_now_playing.fragmentTitle(3);
                                bottom_now_playing.fragmentArtist(3);
                                textView.setText(mtitle[3]);
                            }
                        };
                        mp3Play3.execute();
                        break;
                    case 4:
                       // final int ip4=4;
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
                                bottom_now_playing.fragmentTitle(4);
                                bottom_now_playing.fragmentArtist(4);
                                textView.setText(mtitle[4]);
                            }
                        };
                        mp3Play4.execute();
                        break;
                    case 5:
                       // final int ip5=5;
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
                                bottom_now_playing.fragmentTitle(5);
                                bottom_now_playing.fragmentArtist(5);
                                textView.setText(mtitle[5]);
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
                            bottom_now_playing.fragmentTitle(0);
                            bottom_now_playing.fragmentArtist(0);
                            textView.setText(mtitle[0]);
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
                                bottom_now_playing.fragmentTitle(1);
                                bottom_now_playing.fragmentArtist(1);
                                textView.setText(mtitle[1]);
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
                                bottom_now_playing.fragmentTitle(2);
                                bottom_now_playing.fragmentArtist(2);
                                textView.setText(mtitle[2]);
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
                                bottom_now_playing.fragmentTitle(3);
                                bottom_now_playing.fragmentArtist(3);
                                textView.setText(mtitle[3]);
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
                                bottom_now_playing.fragmentTitle(4);
                                bottom_now_playing.fragmentArtist(4);
                                textView.setText(mtitle[4]);
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
            blur1();
            alertDialog.setMessage("Please Wait...");
            alertDialog.show();


        }

        public void post(){
            if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    //setSeekBar();
                    bottom_now_playing.fragmentButton();
                    mpv.start();
                play.setBackgroundResource(R.drawable.pause1);
            }
            /*else{
                mediaPlayer.stop();
                mediaPlayer.release();

            }*/
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.pause();
                        play.setBackgroundResource(R.drawable.play2);
                        mpv.stop();
                    }else{
                        mediaPlayer.start();
                        play.setBackgroundResource(R.drawable.pause1);
                        mpv.start();

                    }

                }
            });

            songslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {





                }
            });


            blur();
            alertDialog.dismiss();
        }

        /*public void setSeekBar(){
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());

            Thread t = new Mythread();
            t.start();

        }

        public class Mythread extends Thread{
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if(mediaPlayer!=null) {
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }*/

        public void panel1(){
            slidingUpPanelLayout.setPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
                @Override
                public void onPanelSlide(View panel, float slideOffset) {

                }

                @Override
                public void onPanelCollapsed(View panel) {
                    bottom_now_playing.fadeIn();
                    bottom_now_playing.collapse();


                }

                @Override
                public void onPanelExpanded(View panel) {
                    bottom_now_playing.fadeOut();
                    bottom_now_playing.expand();


                }

                @Override
                public void onPanelAnchored(View panel) {

                }

                @Override
                public void onPanelHidden(View panel) {

                }
            });
        }

    @Override
    public void onBackPressed() {
        if (slidingUpPanelLayout != null &&
                (slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

    public void blur(){
        Picasso
                .with(this)
                .load(image)
                .transform(new BlurTransformation(this))
                .resize(342,610)
                .into(songPlayingImage);




    }

    public void blur1(){
        Picasso
                .with(this)
                .load(image)
                .transform(new BlurTransformation2(this))
                .resize(450,524)
                .into(backimage);


    }

}


