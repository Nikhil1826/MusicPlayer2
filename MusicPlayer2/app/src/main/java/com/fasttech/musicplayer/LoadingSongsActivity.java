package com.fasttech.musicplayer;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.yasic.library.particletextview.MovingStrategy.RandomMovingStrategy;
import com.yasic.library.particletextview.Object.ParticleTextViewConfig;
import com.yasic.library.particletextview.View.ParticleTextView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class LoadingSongsActivity extends AppCompatActivity  {
    AnimatedCircleLoadingView animatedCircleLoadingView;
    String albumname;
    int albumimage;
    MediaMetadataRetriever aedil1[],badri1[];
    String title[];
    TextView textView;


    void urlaedil(){
        aedil1 = new MediaMetadataRetriever[6];

        for(int i=0;i<6;i++){
            aedil1[i]= new MediaMetadataRetriever();
        }

        String aedil[] = new String[6];
        aedil[0]= "https://rs46529.000webhostapp.com/Ae%20dil%20hai%20mushkil/01%20Ae%20Dil%20Hai%20Mushkil%20-%20Title%20Song%20(Arijit%20Singh)%20190kbps.mp3";
        aedil[1]="https://rs46529.000webhostapp.com/Ae%20dil%20hai%20mushkil/Alizeh.mp3";
        aedil[2]="https://rs46529.000webhostapp.com/Ae%20dil%20hai%20mushkil/Bulleya.mp3";
        aedil[3]="https://rs46529.000webhostapp.com/Ae%20dil%20hai%20mushkil/Channa%20Mereya.mp3";
        aedil[4]="https://rs46529.000webhostapp.com/Ae%20dil%20hai%20mushkil/Cutiepie.mp3";
        aedil[5]="https://rs46529.000webhostapp.com/Ae%20dil%20hai%20mushkil/The%20Breakup%20Song.mp3";

       for(int i=0;i<6;i++){
            aedil1[i].setDataSource(aedil[i],new HashMap<String, String>());
        }



    }

    void urlbadri(){
        badri1 = new MediaMetadataRetriever[5];

        for(int i=0;i<5;i++){
            badri1[i]= new MediaMetadataRetriever();
        }

        String badri[] = new String[5];
        badri[0]= "https://rs46529.000webhostapp.com/Badri%20ki%20dulhania/03%20Aashiq%20Surrender%20Hua%20(Amaal%20Mallik)%20190Kbps.mp3";
        badri[1]="https://rs46529.000webhostapp.com/Badri%20ki%20dulhania/01%20Badri%20Ki%20Dulhania%20-%20Title%20Track%20(SongsMp3.Com).mp3";
        badri[2]="https://rs46529.000webhostapp.com/Badri%20ki%20dulhania/05%20Humsafar%20(Akhil%20Sachdeva)%20190Kbps.mp3";
        badri[3]="https://rs46529.000webhostapp.com/Badri%20ki%20dulhania/04%20Roke%20Na%20Ruke%20Naina%20(Arijit%20Singh)%20190Kbps.mp3";
        badri[4]="https://rs46529.000webhostapp.com/Badri%20ki%20dulhania/02%20Tamma%20Tamma%20Again%20-%20BNKD%20(Badshah)%20190Kbps.mp3";

        for(int i=0;i<5;i++){
            badri1[i].setDataSource(badri[i],new HashMap<String, String>());
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_songs);
        title = new String[100];
        textView = (TextView)findViewById(R.id.text1);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"jack.otf");
        textView.setTypeface(typeface);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Intent rcv = getIntent();
        albumname = rcv.getStringExtra("KeyName");
        albumimage = rcv.getIntExtra("KeyImg",0);
        animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById(R.id.circle_loading_view);
        startLoading();
        startPercentMockThread();




    }

    private void startLoading() {
        animatedCircleLoadingView.startDeterminate();
    }

    private void startPercentMockThread()  {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(65);
                            changePercent(i);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
                new Thread(runnable).start();
    }

    private void changePercent(final int percent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.setPercent(percent);


               if (percent==99){
                    switch (albumname){
                        case "Ae Dil Hai Mushkil":
                            urlaedil();
                            for(int i =0;i<6;i++) {
                                title[i] = aedil1[i].extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                            }
                            break;
                        case "Badrinath Ki Dulhania":
                            urlbadri();
                            for(int i=0;i<5;i++) {
                                title[i] = badri1[i].extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                            }
                            break;



                    }

                }
                if (percent==100){
                    Intent intent = new Intent(LoadingSongsActivity.this,MusicSelectActivity.class);
                    intent.putExtra("KeyName",albumname);
                    intent.putExtra("KeyImg",albumimage);
                    intent.putExtra("KeyTitle",title);
                    startActivity(intent);
                }
            }
        });

    }

    public void resetLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animatedCircleLoadingView.resetLoading();
            }
        });
    }



    @Override
    public void onBackPressed() {
       super.onBackPressed();

        //finish();


    }
}
