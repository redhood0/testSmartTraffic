package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.zujian.PopUpWindow4Q22;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Q22RvAdapter extends RecyclerView.Adapter<Q22RvAdapter.VH> {
    public List<String> yues;
   public Fragment fragment;
    public List<Integer> checks = new ArrayList<>();

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q22, parent, false);
        VH vh = new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.num.setText("" + (position + 1));

        holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checks.add(position+1);
                }else {
                    checks.remove(position+1);
                }
            }
        });

        holder.btnChongzhi.setOnClickListener(v ->{

            //点击弹出充值界面。
            PopUpWindow4Q22 q22= new PopUpWindow4Q22();
//            q22.getDialog().getWindow().
            q22.ac = fragment.getActivity();
            q22.show(fragment.getChildFragmentManager(),"111");


        });
    }

    @Override
    public int getItemCount() {
        return yues.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView num;
        TextView yue;
        CheckBox checkbox;
        Button btnChongzhi;

        public VH(View itemView) {
            super(itemView);
            num = itemView.findViewById(R.id.num);
            yue = itemView.findViewById(R.id.yue);
            checkbox = itemView.findViewById(R.id.checkbox);
            btnChongzhi = itemView.findViewById(R.id.btn_chongzhi);

        }
    }
}
