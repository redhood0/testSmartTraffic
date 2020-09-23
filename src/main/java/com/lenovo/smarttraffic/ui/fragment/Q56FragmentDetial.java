package com.lenovo.smarttraffic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.ui.adapter.Q56RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q56FragmentDetial extends SupportFragment {
    @BindView(R.id.tv_from_to)
    TextView tvFromTo;
    @BindView(R.id.tv_time_from_to)
    TextView tvTimeFromTo;
    @BindView(R.id.iv_reverse)
    ImageView ivReverse;
    @BindView(R.id.tv_zhantai_num)
    TextView tvZhantaiNum;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    String num;
    GetBusInfoBean.ROWSDETAILBean rowsdetailBean;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q56_detial, container, false);
        unbinder = ButterKnife.bind(this, v);
        if (rowsdetailBean != null) {
            initView();
        }

        return v;
    }

    private void initView() {
        List<String> data = rowsdetailBean.getSites();
//        List<String> data = new ArrayList<>();
//        for(GetBusInfoBean.ROWSDETAILBean.TimeBean bean : timeBeans){
//            data.add(bean.get);
//        }
        Log.e("sss", "data.size()>>>: "+data.size() );
        List<Boolean> flags = new ArrayList<>();
        for(String s : data){
            flags.add(false);
        }
        Q56RecyclerViewAdapter adapter = new Q56RecyclerViewAdapter(data,rv,flags);




//        rv.getLayoutManager().findViewByPosition();
//        rv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
//        rv.setItemViewCacheSize(30);
//        rv.setDrawingCacheEnabled(false);

        List<View> views = new ArrayList<>();
        for(int i = 0; i < data.size() ; i++){
            View v =  rv.getLayoutManager().findViewByPosition(i);
            views.add(v);
        }
        adapter.setViews(views);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void setData(List<GetBusInfoBean.ROWSDETAILBean> lists, String num) {

        this.num = num;
        rowsdetailBean = lists.get(Integer.parseInt(num));
    }
}
