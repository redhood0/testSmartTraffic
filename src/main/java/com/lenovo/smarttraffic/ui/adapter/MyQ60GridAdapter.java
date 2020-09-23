package com.lenovo.smarttraffic.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.lenovo.smarttraffic.R;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

public class MyQ60GridAdapter extends BaseAdapter {
    List<String> dataIn;
    List<String> dataOut;
    boolean isDown;

    public MyQ60GridAdapter(List<String> dataIn, List<String> dataOut, boolean isDown) {
        this.dataIn = dataIn;
        this.dataOut = dataOut;
        this.isDown = isDown;
    }

    @Override
    public int getCount() {
        if (dataIn.size() > 12) {
            return 12;
        }
        return dataIn.size();
    }

    @Override
    public Object getItem(int position) {
        return dataIn.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q60_add, parent, false);

        TextView textView = view.findViewById(R.id.tv_content);
        ImageView imageView = view.findViewById(R.id.iv_btn);

        textView.setText(dataIn.get(position));
        if(isDown){
            imageView.setImageResource(R.mipmap.add2);
        }

        imageView.setOnClickListener(v -> {
            String content =   dataIn.remove(position);
            dataOut.add(content);
            notifyDataSetChanged();

            HashMap<String,Object> evnet  = new HashMap<>();
            evnet.put("way",isDown);
            evnet.put("content",content);

            EventBus.getDefault().post(evnet);
            evnet.clear();
        });


        return view;
    }


}
