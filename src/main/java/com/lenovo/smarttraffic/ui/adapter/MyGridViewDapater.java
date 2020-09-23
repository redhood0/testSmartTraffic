package com.lenovo.smarttraffic.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.lenovo.smarttraffic.R;

import java.util.List;
import java.util.zip.Inflater;

public class MyGridViewDapater extends BaseAdapter {
    List<Integer> imgs;
    Context context;

    public MyGridViewDapater(List<Integer> imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public Object getItem(int position) {
        return imgs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  i = LayoutInflater.from(context);
        View v = i.inflate(R.layout.item_q4_gv,parent,false);

        ImageView iv = v.findViewById(R.id.ivAvatar);

        iv.setImageResource(imgs.get(position));
        return v;
    }


}
