package com.example.c374li.fotagmobile;

import java.util.ArrayList;
import java.util.Observable;

public class ImageCollectionModel extends Observable {
    private ArrayList<ImageModel> imagemodel_list = new ArrayList<ImageModel>();
    private int user_rate;
    private int has = 0;

    ImageCollectionModel() {
        user_rate = 0;
        setChanged();
    }

    public void set_userrate(int rate) {
        user_rate = rate;
        //Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "set user rate to " + user_rate);
        call_notify();
    }

    public int get_userrate() {
        return user_rate;
    }

    public int get_has() {
        return has;
    }

    public void set_has(int i) {
        has = i;
    }

    public ArrayList<ImageModel> get_imagemodel_list() {
        return imagemodel_list;
    }

    public void addto_imagemodel_list(ImageModel i) {
        imagemodel_list.add(i);
        call_notify();
    }

    public void call_notify() {
        setChanged();
        notifyObservers();
    }
}
