package com.example.c374li.fotagmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ItemView> imageview_list = new ArrayList<ItemView>();
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagecollectionmodel = new ImageCollectionModel();

        gridview = (GridView) findViewById(R.id.mainactivity_2);
        ItemViewAdapter imageviewadapter = new ItemViewAdapter(this, imageview_list);
        gridview.setAdapter(imageviewadapter);

        ToolBar toolbar = new ToolBar(this, imagecollectionmodel, imageview_list, imageviewadapter);
        ViewGroup v1 = (ViewGroup) findViewById(R.id.mainactivity_1);
        v1.addView(toolbar);
        imagecollectionmodel.addObserver(toolbar);

        imagecollectionmodel.call_notify();
    }
}
