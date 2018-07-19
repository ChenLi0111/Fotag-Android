package com.example.c374li.fotagmobile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ToolBar extends LinearLayout implements Observer {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ItemView> itemview_list = new ArrayList<ItemView>();
    private ItemViewAdapter itemviewadapter;
    private Context context;


    private ImageButton clear_button;
    private ImageButton load_button;
    private RatingBar rating_bar;

    private ArrayList<ItemView> now = new ArrayList<ItemView>();

    public void load_first() {
        Resources res = getResources();
        Drawable drawable_1 = res.getDrawable(R.drawable.l1);
        Drawable drawable_2 = res.getDrawable(R.drawable.l2);
        Drawable drawable_3 = res.getDrawable(R.drawable.l3);
        Drawable drawable_4 = res.getDrawable(R.drawable.l4);
        Drawable drawable_5 = res.getDrawable(R.drawable.l5);
        Drawable drawable_6 = res.getDrawable(R.drawable.l6);
        Drawable drawable_7 = res.getDrawable(R.drawable.l7);
        Drawable drawable_8 = res.getDrawable(R.drawable.l8);
        Drawable drawable_9 = res.getDrawable(R.drawable.l9);
        Drawable drawable_10 = res.getDrawable(R.drawable.l10);

        ImageModel i_m_1 = new ImageModel(imagecollectionmodel, drawable_1);
        ItemView i_v_1 = new ItemView(context, i_m_1, itemviewadapter);
        i_m_1.addObserver(i_v_1);
        itemview_list.add(i_v_1);
        imagecollectionmodel.addto_imagemodel_list(i_m_1);

        ImageModel i_m_2 = new ImageModel(imagecollectionmodel, drawable_2);
        ItemView i_v_2 = new ItemView(context, i_m_2, itemviewadapter);
        i_m_2.addObserver(i_v_2);
        itemview_list.add(i_v_2);
        imagecollectionmodel.addto_imagemodel_list(i_m_2);

        ImageModel i_m_3 = new ImageModel(imagecollectionmodel, drawable_3);
        ItemView i_v_3 = new ItemView(context, i_m_3, itemviewadapter);
        i_m_3.addObserver(i_v_3);
        itemview_list.add(i_v_3);
        imagecollectionmodel.addto_imagemodel_list(i_m_3);

        ImageModel i_m_4 = new ImageModel(imagecollectionmodel, drawable_4);
        ItemView i_v_4 = new ItemView(context, i_m_4, itemviewadapter);
        i_m_4.addObserver(i_v_4);
        itemview_list.add(i_v_4);
        imagecollectionmodel.addto_imagemodel_list(i_m_4);

        ImageModel i_m_5 = new ImageModel(imagecollectionmodel, drawable_5);
        ItemView i_v_5 = new ItemView(context, i_m_5, itemviewadapter);
        i_m_5.addObserver(i_v_5);
        itemview_list.add(i_v_5);
        imagecollectionmodel.addto_imagemodel_list(i_m_5);

        ImageModel i_m_6 = new ImageModel(imagecollectionmodel, drawable_6);
        ItemView i_v_6 = new ItemView(context, i_m_6, itemviewadapter);
        i_m_6.addObserver(i_v_6);
        itemview_list.add(i_v_6);
        imagecollectionmodel.addto_imagemodel_list(i_m_6);

        ImageModel i_m_7 = new ImageModel(imagecollectionmodel, drawable_7);
        ItemView i_v_7 = new ItemView(context, i_m_7, itemviewadapter);
        i_m_7.addObserver(i_v_7);
        itemview_list.add(i_v_7);
        imagecollectionmodel.addto_imagemodel_list(i_m_7);

        ImageModel i_m_8 = new ImageModel(imagecollectionmodel, drawable_8);
        ItemView i_v_8 = new ItemView(context, i_m_8, itemviewadapter);
        i_m_8.addObserver(i_v_8);
        itemview_list.add(i_v_8);
        imagecollectionmodel.addto_imagemodel_list(i_m_8);

        ImageModel i_m_9 = new ImageModel(imagecollectionmodel, drawable_9);
        ItemView i_v_9 = new ItemView(context, i_m_9, itemviewadapter);
        i_m_9.addObserver(i_v_9);
        itemview_list.add(i_v_9);
        imagecollectionmodel.addto_imagemodel_list(i_m_9);

        ImageModel i_m_10 = new ImageModel(imagecollectionmodel, drawable_10);
        ItemView i_v_10 = new ItemView(context, i_m_10, itemviewadapter);
        i_m_10.addObserver(i_v_10);
        itemview_list.add(i_v_10);
        imagecollectionmodel.addto_imagemodel_list(i_m_10);
    }

    public void call_load() {
        load_first();
        itemviewadapter.change_data(itemview_list);
        itemviewadapter.notifyDataSetChanged();
    }

    public void change_rate() {
        if (imagecollectionmodel.get_imagemodel_list().size() == 0) {return;}

        now.clear();
        for (int i = 0; i < 10; ++i) {
            if (imagecollectionmodel.get_imagemodel_list().get(i).get_rate() >= imagecollectionmodel.get_userrate()) {
                now.add(itemview_list.get(i));
            }
        }
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "now size = " + now.size());

        itemviewadapter.change_data(now);
        itemviewadapter.notifyDataSetChanged();
    }

    ToolBar(Context context, final ImageCollectionModel imagecollectionmodel, ArrayList<com.example.c374li.fotagmobile.ItemView> itemview_list, ItemViewAdapter ima) {
        super(context);
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ToolBar: Constructor");
        View.inflate(context, R.layout.toolbar_layout, this);

        this.imagecollectionmodel = imagecollectionmodel;
        this.itemview_list = itemview_list;
        this.context = context;
        this.itemviewadapter = ima;

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
                change_rate();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ToolBar update");
    }
}
