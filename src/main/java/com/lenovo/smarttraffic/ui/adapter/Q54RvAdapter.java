package com.lenovo.smarttraffic.ui.adapter;

import android.app.Activity;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q54User;

import java.util.List;

import butterknife.BindView;

public class Q54RvAdapter extends RecyclerView.Adapter<Q54RvAdapter.VH> {

    List<Q54User> userList;
    Activity activity;

    public Q54RvAdapter(List<Q54User> userList,Activity activity) {
        this.userList = userList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q54_fragment, parent, false);

        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);
        LinearLayout.LayoutParams layoutParams =  new LinearLayout.LayoutParams(size.x, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.cl.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView ivTouxiang;
        ConstraintLayout cl;
        TextView tvUsername;
        TextView tvName;
        TextView tvPhone;
        TextView tvType;
        TextView tvSave;
        TextView tvDelete;
        public VH(View itemView) {
            super(itemView);
            ivTouxiang = itemView.findViewById(R.id.iv_touxiang);
            cl = itemView.findViewById(R.id.cl);
        }
    }
}
