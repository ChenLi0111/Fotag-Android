package com.example.c374li.fotagmobile;

import android.content.Context;
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
        rating_bar.setNumStars(5);
        clear_button = (ImageButton) findViewById(R.id.singleclear);

        image_button.setImageDrawable(imagemodel.get_image());

        clear_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imagemodel.set_rate(0);
                Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "image rate clear");
                rating_bar.setRating(0);
            }
        });

        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                imagemodel.set_rate((int) ratingBar.getRating());
                Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "image rate to " + ratingBar.getRating());
            }
        });
    }

    public int get_rating() {
        return (int)rating_bar.getRating();
    }

    public Drawable get_image() {
        return imagemodel.get_image();
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageView update");
    }
}
