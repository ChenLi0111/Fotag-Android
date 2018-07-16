package com.example.c374li.fotagmobile;

import android.graphics.Bitmap;

import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;
    private int rate = 0;
    private Bitmap image;

    ImageModel(ImageCollectionModel imagecollectionmodel, Bitmap image) {
        this.imagecollectionmodel = imagecollectionmodel;
        this.image = image;
    }

    public void set_imagecollectionmodel(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
    }
    public ImageCollectionModel get_imagecollectionmodel() {
        return imagecollectionmodel;
    }

    public void call_notify() {
        setChanged();
        notifyObservers();
    }
}
