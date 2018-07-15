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

        imagecollectionmodel.call_notify();
    }
}
