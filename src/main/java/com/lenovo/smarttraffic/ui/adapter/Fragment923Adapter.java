package com.lenovo.smarttraffic.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import java.util.List;

public class Fragment923Adapter extends RecyclerView.Adapter<Fragment923Adapter.MyVH> {


    List<String> persons;
    Context context;


    public Fragment923Adapter(List<String> persons, Context context) {
        this.persons = persons;
        this.context = context;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_923_1,parent,false);
        MyVH myVH = new MyVH(v);
        return myVH;
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
//        Point size = new Point();
//        ((Activity)context).getWindowManager().getDefaultDisplay().getSize(size);
//
//        holder.cl.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Point point = new Point();
        ((Activity)context).getWindowManager().getDefaultDisplay().getSize(point);
        holder.cl.setLayoutParams(new LinearLayout.LayoutParams(point.x, ViewGroup.LayoutParams.WRAP_CONTENT));

        holder.name.setText(persons.get(position));
        holder.delete.setOnClickListener(v ->{
            persons.remove(position);
            holder.hs.scrollTo(0,0);
            notifyDataSetChanged();
        });

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }


    public class MyVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView delete;
        ConstraintLayout cl;
        HorizontalScrollView hs;



        public MyVH(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            delete = itemView.findViewById(R.id.delete);
            cl =  itemView.findViewById(R.id.cl);
            hs = itemView.findViewById(R.id.hs);

        }

    }
}
