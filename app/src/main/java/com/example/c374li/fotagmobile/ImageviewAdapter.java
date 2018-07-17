package com.example.c374li.fotagmobile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;


public class ImageviewAdapter extends BaseAdapter {
    private Context context;
    private int [] images;
    private View view;
    private LayoutInflater layoutinflater;
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<com.example.c374li.fotagmobile.ImageView> array;

    ImageviewAdapter(Context context, int[] images, ImageCollectionModel i, ArrayList<com.example.c374li.fotagmobile.ImageView> ic) {
        this.context = context;
        this.images = images;
        this.imagecollectionmodel = i;
        this.array = ic;
    }

    public void change(int[] images) {
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        layoutinflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Drawable drawable = context.getDrawable(images[position]);
        ImageModel i_m = new ImageModel(imagecollectionmodel, drawable);
        ImageView i_v = new ImageView(context, i_m);
        i_m.addObserver(i_v);
        array.add(i_v);
        imagecollectionmodel.addto_imagemodel_list(i_m);

        return i_v;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
