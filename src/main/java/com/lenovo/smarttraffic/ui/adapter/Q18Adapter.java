package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q18Bean;

import java.util.List;

import butterknife.BindView;

public class Q18Adapter extends RecyclerView.Adapter<Q18Adapter.VH> {

    public List<Q18Bean> datas;

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q18_rv, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (position != 0) {
            holder.id.setText("" + (position));
            holder.type.setText(datas.get(position - 1).getType());
            holder.yuzhi.setText("" + datas.get(position - 1).getYuzhi());
            holder.now.setText("" + datas.get(position - 1).getNow());
        }else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    class VH extends RecyclerView.ViewHolder {

        TextView id;
        TextView type;
        TextView yuzhi;
        TextView now;

        public VH(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            type = itemView.findViewById(R.id.type);
            yuzhi = itemView.findViewById(R.id.yuzhi);
            now = itemView.findViewById(R.id.now);

        }
    }
}
