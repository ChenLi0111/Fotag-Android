package com.example.c374li.fotagmobile;

import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;

    ImageModel(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
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
