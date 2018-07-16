package com.example.c374li.fotagmobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.Observable;
import java.util.Observer;

public class ImageView extends LinearLayout implements Observer {
    private ImageModel imagemodel;

    private ImageButton image_button;
    private RatingBar rating_bar;
    private ImageButton clear_button;

    ImageView(Context context, final ImageModel imagemodel) {
        super(context);
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageView: Constructor");
        View.inflate(context, R.layout.singleimage_layout, this);

        this.imagemodel = imagemodel;

        image_button = (ImageButton) findViewById(R.id.singelimage);
        rating_bar = (RatingBar) findViewById(R.id.singlerate);
        clear_button = (ImageButton) findViewById(R.id.singleclear);

        clear_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imagemodel.set_rate(0);
                rating_bar.setRating(0);
            }
        });

        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                imagemodel.set_rate((int) ratingBar.getRating());
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageView update");
    }
}
