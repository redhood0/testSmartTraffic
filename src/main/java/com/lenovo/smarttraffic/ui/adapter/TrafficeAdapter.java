package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TraffciLightBean;
import com.lenovo.smarttraffic.bean.TrafficBean922;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrafficeAdapter extends RecyclerView.Adapter<TrafficeAdapter.VH> {

    private List<TrafficBean922> trafficBean922s;

    public TrafficeAdapter(List<TrafficBean922> trafficBean922s) {
        this.trafficBean922s = trafficBean922s;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trafice_item_922,parent,false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        TrafficBean922 traffciLightBean = trafficBean922s.get(position);
        holder.tv1.setText(traffciLightBean.getLukou());
        holder.tv2.setText(traffciLightBean.getRedtime());
        holder.tv3.setText(traffciLightBean.getYellowtime());
        holder.tv4.setText(traffciLightBean.getGreentime());
    }

    @Override
    public int getItemCount() {
        return trafficBean922s.size();
    }

    public  class VH extends RecyclerView.ViewHolder {

        TextView tv1;
        TextView tv2 ;
        TextView tv3;
        TextView tv4;


        public VH(View itemView) {
            super(itemView);
//            ButterKnife.bind(this,itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);


        }
    }
}
