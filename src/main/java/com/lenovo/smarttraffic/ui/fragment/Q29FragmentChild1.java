package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q29FragmentChild1 extends SupportFragment {
    @BindView(R.id.lc1)
    LineChart lc1;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_q29_child1, container, false);
        unbinder = ButterKnife.bind(this, view);


       int x = (int) (Math.random()*50 +200);
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1,createPM()));
        entries.add(new Entry(2,createPM()));
        entries.add(new Entry(3,createPM()));
        entries.add(new Entry(4,createPM()));
        entries.add(new Entry(5,createPM()));

        LineDataSet lineDataSet = new LineDataSet(entries,"pm2.5");
        LineData lineData = new LineData(lineDataSet);
        lc1.setData(lineData);

        lc1.getXAxis().setDrawGridLines(false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private int createPM(){
        return (int) (Math.random()*50 +200);
    }
}
