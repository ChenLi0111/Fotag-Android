package com.example.c374li.fotagmobile;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class ItemView extends LinearLayout implements Observer, Serializable {
    private ImageModel imagemodel;
    private ImageView imageview;
    private Dialog dialog;

    private ImageButton image_button;
    private RatingBar rating_bar;
    private ImageButton clear_button;

    private ItemViewAdapter itemviewadapter;

    ItemView(final Context context, final ImageModel imagemodel, final ItemViewAdapter itemviewadapter) {
        super(context);
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ItemView: Constructor");
        View.inflate(context, R.layout.singleimage_layout, this);

        this.imagemodel = imagemodel;
        this.itemviewadapter = itemviewadapter;


        image_button = (ImageButton) findViewById(R.id.singelimage);
        rating_bar = (RatingBar) findViewById(R.id.singlerate);
        rating_bar.setNumStars(5);
        clear_button = (ImageButton) findViewById(R.id.singleclear);

        image_button.setImageDrawable(imagemodel.get_image());

        imageview = new ImageView(context);
        imageview.setImageDrawable(imagemodel.get_image());

        dialog = new Dialog(context);
        dialog.setContentView(imageview);

        image_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "?? "+ (dialog == null) + " " + (imageview == null));
                itemviewadapter.notifyDataSetChanged();
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
                //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "image rate clear");
                rating_bar.setRating(0);
            }
        });

        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                imagemodel.set_rate((int) ratingBar.getRating());
                //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "image rate to " + ratingBar.getRating());
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ItemView update");
        rating_bar.setRating(imagemodel.get_rate());
        itemviewadapter.notifyDataSetChanged();
    }
}
