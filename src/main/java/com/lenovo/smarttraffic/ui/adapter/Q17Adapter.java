package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q17Bean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q17Adapter extends RecyclerView.Adapter<Q17Adapter.VH> {
    public List<Q17Bean> data;


    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.q17_item, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        switch (position){
            case 0:
                holder.desc.setText("辐射较弱，涂擦SPF12~15、PA+护肤品");
                break;
            case 1:
                holder.desc.setText("建议穿长袖衬衫、单裤等服装");

                break;
            case 2:
                holder.desc.setText("气候适宜，推荐您进行户外运动");

                break;
            case 3:
                holder.desc.setText("空气质量非常好，非常适合户外活动，趁机出去多呼吸新鲜空气");

                break;
            case 4:
                holder.desc.setText("温度低，风较大，较易发生感冒，注意防护");

                break;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.titel)
        TextView titel;
        @BindView(R.id.content)
        TextView content;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.cl)
        ConstraintLayout cl;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
