package com.example.c374li.fotagmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<com.example.c374li.fotagmobile.ImageView> imageview_list = new ArrayList<com.example.c374li.fotagmobile.ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagecollectionmodel = new ImageCollectionModel();

        final List<ImageView> plantsList = new ArrayList<ImageView>(imageview_list);
        final ArrayAdapter<ImageView> gridViewArrayAdapter = new ArrayAdapter<ImageView>(this, android.R.layout.simple_list_item_1, plantsList);

        ToolBar toolbar = new ToolBar(this, imagecollectionmodel, gridViewArrayAdapter, plantsList, imageview_list);

        ViewGroup v1 = (ViewGroup) findViewById(R.id.mainactivity_1);
        v1.addView(toolbar);
        imagecollectionmodel.addObserver(toolbar);

        GridView gv = (GridView) findViewById(R.id.mainactivity_2);
        gv.setAdapter(gridViewArrayAdapter);

        imagecollectionmodel.call_notify();
    }
}
