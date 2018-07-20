package com.example.c374li.fotagmobile;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ItemView> itemview_list = new ArrayList<ItemView>();
    private GridView gridview;
    private ItemViewAdapter itemviewadapter;
    private ToolBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagecollectionmodel = new ImageCollectionModel();

        gridview = (GridView) findViewById(R.id.mainactivity_2);
        itemviewadapter = new ItemViewAdapter(itemview_list);
        gridview.setAdapter(itemviewadapter);

        toolbar = new ToolBar(this, imagecollectionmodel, itemview_list, itemviewadapter);
        ViewGroup v1 = (ViewGroup) findViewById(R.id.mainactivity_1);
        v1.addView(toolbar);
        imagecollectionmodel.addObserver(toolbar);

        imagecollectionmodel.call_notify();
    }

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
        ItemView i_v_1 = new ItemView(toolbar.getContext(), i_m_1, itemviewadapter);
        i_m_1.addObserver(i_v_1);
        itemview_list.add(i_v_1);
        imagecollectionmodel.addto_imagemodel_list(i_m_1);

        ImageModel i_m_2 = new ImageModel(imagecollectionmodel, drawable_2);
        ItemView i_v_2 = new ItemView(toolbar.getContext(), i_m_2, itemviewadapter);
        i_m_2.addObserver(i_v_2);
        itemview_list.add(i_v_2);
        imagecollectionmodel.addto_imagemodel_list(i_m_2);

        ImageModel i_m_3 = new ImageModel(imagecollectionmodel, drawable_3);
        ItemView i_v_3 = new ItemView(toolbar.getContext(), i_m_3, itemviewadapter);
        i_m_3.addObserver(i_v_3);
        itemview_list.add(i_v_3);
        imagecollectionmodel.addto_imagemodel_list(i_m_3);

        ImageModel i_m_4 = new ImageModel(imagecollectionmodel, drawable_4);
        ItemView i_v_4 = new ItemView(toolbar.getContext(), i_m_4, itemviewadapter);
        i_m_4.addObserver(i_v_4);
        itemview_list.add(i_v_4);
        imagecollectionmodel.addto_imagemodel_list(i_m_4);

        ImageModel i_m_5 = new ImageModel(imagecollectionmodel, drawable_5);
        ItemView i_v_5 = new ItemView(toolbar.getContext(), i_m_5, itemviewadapter);
        i_m_5.addObserver(i_v_5);
        itemview_list.add(i_v_5);
        imagecollectionmodel.addto_imagemodel_list(i_m_5);

        ImageModel i_m_6 = new ImageModel(imagecollectionmodel, drawable_6);
        ItemView i_v_6 = new ItemView(toolbar.getContext(), i_m_6, itemviewadapter);
        i_m_6.addObserver(i_v_6);
        itemview_list.add(i_v_6);
        imagecollectionmodel.addto_imagemodel_list(i_m_6);

        ImageModel i_m_7 = new ImageModel(imagecollectionmodel, drawable_7);
        ItemView i_v_7 = new ItemView(toolbar.getContext(), i_m_7, itemviewadapter);
        i_m_7.addObserver(i_v_7);
        itemview_list.add(i_v_7);
        imagecollectionmodel.addto_imagemodel_list(i_m_7);

        ImageModel i_m_8 = new ImageModel(imagecollectionmodel, drawable_8);
        ItemView i_v_8 = new ItemView(toolbar.getContext(), i_m_8, itemviewadapter);
        i_m_8.addObserver(i_v_8);
        itemview_list.add(i_v_8);
        imagecollectionmodel.addto_imagemodel_list(i_m_8);

        ImageModel i_m_9 = new ImageModel(imagecollectionmodel, drawable_9);
        ItemView i_v_9 = new ItemView(toolbar.getContext(), i_m_9, itemviewadapter);
        i_m_9.addObserver(i_v_9);
        itemview_list.add(i_v_9);
        imagecollectionmodel.addto_imagemodel_list(i_m_9);

        ImageModel i_m_10 = new ImageModel(imagecollectionmodel, drawable_10);
        ItemView i_v_10 = new ItemView(toolbar.getContext(), i_m_10, itemviewadapter);
        i_m_10.addObserver(i_v_10);
        itemview_list.add(i_v_10);
        imagecollectionmodel.addto_imagemodel_list(i_m_10);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "MainActivity: Save model state.");

        outState.putInt("userrate", imagecollectionmodel.get_userrate());
        outState.putInt("has", imagecollectionmodel.get_has());
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "has = " + imagecollectionmodel.get_has());

        if(imagecollectionmodel.get_has() == 1) {
            for (int i = 0; i < 10; ++i) {
                outState.putInt("image_rate_" + i, imagecollectionmodel.get_imagemodel_list().get(i).get_rate());
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "MainActivity: restore.");
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "user rate = " + savedInstanceState.getInt("userrate"));
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "has = " + savedInstanceState.getInt("has"));

        if (savedInstanceState.getInt("has") == 1) {
            /*
            for (int i = 0; i < 10; ++i) {
                Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "image rate " + i + " " + savedInstanceState.getInt("image_rate_" + i));
            } */

            load_first();
            //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "size  = " + imagecollectionmodel.get_imagemodel_list().size());

            for (int i = 0; i < 10; ++i) {
                imagecollectionmodel.get_imagemodel_list().get(i).set_rate(savedInstanceState.getInt("image_rate_" + i));
            }

            toolbar.change_rate();
            imagecollectionmodel.set_has(1);
        }
    }
}
