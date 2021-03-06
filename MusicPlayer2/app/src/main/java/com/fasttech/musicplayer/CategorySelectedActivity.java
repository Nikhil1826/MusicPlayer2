package com.fasttech.musicplayer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.media.MediaMetadataRetriever;
import android.media.audiofx.BassBoost;
import android.media.audiofx.EnvironmentalReverb;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


import cn.pedant.SweetAlert.SweetAlertDialog;
import pl.droidsonroids.gif.GifImageView;

import static android.view.View.X;
import static java.security.AccessController.getContext;

public class CategorySelectedActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ArrayList<CategorySelected> albumsArrayList;
    TextView hits;
    GifImageView gifImageView;

    void hindi(){
        CategorySelected h1 = new CategorySelected("Ae Dil Hai Mushkil",R.drawable.aedil);
        CategorySelected h2 = new CategorySelected("Badrinath Ki Dulhania",R.drawable.badri);
        CategorySelected h3 = new CategorySelected("Dangal",R.drawable.dangal);
        CategorySelected h4 = new CategorySelected("Sultan",R.drawable.sultan);
        CategorySelected h5 = new CategorySelected("Mubarakan",R.drawable.mubar);
        CategorySelected h6 = new CategorySelected("Munna Michael",R.drawable.munna);
        CategorySelected h7 = new CategorySelected("Jagga Jassoos",R.drawable.jagga);
        CategorySelected h8 = new CategorySelected("Half Girlfriend",R.drawable.half);
        /*CategorySelected h9 = new CategorySelected("Hindi Medium",R.drawable.hindi);
        CategorySelected h10 = new CategorySelected("Raabta",R.drawable.raabta);
        CategorySelected h11 = new CategorySelected("Tubelight",R.drawable.tube);
        CategorySelected h12 = new CategorySelected("Fan",R.drawable.fan);*/
        albumsArrayList = new ArrayList<>();
        albumsArrayList.add(h1);
        albumsArrayList.add(h2);
        albumsArrayList.add(h3);
        albumsArrayList.add(h4);
        albumsArrayList.add(h5);
        albumsArrayList.add(h6);
        albumsArrayList.add(h7);
        albumsArrayList.add(h8);
        /*albumsArrayList.add(h9);
        albumsArrayList.add(h10);
        albumsArrayList.add(h11);
        albumsArrayList.add(h12);*/
    }

    void english(){
        CategorySelected e1 = new CategorySelected("25",R.drawable.adel);
        CategorySelected e2 = new CategorySelected("Attention",R.drawable.attention);
        //CategorySelected e3 = new CategorySelected("That's What I Like",R.drawable.bruno);
        //CategorySelected e4 = new CategorySelected("Listen",R.drawable.david);
        //CategorySelected e5 = new CategorySelected("I'm The One",R.drawable.imtheone);
        CategorySelected e6 = new CategorySelected("Prism",R.drawable.prism);
        CategorySelected e7 = new CategorySelected("Rockabye",R.drawable.rocka);
        CategorySelected e8 = new CategorySelected("Shape Of You",R.drawable.shape);
        CategorySelected e9 = new CategorySelected("Sorry",R.drawable.sorry);
        CategorySelected e10 = new CategorySelected("Swalla",R.drawable.swalla);
        CategorySelected e11 = new CategorySelected("Talking To Myself",R.drawable.talking);
        //CategorySelected e12 = new CategorySelected("Wild Thoughts",R.drawable.wild);
        albumsArrayList = new ArrayList<>();
        albumsArrayList.add(e1);
        albumsArrayList.add(e2);
        //albumsArrayList.add(e3);
        //albumsArrayList.add(e4);
        //albumsArrayList.add(e5);
        albumsArrayList.add(e6);
        albumsArrayList.add(e7);
        albumsArrayList.add(e8);
        albumsArrayList.add(e9);
        albumsArrayList.add(e10);
        albumsArrayList.add(e11);
        //albumsArrayList.add(e12);

    }

    void spanish(){
        CategorySelected s1 = new CategorySelected("Ay Vamos",R.drawable.ayvamos);
        CategorySelected s2 = new CategorySelected("Bailando",R.drawable.bailando);
        CategorySelected s3 = new CategorySelected("Chantaje",R.drawable.chantaje);
        CategorySelected s4 = new CategorySelected("Despacito",R.drawable.des);
       // CategorySelected s5 = new CategorySelected("Escápate Conmigo",R.drawable.escapate);
        CategorySelected s6 = new CategorySelected("Felices los 4",R.drawable.felices);
       // CategorySelected s7 = new CategorySelected("Mi Gente",R.drawable.migente);
        //CategorySelected s8 = new CategorySelected("Subeme La Radio ",R.drawable.subeme);
        CategorySelected s9 = new CategorySelected("Vente Pa' Ca",R.drawable.vente);
        //CategorySelected s10 = new CategorySelected("Why Not Me?",R.drawable.why);
        albumsArrayList = new ArrayList<>();
        albumsArrayList.add(s1);
        albumsArrayList.add(s2);
        albumsArrayList.add(s3);
        albumsArrayList.add(s4);
        //albumsArrayList.add(s5);
        albumsArrayList.add(s6);
        //albumsArrayList.add(s7);
        //albumsArrayList.add(s8);
        albumsArrayList.add(s9);
        //albumsArrayList.add(s10);
    }

    void punjabi(){
        CategorySelected p1 = new CategorySelected("Backbone",R.drawable.back);
        CategorySelected p2 = new CategorySelected("Car Nachdi",R.drawable.car);
        CategorySelected p3 = new CategorySelected("Hello Hello",R.drawable.he);
        //CategorySelected p4 = new CategorySelected("High Rated Gabru",R.drawable.high);
        CategorySelected p5 = new CategorySelected("Blow Horn",R.drawable.horn);
        CategorySelected p6 = new CategorySelected("Mercy",R.drawable.mercy);
        CategorySelected p7 = new CategorySelected("NaJa",R.drawable.na);
        CategorySelected p8 = new CategorySelected("3 Peg",R.drawable.peg);
        CategorySelected p9 = new CategorySelected("Suit",R.drawable.suit);
       // CategorySelected p10 = new CategorySelected("Super Singh",R.drawable.super1);
        //CategorySelected p11 = new CategorySelected("5 Taara",R.drawable.taara);
       // CategorySelected p12 = new CategorySelected("Wakhra Swag",R.drawable.wakhra);
        albumsArrayList = new ArrayList<>();
        albumsArrayList.add(p1);
        albumsArrayList.add(p2);
        albumsArrayList.add(p3);
        //albumsArrayList.add(p4);
        albumsArrayList.add(p5);
        albumsArrayList.add(p6);
        albumsArrayList.add(p7);
        albumsArrayList.add(p8);
        albumsArrayList.add(p9);
       // albumsArrayList.add(p10);
       // albumsArrayList.add(p11);
       // albumsArrayList.add(p12);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        if(!isConnected(CategorySelectedActivity.this))
            //buildDialog(CategorySelectedActivity.this).show();
       //new SweetAlertDialog(CategorySelectedActivity.this,SweetAlertDialog.WARNING_TYPE).setTitleText("No Internet connection avaiable").show();
         sweetAlertDialog(CategorySelectedActivity.this);

        else {
            setContentView(R.layout.activity_category_selected);
            gifImageView = (GifImageView)findViewById(R.id.gifimage);
            hits = (TextView) findViewById(R.id.hits);
            Intent rcv = getIntent();
            String name = rcv.getStringExtra("KeyN");

            switch (name) {
                case "HINDI":
                    hindi();
                    break;
                case "ENGLISH":
                    english();
                    break;
                case "PUNJABI":
                    punjabi();
                    break;
                case "SPANISH":
                    spanish();
                    break;


            }


            recyclerView = (RecyclerView) findViewById(R.id.recycle);
            recyclerView.setHasFixedSize(true);
            layoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(layoutManager);
            adapter = new CategorySelectedAdapter(albumsArrayList, this);
            recyclerView.setAdapter(adapter);
            hits.setText(name + " ALBUMS");
            Typeface typeface = Typeface.createFromAsset(getAssets(), "musieer.ttf");
            hits.setTypeface(typeface);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
        }

}


    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
       Intent intent = new Intent(CategorySelectedActivity.this,CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.category_selected, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.language) {
            Intent intent = new Intent(CategorySelectedActivity.this,CategoryActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) {
                return true;
            }
        else
            return false;
        } else
        return false;
    }

   /* public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this.");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }*/
   public SweetAlertDialog sweetAlertDialog(Context c){
       SweetAlertDialog s = new SweetAlertDialog(c,SweetAlertDialog.WARNING_TYPE);
       s.setTitleText("No Internet Connection").show();
       s.setContentText("You need to enable Moblie Data or Wi-Fi to progress further.");
       s.setConfirmText("WI-Fi").show();
       s.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
           @Override
           public void onClick(SweetAlertDialog sweetAlertDialog) {
               Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
               startActivity(intent);
               finish();
           }
       });
       s.setCancelText("Mobile Data").show();
       s.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
           @Override
           public void onClick(SweetAlertDialog sweetAlertDialog) {
               Intent intent = new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
               startActivity(intent);
               finish();
           }
       });
       return s;

   }






}
