package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TraffciLightBean;
import com.lenovo.smarttraffic.ui.adapter.Q11RecyclerViewAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ11Home extends SupportFragment {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sp)
    Spinner sp;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.btn_allset)
    Button btnAllset;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;
    List<TraffciLightBean> trafData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);

        View v = inflater.inflate(R.layout.fragment_q11, container, false);
        unbinder = ButterKnife.bind(this, v);
        String[] spinners = {"路口升序", "路口降序", "红灯升序", "红灯降序", "绿灯升序", "绿灯降序", "黄灯升序", "黄灯降序"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_just_text, R.id.tv, spinners);
        sp.setAdapter(arrayAdapter);

        initData();
        //这里是okhttp请求时时的数据，如果没有请求到，默认都是5
        initView();

        initAction();
        return v;
    }

    private void initAction() {
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Collections.sort(trafData,new FirstCompareAble());
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        Collections.sort(trafData,new FirstCompareAble2());
                        adapter.notifyDataSetChanged();

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    Q11RecyclerViewAdapter adapter;
    private void initView() {
        adapter = new Q11RecyclerViewAdapter(getActivity(), trafData);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData() {
        trafData.add(new TraffciLightBean(1, 5, 5, 5));
        trafData.add(new TraffciLightBean(2, 6, 6, 6));
        trafData.add(new TraffciLightBean(3, 7, 7, 7));
        trafData.add(new TraffciLightBean(4, 8, 8, 8));
        trafData.add(new TraffciLightBean(5, 5, 5, 5));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dosomthing(String x) {
        Log.e("ssss", "dosomthing: >>>>>" + x);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dosomthing(Integer x) {
        Log.e("ssss", "dosomthing: >>>>>" + x);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);

    }
//后面的其他灯都同理复制就行了

    private class FirstCompareAble implements Comparator<TraffciLightBean> {

        @Override
        public int compare(TraffciLightBean o1, TraffciLightBean o2) {
            if (o1.getLukou() > o2.getLukou()) {
                return 1;
            } else if (o1.getLukou() < o2.getLukou()) {
                return -1;
            }
            return 0;
        }
    }

    private class FirstCompareAble2 implements Comparator<TraffciLightBean> {

        @Override
        public int compare(TraffciLightBean o1, TraffciLightBean o2) {
            if (o1.getLukou() > o2.getLukou()) {
                return -1;
            } else if (o1.getLukou() < o2.getLukou()) {
                return 1;
            }
            return 0;
        }
    }
}
