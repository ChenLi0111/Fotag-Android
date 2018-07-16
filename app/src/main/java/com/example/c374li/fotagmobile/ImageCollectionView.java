package com.example.c374li.fotagmobile;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ImageCollectionView extends TableLayout implements Observer {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<com.example.c374li.fotagmobile.ImageView> imageview_list = new ArrayList<com.example.c374li.fotagmobile.ImageView>();

    ImageCollectionView(Context context, ImageCollectionModel imagecollectionmodel) {
        super(context);
        View.inflate(context, R.layout.vertical_layout, this);
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageCollectionView: Constructor");

        this.imagecollectionmodel = imagecollectionmodel;
    }

    public void addto_imageview_list(com.example.c374li.fotagmobile.ImageView i) {
        imageview_list.add(i);
        this.addView(i);
    }

    public ArrayList<com.example.c374li.fotagmobile.ImageView> get_imageview_list() {
        return imageview_list;
    }

    public void set_imagecollectionmodel(ImageCollectionModel i) {
        imagecollectionmodel = i;
    }

    public ImageCollectionModel get_imagecollectionmodel() {
        return imagecollectionmodel;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.print("ImageCollectionView update");
    }
}
