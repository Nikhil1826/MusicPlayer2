package com.fasttech.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.TextView;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.JazzyListView;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    JazzyListView categorylist;
    ArrayList<Category> categoryArrayList;
    CategoryAdapter categoryAdapter;
    TextView textView;
    static int count = 0;


    void initList(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        categorylist = (JazzyListView) findViewById(R.id.categorylist);
        //categorylist.setChoiceMode(JazzyListView.CHOICE_MODE_MULTIPLE);

        Category c1 = new Category(R.drawable.h,"HINDI");
        Category c2 = new Category(R.drawable.e,"ENGLISH");
        Category c3 = new Category(R.drawable.punj,"PUNJABI");
        Category c4 = new Category(R.drawable.spanish,"SPANISH");

        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(c1);
        categoryArrayList.add(c2);
        categoryArrayList.add(c3);
        categoryArrayList.add(c4);

        categoryAdapter = new CategoryAdapter(this,R.layout.item_category,categoryArrayList);
        categorylist.setAdapter(categoryAdapter);
        categorylist.setTransitionEffect(JazzyHelper.CARDS);
        categorylist.setOnItemClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initList();
        Typeface typeface = Typeface.createFromAsset(getAssets(), "husky.ttf");
        textView = (TextView) findViewById(R.id.heading);
        textView.setTypeface(typeface);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        CategorySelectedActivity c = new CategorySelectedActivity();

            if (count == 0) {
                if (c.isConnected(CategoryActivity.this) == true) {
                    sweetAlertDialog1(CategoryActivity.this);
                    count = 1;
                }else{
                    setContentView(R.layout.activity_category);
                    initList();
                    Typeface typeface = Typeface.createFromAsset(getAssets(), "husky.ttf");
                    textView = (TextView) findViewById(R.id.heading);
                    textView.setTypeface(typeface);
                }
            } else {
                setContentView(R.layout.activity_category);
                initList();
                Typeface typeface = Typeface.createFromAsset(getAssets(), "husky.ttf");
                textView = (TextView) findViewById(R.id.heading);
                textView.setTypeface(typeface);
            }
        }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(CategoryActivity.this,CategorySelectedActivity.class);
        switch (i){
            case 0:
                intent.putExtra("KeyN","HINDI");
                break;
            case 1:
                intent.putExtra("KeyN","ENGLISH");
                break;
            case 2:
                intent.putExtra("KeyN","PUNJABI");
                break;
            case 3:
                intent.putExtra("KeyN","SPANISH");
                break;
        }
        startActivity(intent);
    }

    public SweetAlertDialog sweetAlertDialog1(Context c){
        final SweetAlertDialog  s = new SweetAlertDialog(c,SweetAlertDialog.SUCCESS_TYPE);
        s.setTitleText("Internet Enabled").show();
        s.setConfirmText("OK").show();
        s.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
               s.dismiss();

            }
        });
        return s;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
