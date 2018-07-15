package com.example.c374li.fotagmobile;

import android.content.Context;
import android.view.View;
import android.widget.TableLayout;

import java.util.Observable;
import java.util.Observer;

public class ImageCollectionView extends TableLayout implements Observer {
    private ImageCollectionModel imagecollectionmodel;

    ImageCollectionView(Context context, ImageCollectionModel imagecollectionmodel) {
        super(context);
        View.inflate(context, R.layout.vertical_layout, this);

        this.imagecollectionmodel = imagecollectionmodel;
    }


    @Override
    public void update(Observable observable, Object o) {
        System.out.print("ImageCollectionView update");
    }
}
