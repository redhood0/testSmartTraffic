package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TrafficBean922;
import com.lenovo.smarttraffic.ui.adapter.TrafficeAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment922_1 extends SupportFragment {

    @BindView(R.id.rv)
    RecyclerView recyclerView;
    @BindView(R.id.spinner)
    Spinner spinner;
    List<TrafficBean922> trafficBean922s = new ArrayList<>();
    TrafficeAdapter trafficeAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_922, container, false);
        ButterKnife.bind(this, v);

        ArrayList<String> lits = new ArrayList<>();
        String[] strs = {"路口正序", "路口倒序", "红灯正序", "红灯倒序", "绿灯正序"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, strs);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Collections.sort(trafficBean922s, lukouZ());
                        trafficeAdapter.notifyDataSetChanged();
                        break;
                    case 1:
                        Collections.sort(trafficBean922s, lukouF());
                        trafficeAdapter.notifyDataSetChanged();
                        break;
                    case 2:
                        Toast.makeText(_mActivity, "你选中第三个", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(_mActivity, "你选中第四个", Toast.LENGTH_SHORT).show();

                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        recyclerView.setHasFixedSize(true);
//        trafficBean922s.add(new TrafficBean922("路口","红灯时常","黄灯时常","绿灯时常"));
        trafficBean922s.add(new TrafficBean922("2", "2", "4", "6"));
        trafficBean922s.add(new TrafficBean922("1", "3", "5", "7"));
        trafficBean922s.add(new TrafficBean922("3", "6", "2", "1"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        Collections.sort(trafficBean922s, lukouZ());

        trafficeAdapter = new TrafficeAdapter(trafficBean922s);
        trafficeAdapter.setHasStableIds(true);
        recyclerView.setAdapter(trafficeAdapter);


        return v;
    }

    //路口正序
    public static Comparator<TrafficBean922> lukouZ() {
        Comparator<TrafficBean922> comparator = new Comparator<TrafficBean922>() {
            @Override
            public int compare(TrafficBean922 o1, TrafficBean922 o2) {
                if (Integer.parseInt(o1.getLukou()) > Integer.parseInt(o2.getLukou())) {
                    return 1;
                } else if (Integer.parseInt(o1.getLukou()) < Integer.parseInt(o2.getLukou())) {
                    return -1;
                }
                return 0;
            }
        };
        return comparator;
    }

    //路口倒序
    public Comparator<TrafficBean922> lukouF() {
        Comparator<TrafficBean922> comparator = new Comparator<TrafficBean922>() {
            @Override
            public int compare(TrafficBean922 o1, TrafficBean922 o2) {
                if (Integer.parseInt(o1.getLukou()) > Integer.parseInt(o2.getLukou())) {
                    return -1;
                } else if (Integer.parseInt(o1.getLukou()) < Integer.parseInt(o2.getLukou())) {
                    return 1;
                }
                return 0;
            }
        };
        return comparator;
    }
}
