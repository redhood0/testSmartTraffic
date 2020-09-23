package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q5GreenBean;
import com.lenovo.smarttraffic.greendao.Q5GreenBeanDao;
import com.lenovo.smarttraffic.ui.adapter.TimeValueFormat;

import org.greenrobot.greendao.Property;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TestChart2Fragment extends Fragment  {

    Timer timer;
    @BindView(R.id.lc_1)
    LineChart lc1;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chart1, container, false);
        timer = new Timer();

        unbinder = ButterKnife.bind(this, v);

        initView();
        return v;
    }

    private void initView() {
        XAxis xAxis = lc1.getXAxis();
        YAxis axisLeft = lc1.getAxisLeft();
        YAxis axisRight = lc1.getAxisRight();

        axisRight.setEnabled(false);
        axisLeft.setAxisMaximum(6);
        axisLeft.setAxisMinimum(0);
        axisLeft.setLabelCount(6);



        List<Q5GreenBean> q5s = InitApp.getDaoSession().getQ5GreenBeanDao().queryBuilder().orderDesc(Q5GreenBeanDao.Properties.Date).limit(20).list();
        int n = 1;
        //调整x轴
        xAxis.setValueFormatter(new TimeValueFormat(q5s));
        xAxis.setLabelRotationAngle(90);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(20,true);

        lc1.setDescription(null);





//        xAxis.setLabelCount(19);

        List<Entry> entries = new ArrayList<>();
        Collections.reverse(q5s);
        for(Q5GreenBean q5 : q5s){
            entries.add(new Entry(n,q5.getTfStatus()));
            n++;
        }

        LineDataSet data = new LineDataSet(entries,"交通");
        data.setLineWidth(10f);
        data.setDrawValues(false);
        LineData lineData = new LineData(data);
        lc1.setData(lineData);
        lc1.invalidate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
