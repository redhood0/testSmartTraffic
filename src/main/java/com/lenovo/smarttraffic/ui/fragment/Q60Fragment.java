package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.MyQ60GridAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q60Fragment extends SupportFragment {
    @BindView(R.id.gv_dingyue)
    GridView gvDingyue;
    @BindView(R.id.gv_wait)
    GridView gvWait;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_q60, container, false);
        unbinder = ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        initView();
        return view;
    }
    List<String> dingyueData;
    List<String> waitData;
    private void initView() {
        dingyueData = new ArrayList<>();
        dingyueData.add("推荐");
        dingyueData.add("安全驾驶");

        waitData = new ArrayList<>();
        waitData.add("交通分类");
        waitData.add("科技类");
        waitData.add("路况类");
        waitData.add("汽车类");
        waitData.add("二手车类");
        waitData.add("违章");

        gvDingyue.setAdapter(new MyQ60GridAdapter(dingyueData,waitData,false));
        gvWait.setAdapter(new MyQ60GridAdapter(waitData,dingyueData,true));


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doEvent(HashMap<String,Object> event){
        String content = (String) event.get("content");
        Boolean way = (Boolean) event.get("way");
        if(way){
//            dingyueData.add(content);
            gvDingyue.setAdapter(new MyQ60GridAdapter(dingyueData,waitData,false));
        }else {
//            waitData.add(content);
            gvWait.setAdapter(new MyQ60GridAdapter(waitData,dingyueData,true));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}
