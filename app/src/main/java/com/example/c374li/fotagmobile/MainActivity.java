package com.example.c374li.fotagmobile;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageCollectionModel imagecollectionmodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagecollectionmodel = new ImageCollectionModel();

        ImageCollectionView imagecollectionview = new ImageCollectionView(this, imagecollectionmodel);
        final List<ImageView> plantsList = new ArrayList<ImageView>(imagecollectionview.get_imageview_list());
        int size = imagecollectionview.get_imageview_list().size();
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "s" + size);
        final ArrayAdapter<ImageView> gridViewArrayAdapter = new ArrayAdapter<ImageView>(this, android.R.layout.simple_list_item_1, plantsList);

        ToolBar toolbar = new ToolBar(this, imagecollectionmodel, imagecollectionview, gridViewArrayAdapter, plantsList);

        ViewGroup v1 = (ViewGroup) findViewById(R.id.mainactivity_1);
        v1.addView(toolbar);
        imagecollectionmodel.addObserver(toolbar);

        GridView gv = (GridView) findViewById(R.id.mainactivity_2);
        gv.setAdapter(gridViewArrayAdapter);

        imagecollectionmodel.addObserver(imagecollectionview);
        imagecollectionmodel.call_notify();
    }


}
