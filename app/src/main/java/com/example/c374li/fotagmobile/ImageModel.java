package com.example.c374li.fotagmobile;

import android.graphics.Bitmap;
import android.util.Log;

import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;
    private int rate = 0;
    private Bitmap image;

    ImageModel(ImageCollectionModel imagecollectionmodel, Bitmap image) {
        this.imagecollectionmodel = imagecollectionmodel;
        this.image = image;
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageModel: Constructor");
    }

    public void set_imagecollectionmodel(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
        call_notify();
    }
    public ImageCollectionModel get_imagecollectionmodel() {
        return imagecollectionmodel;
    }

    public void set_rate(int r) {
        rate = r;
        call_notify();
    }

    public int get_rate() {
        return rate;
    }

    public void call_notify() {
        setChanged();
        notifyObservers();
    }
}
