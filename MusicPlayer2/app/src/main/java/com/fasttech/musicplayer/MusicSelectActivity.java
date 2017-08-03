package com.fasttech.musicplayer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.RemoteControlClient;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.flaviofaria.kenburnsview.Transition;
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class MusicSelectActivity extends AppCompatActivity {
    ImageView imageView;
    JazzyListView songslist;
    ArrayAdapter<String> adapter;

    //LinearLayout linearLayout;
    MediaMetadataRetriever aedil0,aedil1,aedil2,aedil3,aedil4,aedil5;
    MediaMetadataRetriever badri0,badri1,badri2,badri3,badri4;
    MediaMetadataRetriever dangal0,dangal1,dangal2,dangal3,dangal4,dangal5;
    MediaMetadataRetriever sultab0,sultan1,sultan2,sultan3,sultan4;




    void urlaedil(){
        aedil0 = new MediaMetadataRetriever();
        aedil1 = new MediaMetadataRetriever();
        aedil2 = new MediaMetadataRetriever();
        aedil3 = new MediaMetadataRetriever();
        aedil4 = new MediaMetadataRetriever();
        aedil5 = new MediaMetadataRetriever();
        String aedil[] = new String[6];
        aedil[0]= "https://nikhilchauhan1826.000webhostapp.com/Ae%20Dil%20hai%20mushkil/01%20Ae%20Dil%20Hai%20Mushkil%20-%20Title%20Song%20(Arijit%20Singh)%20190kbps.mp3";
        aedil[1]="https://nikhilchauhan1826.000webhostapp.com/Ae%20Dil%20hai%20mushkil/Alizeh.mp3";
        aedil[2]="https://nikhilchauhan1826.000webhostapp.com/Ae%20Dil%20hai%20mushkil/Bulleya.mp3";
        aedil[3]="https://nikhilchauhan1826.000webhostapp.com/Ae%20Dil%20hai%20mushkil/Channa%20Mereya.mp3";
        aedil[4]="https://nikhilchauhan1826.000webhostapp.com/Ae%20Dil%20hai%20mushkil/Cutiepie.mp3";
        aedil[5]="https://nikhilchauhan1826.000webhostapp.com/Ae%20Dil%20hai%20mushkil/The%20Breakup%20Song.mp3";

        aedil0.setDataSource(aedil[0], new HashMap<String, String>());
        aedil1.setDataSource(aedil[1],new HashMap<String, String>());
        aedil2.setDataSource(aedil[2],new HashMap<String, String>());
        aedil3.setDataSource(aedil[3],new HashMap<String, String>());
        aedil4.setDataSource(aedil[4],new HashMap<String, String>());
        aedil5.setDataSource(aedil[5],new HashMap<String, String>());


}

void urlbadri(){
    badri0 = new MediaMetadataRetriever();
    badri1 = new MediaMetadataRetriever();
    badri2 = new MediaMetadataRetriever();
    badri3 = new MediaMetadataRetriever();
    badri4 = new MediaMetadataRetriever();
    String badri[] = new String[5];
    badri[0]="https://nikhilchauhan1826.000webhostapp.com/Badri%20Ki%20Dulhania/03%20Aashiq%20Surrender%20Hua%20(Amaal%20Mallik)%20190Kbps.mp3";
    badri[1]="https://nikhilchauhan1826.000webhostapp.com/Badri%20Ki%20Dulhania/Badri%20Ki%20Dulhania-(Mr-Jatt.com).mp3";
    badri[2]="https://nikhilchauhan1826.000webhostapp.com/Badri%20Ki%20Dulhania/05%20Humsafar%20(Akhil%20Sachdeva)%20190Kbps.mp3";
    badri[3]="https://nikhilchauhan1826.000webhostapp.com/Badri%20Ki%20Dulhania/04%20Roke%20Na%20Ruke%20Naina%20(Arijit%20Singh)%20190Kbps.mp3";
    badri[4]="https://nikhilchauhan1826.000webhostapp.com/Badri%20Ki%20Dulhania/02%20Tamma%20Tamma%20Again%20-%20BNKD%20(Badshah)%20190Kbps.mp3";

    badri0.setDataSource(badri[0],new HashMap<String, String>());
    badri1.setDataSource(badri[1],new HashMap<String, String>());
    badri2.setDataSource(badri[2],new HashMap<String, String>());
    badri3.setDataSource(badri[3],new HashMap<String, String>());
    badri4.setDataSource(badri[4],new HashMap<String, String>());

}

void urldangal(){
    dangal0 = new MediaMetadataRetriever();
    dangal1 = new MediaMetadataRetriever();
    dangal2 = new MediaMetadataRetriever();
    dangal3 = new MediaMetadataRetriever();
    dangal4 = new MediaMetadataRetriever();
    dangal5 = new MediaMetadataRetriever();
    String dangal[] = new String[6];
    dangal[0]="https://nikhilchauhan1826.000webhostapp.com/Dangal/04%20Dangal%20-%20Title%20Song%20(Daler%20Mehndi)%20190Kbps.mp3";
    dangal[1]="https://nikhilchauhan1826.000webhostapp.com/Dangal/02%20Dhaakad%20-%20Dangal%20(Raftaar)%20190Kbps.mp3";
    dangal[2]="https://nikhilchauhan1826.000webhostapp.com/Dangal/03%20Gilehriyaan%20-%20Dangal%20(Jonita%20Gandhi)%20190Kbps.mp3";
    dangal[3]="https://nikhilchauhan1826.000webhostapp.com/Dangal/01%20Haanikaarak%20Bapu%20-%20Dangal%20-%20190kbps.mp3";
    dangal[4]="https://nikhilchauhan1826.000webhostapp.com/Dangal/07%20Idiot%20Banna%20-%20Dangal%20(Nooran)%20190Kbps.mp3";
    dangal[5]="https://nikhilchauhan1826.000webhostapp.com/Dangal/Naina-(Mr-Jatt.com).mp3";

    dangal0.setDataSource(dangal[0],new HashMap<String, String>());
    dangal1.setDataSource(dangal[1],new HashMap<String, String>());
    dangal2.setDataSource(dangal[2],new HashMap<String, String>());
    dangal3.setDataSource(dangal[3],new HashMap<String, String>());
    dangal4.setDataSource(dangal[4],new HashMap<String, String>());
    dangal5.setDataSource(dangal[5],new HashMap<String, String>());

}

void urlsultan(){
    sultab0 = new MediaMetadataRetriever();
    sultan1 = new MediaMetadataRetriever();
    sultan2 = new MediaMetadataRetriever();
    sultan3 = new MediaMetadataRetriever();
    sultan4 = new MediaMetadataRetriever();
    String sultan[] = new String[5];
    sultan[0]""
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_select);
       // linearLayout = (LinearLayout)findViewById(R.id.Musiclayout);
        imageView = (ImageView) findViewById(R.id.imageView2);
        songslist = (JazzyListView)findViewById(R.id.musiclist);
        songslist.setTransitionEffect(JazzyHelper.TWIRL);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent rcv = getIntent();
        int image = rcv.getIntExtra("KeyImg",0);
        String name = rcv.getStringExtra("KeyName");
        getSupportActionBar().setTitle(name);
        imageView.setBackgroundResource(image);
        //linearLayout.setBackgroundResource(image);
        urlaedil();
        urlbadri();
        urldangal();

        switch (name){
            case "Ae Dil Hai Mushkil":
                adapter.add(aedil0.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(aedil1.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(aedil2.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(aedil3.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(aedil4.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(aedil5.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                break;
            case "Badrinath Ki Dulhania":
                adapter.add(badri0.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(badri1.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(badri2.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(badri3.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                adapter.add(badri4.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE));
                break;



        }

        songslist.setAdapter(adapter);





    }

}
