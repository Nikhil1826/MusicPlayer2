package com.fasttech.musicplayer;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;

import java.net.URL;
import java.util.HashMap;

public class LoadingSongsActivity extends AppCompatActivity {
    AnimatedCircleLoadingView animatedCircleLoadingView;
    String albumname;
    int albumimage;
    MediaMetadataRetriever aedil1[];
    String aediltitle[];

    void urlaedil(){
        aedil1 = new MediaMetadataRetriever[6];

        for(int i=0;i<6;i++){
            aedil1[i]= new MediaMetadataRetriever();
        }

        String aedil[] = new String[6];
        aedil[0]= "http://docs.google.com/uc?export=download&id=0B8_Vk7mCoUT_bEg3TVM0MUxOWk0";
        aedil[1]="http://docs.google.com/uc?export=download&id=0B8_Vk7mCoUT_UWtFNGI3SVRzU3c";
        aedil[2]="http://docs.google.com/uc?export=download&id=0B8_Vk7mCoUT_SWF2X2xfV2N6cTg";
        aedil[3]="http://docs.google.com/uc?export=download&id=0B8_Vk7mCoUT_d3lDYkdwa2FPTE0";
        aedil[4]="http://docs.google.com/uc?export=download&id=0B8_Vk7mCoUT_aUVhYnM3NHBGM1E";
        aedil[5]="http://docs.google.com/uc?export=download&id=0B8_Vk7mCoUT_Y0tLaWU1TlFQMFU";

        for(int i=0;i<6;i++){
            aedil1[i].setDataSource(aedil[i],new HashMap<String, String>());
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_songs);
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

    private void startPercentMockThread() {
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
                            aediltitle = new String[6];
                            for(int i =0;i<6;i++){
                                aediltitle[i] = aedil1[i].extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                            }
                            break;


                    }

                }
                if (percent==100){
                    Intent intent = new Intent(LoadingSongsActivity.this,MusicSelectActivity.class);
                    intent.putExtra("KeyName",albumname);
                    intent.putExtra("KeyImg",albumimage);
                    intent.putExtra("KeyTitle",aediltitle);
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
}
