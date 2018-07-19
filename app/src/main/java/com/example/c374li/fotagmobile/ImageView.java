package com.example.c374li.fotagmobile;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;

import java.util.Observable;
import java.util.Observer;

public class ImageView extends LinearLayout implements Observer {
    private ImageModel imagemodel;
    private android.widget.ImageView imageview;
    private Dialog dialog;

    private ImageButton image_button;
    private RatingBar rating_bar;
    private ImageButton clear_button;

    private ImageviewAdapter imageviewadapter;

    ImageView(final Context context, final ImageModel imagemodel, final ImageviewAdapter imageviewadapter) {
        super(context);
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageView: Constructor");
        View.inflate(context, R.layout.singleimage_layout, this);

        this.imagemodel = imagemodel;
        this.imageviewadapter = imageviewadapter;


        image_button = (ImageButton) findViewById(R.id.singelimage);
        rating_bar = (RatingBar) findViewById(R.id.singlerate);
        rating_bar.setNumStars(5);
        clear_button = (ImageButton) findViewById(R.id.singleclear);

        image_button.setImageDrawable(imagemodel.get_image());

        imageview = new android.widget.ImageView(context);
        imageview.setImageDrawable(imagemodel.get_image());

        dialog = new Dialog(context);
        dialog.setContentView(imageview);

        image_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "?? "+ (dialog == null) + " " + (imageview == null));
                imageviewadapter.notifyDataSetChanged();
                imageview.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.getWindow();
                dialog.setCancelable(true);
                dialog.show();
            }
        });

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

    @Override
    public void update(Observable observable, Object o) {
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageView update");
        imageviewadapter.notifyDataSetChanged();
    }
}
