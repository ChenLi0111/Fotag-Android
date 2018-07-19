package com.example.c374li.fotagmobile;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ItemView> itemview_list = new ArrayList<ItemView>();
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagecollectionmodel = new ImageCollectionModel();

        gridview = (GridView) findViewById(R.id.mainactivity_2);
        ItemViewAdapter itemviewadapter = new ItemViewAdapter(this, itemview_list);
        gridview.setAdapter(itemviewadapter);

        ToolBar toolbar = new ToolBar(this, imagecollectionmodel, itemview_list, itemviewadapter);
        ViewGroup v1 = (ViewGroup) findViewById(R.id.mainactivity_1);
        v1.addView(toolbar);
        imagecollectionmodel.addObserver(toolbar);

        imagecollectionmodel.call_notify();
    }
/*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "Land");
            gridview.setNumColumns(2);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "port");
            gridview.setNumColumns(1);
        }
    } */
}
