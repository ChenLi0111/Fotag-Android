package com.example.c374li.fotagmobile;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.Observable;
import java.util.Observer;

public class ToolBar extends LinearLayout implements Observer {
    private ImageCollectionModel imagecollectionmodel;

    private ImageButton clear_button;
    private ImageButton load_button;
    private RatingBar rating_bar;

    ToolBar(Context context, ImageCollectionModel imagecollectionmodel) {
        super(context);
        View.inflate(context, R.layout.toolbar_layout, this);

        this.imagecollectionmodel = imagecollectionmodel;

        clear_button = (ImageButton) findViewById(R.id.clear_button);
        load_button = (ImageButton) findViewById(R.id.load_button);
        rating_bar = (RatingBar) findViewById(R.id.rating_bar);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("ToolBar update");
    }
}
