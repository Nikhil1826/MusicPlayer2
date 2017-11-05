package com.fasttech.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashActivity extends AwesomeSplash {





    @Override
    public void initSplash(ConfigSplash configSplash) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        MediaPlayer mp = MediaPlayer.create(this,R.raw.sound1);

        //TO OBTAIN FULLSCREEN SPLASH
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //BACKGROUND ANIMATION
        //SETS BACKGROUND COLOUR
        configSplash.setBackgroundColor(R.color.splash);


        //SETS THE DURATION OF ANIMATION IN ms
        configSplash.setAnimCircularRevealDuration(800);

        //SETS FROM WHERE BACKGROUND SHOULD APPEAR
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);
        configSplash.setRevealFlagX(Flags.REVEAL_BOTTOM);


        //LOGO
        configSplash.setLogoSplash(R.drawable.boom1);
        configSplash.setAnimLogoSplashDuration(6000);
        configSplash.setAnimLogoSplashTechnique(Techniques.FlipInX);



        //TITLE
        configSplash.setTitleSplash("BoomBox " +
                "Player");
        configSplash.setTitleTextColor(R.color.t6);
        configSplash.setTitleFont("musieer.ttf");
        configSplash.setTitleTextSize(28f);
        configSplash.setAnimTitleDuration(6800);
        mp.start();
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);









    }

    @Override
    public void animationsFinished() {
        Intent intent = new Intent(SplashActivity.this,CategoryActivity.class);
        startActivity(intent);

    }

}
