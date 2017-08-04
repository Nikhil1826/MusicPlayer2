package com.fasttech.musicplayer;

import android.content.Intent;
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



public class CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    JazzyListView categorylist;
    ArrayList<Category> categoryArrayList;
    CategoryAdapter categoryAdapter;
    TextView textView;

    void initList(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        categorylist = (JazzyListView) findViewById(R.id.categorylist);
        categorylist.setChoiceMode(JazzyListView.CHOICE_MODE_MULTIPLE);

        Category c1 = new Category(R.drawable.h,"HINDI");
        Category c2 = new Category(R.drawable.e,"ENGLISH");
        Category c3 = new Category(R.drawable.punj,"PUNJABI");
        Category c4 = new Category(R.drawable.spanish,"SPANISH");
        Category c5 = new Category(R.drawable.arabic,"MARATHI");

        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(c1);
        categoryArrayList.add(c2);
        categoryArrayList.add(c3);
        categoryArrayList.add(c4);
        categoryArrayList.add(c5);

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
        Typeface typeface = Typeface.createFromAsset(getAssets(),"husky.ttf");
        textView = (TextView)findViewById(R.id.heading);
        textView.setTypeface(typeface);
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
            case 4:
                intent.putExtra("KeyN","ARABIC");
                break;
        }
        startActivity(intent);
    }
    }
