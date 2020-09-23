package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import java.util.List;

import butterknife.BindView;

public class Q53RvAdapter extends RecyclerView.Adapter {
    List<String> data;
    public static final int HEAR_TYPE = 200;

    public Q53RvAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        if(viewType == HEAR_TYPE){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q53_head, parent, false);
            vh = new VHead(v);
        }else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q35_rv, parent, false);
            vh = new VH(v);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return HEAR_TYPE;
        }
        return super.getItemViewType(position);
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvCo;
        TextView tvWeather;
        TextView tvSun;
        TextView tvTime;
        public VH(View itemView) {
            super(itemView);
            tvWeather = itemView.findViewById(R.id.tv_weather);
            tvCo = itemView.findViewById(R.id.tv_co);
            tvSun = itemView.findViewById(R.id.tv_sun);
            tvTime = itemView.findViewById(R.id.tv_time);

        }
    }

    static class VHead extends RecyclerView.ViewHolder {
        TextView tv_content;
        public VHead(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);

        }
    }

}
