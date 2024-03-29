package com.example.c374li.fotagmobile;

import android.graphics.drawable.Drawable;
import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;
    private int rate = 0;
    private Drawable image;

    ImageModel(ImageCollectionModel imagecollectionmodel, Drawable image) {
        this.imagecollectionmodel = imagecollectionmodel;
        this.image = image;
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "ImageModel: Constructor");
    }

    public Drawable get_image() {
        return image;
    }

    public void set_rate(int r) {
        rate = r;
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "user rate changed to " + rate);
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
