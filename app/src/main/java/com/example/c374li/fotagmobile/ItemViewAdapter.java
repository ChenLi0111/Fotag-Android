package com.example.c374li.fotagmobile;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;


public class ItemViewAdapter extends BaseAdapter {
    private ArrayList<ItemView> array;

    ItemViewAdapter(ArrayList<ItemView> ic) {
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
        return array.get(position);
    }

    void change_data(ArrayList<ItemView> array) {
        this.array = array;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
