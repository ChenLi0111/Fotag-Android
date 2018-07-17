package com.example.c374li.fotagmobile;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ToolBar extends LinearLayout implements Observer {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ImageView> imageview_list = new ArrayList<ImageView>();
    private ImageviewAdapter imageviewadapter;
    private GridView gv;
    private Context context;


    private ImageButton clear_button;
    private ImageButton load_button;
    private RatingBar rating_bar;

    int[] images = {
            R.drawable.l1,
            R.drawable.l2,
            R.drawable.l3,
            R.drawable.l4,
            R.drawable.l4,
            R.drawable.l5,
            R.drawable.l6,
            R.drawable.l7,
            R.drawable.l8,
            R.drawable.l9,
            R.drawable.l10
    };

    public void call_load() {

        imageviewadapter.change(images);
        imageviewadapter.notifyDataSetChanged();
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ToolBar: " + gridViewArrayAdapter.getCount());
    }

    ToolBar(Context context, final ImageCollectionModel imagecollectionmodel, ArrayList<com.example.c374li.fotagmobile.ImageView> imageview_list, GridView gridview, ImageviewAdapter ima) {
        super(context);
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ToolBar: Constructor");
        View.inflate(context, R.layout.toolbar_layout, this);

        this.imagecollectionmodel = imagecollectionmodel;
        this.imageview_list = imageview_list;
        this.gv = gridview;
        this.context = context;
        this.imageviewadapter = ima;

        clear_button = (ImageButton) findViewById(R.id.clear_button);
        load_button = (ImageButton) findViewById(R.id.load_button);
        rating_bar = (RatingBar) findViewById(R.id.rating_bar);

        clear_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                imagecollectionmodel.set_userrate(0);
                rating_bar.setRating(0);
            }
        });

        load_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                call_load();
            }
        });

        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                imagecollectionmodel.set_userrate((int) ratingBar.getRating());
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ToolBar update");
    }
}
