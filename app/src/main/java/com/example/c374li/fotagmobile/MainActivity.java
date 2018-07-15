package com.example.c374li.fotagmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {
    private ImageCollectionModel imagecollectionmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagecollectionmodel = new ImageCollectionModel();

        ToolBar toolbar = new ToolBar(this, imagecollectionmodel);
        ViewGroup v1 = (ViewGroup) findViewById(R.id.mainactivity_1);
        v1.addView(toolbar);
        imagecollectionmodel.addObserver(toolbar);

        ImageCollectionView imagecollectionview = new ImageCollectionView(this, imagecollectionmodel);
        ViewGroup v2 = (ViewGroup) findViewById(R.id.mainactivity_2);
        v2.addView(imagecollectionview);
        imagecollectionmodel.addObserver(imagecollectionview);

        imagecollectionmodel.call_notify();
    }
}
