package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetCarParkConsumptionRecord;

import java.util.List;

import butterknife.BindView;

public class Q41Adapter extends RecyclerView.Adapter<Q41Adapter.VH> {
    public List<GetCarParkConsumptionRecord.ROWSDETAILBean> data;
  String[] names = {"姜竟曼","孙怡毓","孙仁露","周小蓉"};

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q41_rv, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.ic.setText(String.valueOf(data.get(position).getId()));
        holder.num.setText(""+data.get(position).getCarId());
        holder.name.setText(""+names[position%4]);
        holder.intime.setText(""+data.get(position).getInTime());
        holder.outtime.setText(""+data.get(position).getOutTime());
        holder.money.setText(data.get(position).getMoney() + "元");

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VH extends RecyclerView.ViewHolder {
        TextView ic;
        TextView num;
        TextView name;
        TextView intime;
        TextView outtime;
        TextView money;
        public VH(View itemView) {
            super(itemView);
            ic = itemView.findViewById(R.id.ic);
            num = itemView.findViewById(R.id.num);
            name = itemView.findViewById(R.id.name);
            intime = itemView.findViewById(R.id.intime);
            outtime = itemView.findViewById(R.id.outtime);
            money = itemView.findViewById(R.id.money);
        }
    }


}
