package com.lenovo.smarttraffic.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q64Bean;

import java.util.List;

import butterknife.BindView;

public class Q64_2Adapter extends RecyclerView.Adapter<Q64_2Adapter.Vh> {
    List<Q64Bean> beanList;
    Context context;


    public Q64_2Adapter(List<Q64Bean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_yue, parent, false);

        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        holder.chehao.setText(String.valueOf(beanList.get(position).id));
        holder.tvChepai.setText(beanList.get(position).chepai);
        holder.tvChezhu.setText(beanList.get(position).master);
        holder.tvYue.setText(beanList.get(position).yue + "元");

    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class Vh extends RecyclerView.ViewHolder {
        TextView chehao;
        TextView tvChepai;
        TextView tvChezhu;
        TextView tvYue;
        public Vh(View itemView) {
            super(itemView);
            chehao = itemView.findViewById(R.id.chehao);
            tvChepai = itemView.findViewById(R.id.tv_chepai);
            tvChezhu = itemView.findViewById(R.id.tv_chezhu);
            tvYue = itemView.findViewById(R.id.tv_yue);
        }
    }
}
