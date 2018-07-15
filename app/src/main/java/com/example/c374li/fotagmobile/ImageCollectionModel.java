package com.example.c374li.fotagmobile;

import java.util.ArrayList;
import java.util.Observable;

public class ImageCollectionModel extends Observable {
    private ArrayList<ImageModel> imagemodel_list = new ArrayList<ImageModel>();

    ImageCollectionModel() {
        setChanged();
    }

    public void set_imagemodel_list(ArrayList<ImageModel> imagemodel_list) {
        this.imagemodel_list = imagemodel_list;
    }

    public ArrayList<ImageModel> get_imagemodel_list() {
        return imagemodel_list;
    }

    public void call_notify() {
        setChanged();
        notifyObservers();
    }
}
