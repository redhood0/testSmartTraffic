package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TestBean1;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q61Fragment extends SupportFragment {

    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_1)
    LinearLayout tv1;
    @BindView(R.id.tv_2)
    LinearLayout tv2;
    @BindView(R.id.tv_3)
    LinearLayout tv3;
    @BindView(R.id.tv_4)
    LinearLayout tv4;
    @BindView(R.id.tv_5)
    LinearLayout tv5;
    @BindView(R.id.tv_6)
    LinearLayout tv6;
    @BindView(R.id.linechart)
    LineChart linechart;
    Unbinder unbinder;

    public static Q61Fragment newInstance() {
        return new Q61Fragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        View v = inflater.inflate(R.layout.fragment_q61, container, false);
        Item11Activity homeActivity = (Item11Activity) getActivity();
        homeActivity.initToolBar(homeActivity.getToolbar(), true, "天气信息");
//        homeActivity.getToolbar().setTitle("天气信息");
        unbinder = ButterKnife.bind(this, v);

        initView();
        return v;
    }

    private void initView() {
        List<Entry> entryList = new ArrayList<>();
        for(int i = 0 ; i < 6; i++){
            entryList.add(new Entry(i, (float) (Math.random()*10+20)));
        }
        LineDataSet data  = new LineDataSet(entryList,"11");
        data.setCircleColor(Color.RED);
        data.setColor(Color.RED);

        List<Entry> entryList2 = new ArrayList<>();
        for(int i = 0 ; i < 6; i++){
            entryList2.add(new Entry(i, (float) (Math.random()*6+12)));
        }
        LineDataSet data2  = new LineDataSet(entryList2,"222");
        data2.setColor(Color.BLUE);
        data2.setCircleColor(Color.BLUE);
        LineData lineData = new LineData(data,data2);
//
//        lineData.addDataSet(data);
//        lineData.addDataSet(data2);


        linechart.getXAxis().setLabelCount(5);
        linechart.getXAxis().setDrawLabels(false);
        linechart.getXAxis().setDrawGridLines(false);
        linechart.getXAxis().setDrawAxisLine(false);
        linechart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        linechart.getAxisRight().setEnabled(false);
        linechart.getAxisLeft().setAxisMinimum(10);
        linechart.getAxisLeft().setAxisMaximum(30);
        linechart.getAxisLeft().setEnabled(false);
//        linechart.set
        linechart.getDescription().setEnabled(false);
        linechart.getLegend().setEnabled(false);

        linechart.setData(lineData);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(TestBean1 x) {
        Log.e("xxx", "getMsg:>>>> " + x.getERRMSG());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        EventBus.getDefault().unregister(this);
        unbinder.unbind();
    }
}
