package com.lenovo.smarttraffic.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TraffciLightBean;
import com.lenovo.smarttraffic.ui.fragment.DialogQ11;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q11RecyclerViewAdapter extends RecyclerView.Adapter<Q11RecyclerViewAdapter.VH> {

    List<TraffciLightBean> datas;
    Activity activity;


    public Q11RecyclerViewAdapter(Activity activity, List<TraffciLightBean> datas) {
        this.datas = datas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q11, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.lukou.setText("" + datas.get(position).getLukou());
        holder.red.setText("" + datas.get(position).getRedtime());
        holder.green.setText("" + datas.get(position).getGreentime());
        holder.yellow.setText("" + datas.get(position).getYellowtime());

        holder.btnSet.setOnClickListener(v -> {
            DialogQ11 dialogQ11 = new DialogQ11();
            dialogQ11.show(activity.getFragmentManager(), "11");
        });

        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //选中的话就把position传出去，外面有人记录
                if(isChecked){
                    EventBus.getDefault().post(new Integer(position));
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.lukou)
        TextView lukou;
        @BindView(R.id.red)
        TextView red;
        @BindView(R.id.green)
        TextView green;
        @BindView(R.id.yellow)
        TextView yellow;
        @BindView(R.id.cb)
        CheckBox cb;
        @BindView(R.id.btn_set)
        Button btnSet;

        public VH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
