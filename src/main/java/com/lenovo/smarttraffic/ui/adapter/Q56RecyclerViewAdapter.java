package com.lenovo.smarttraffic.ui.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Q56RecyclerViewAdapter extends RecyclerView.Adapter<Q56RecyclerViewAdapter.VH> {
    List<String> datas;

    List<VH> Vhs = new ArrayList<>();
    RecyclerView rv;
    List<Boolean> flags;

    public Q56RecyclerViewAdapter(List<String> datas, RecyclerView rv,List<Boolean> flags) {
        this.datas = datas;
        this.rv = rv;
        this.flags = flags;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_q56_rv, parent, false);
        VH vh = new VH(v);

        Vhs.add(vh);
        return vh;
    }
    boolean flag = true;

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.tvNum.setText(String.valueOf(position+1));
        holder.tvName.setText(datas.get(position));
        if(!flags.get(position)) {
            holder.tvName.setTextColor(Color.BLACK);
        }else {
            holder.tvName.setTextColor(Color.RED);
        }


        Log.e("sss", "onBindViewHolder: "+  Vhs.size());


        holder.tvName.setOnClickListener(v ->{


            Log.e("sss", " Log.e:>>>> "+  position);
            boolean flag = flags.get(position);
            Log.e("sss", " Log.e:>>>> "+  flag);
//            //便利所有
//            for(View view : views){
//               TextView tv =  view.findViewById(R.id.tv_name);
//                tv.setTextColor(Color.BLACK);
//            }
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
                    int i = 0 ;
                    for(boolean f : flags){
                        flags.set(i,false);
                        i++;
//                        f = false;
                    }
                    for(boolean f : flags){
                        Log.e("ss", "run: "+ f );
                   }
//                }
//            }).start();

            Log.e("ss", "run:>>>>>>>>>>"+ flag );
            if(!flag){
                flags.set(position,true);
                ((TextView)v).setTextColor(Color.RED);
            }else {
//                flags.add(position,false);
                ((TextView)v).setTextColor(Color.BLACK);
            }
            notifyDataSetChanged();


        });
    }

    private void toDoSometing(View v, int position) {
        TextView tv = rv.getLayoutManager().findViewByPosition(position).findViewById(R.id.tv_name);
        tv.setTextColor(Color.RED);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    List<View> views ;

    public void setViews(List<View> views) {
        this.views = views;
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvNum;
        TextView tvName;

        public VH(View itemView) {
            super(itemView);
            tvNum = itemView.findViewById(R.id.tv_num);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }

    private void toBeBlack(VH vh){
        vh.tvName.setTextColor(Color.BLUE);
    }
}
