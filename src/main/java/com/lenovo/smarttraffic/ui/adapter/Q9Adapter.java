package com.lenovo.smarttraffic.ui.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q9Bean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q9Adapter extends RecyclerView.Adapter<Q9Adapter.VH> {

    public List<Q9Bean> q9Beans;

    public Activity activity;



    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q9, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvId.setText(""+q9Beans.get(position).getNum());
        Glide.with(activity).load(q9Beans.get(position).getChepaiImg()).into(holder.chepai);
        holder.tvChepai.setText(q9Beans.get(position).getChepai());
        holder.tvYue.setText("余额：" + q9Beans.get(position).getYue() + "元");
    }

    @Override
    public int getItemCount() {
        return q9Beans.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.chepai)
        ImageView chepai;
        @BindView(R.id.tv_chepai)
        TextView tvChepai;
        @BindView(R.id.tv_yue)
        TextView tvYue;
        @BindView(R.id.cb)
        CheckBox cb;
        @BindView(R.id.chongzhi)
        Button chongzhi;
        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
