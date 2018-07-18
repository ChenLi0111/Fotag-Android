package com.example.c374li.fotagmobile;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.RatingBar;

import java.util.ArrayList;


public class ImageviewAdapter extends BaseAdapter {
    private Context context;
    private View view;
    private LayoutInflater layoutinflater;
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<com.example.c374li.fotagmobile.ImageView> array;

    ImageviewAdapter(Context context, ImageCollectionModel i, ArrayList<com.example.c374li.fotagmobile.ImageView> ic) {
        this.context = context;
        this.imagecollectionmodel = i;
        this.array = ic;
    }

    @Override
    public int getCount() {
        return array.size();
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
        ImageView imageview = array.get(position);
        ViewHolder viewholder;
        if (view == null) {
            Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "first");
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.singleimage_layout, viewGroup, false);
            viewholder = new ViewHolder();
            viewholder.image_button = view.findViewById(R.id.singelimage);
            viewholder.ratingbar = view.findViewById(R.id.singlerate);
            viewholder.clear_button = view.findViewById(R.id.singleclear);
            view.setTag(viewholder);
        } else {

            viewholder = (ViewHolder) view.getTag();
        }
        viewholder.image_button.setImageDrawable(imageview.get_image());
        Log.d(String.valueOf(R.string.DEBUG_FOTAG_ID), "second " + imageview.get_rating());
        viewholder.ratingbar.setNumStars(imageview.get_rating());

        return view;
    }

    static class ViewHolder{
        ImageButton image_button;
        RatingBar ratingbar;
        ImageButton clear_button;
    }

    void change_data(ArrayList<com.example.c374li.fotagmobile.ImageView> array) {
        this.array = array;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
