package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q19BarBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Q19FragmentP2 extends Fragment {
    @BindView(R.id.hbarchart)
    HorizontalBarChart hbarchart;
    Unbinder unbinder;

    List<Q19BarBean> datas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q19_p2, container, false);
        unbinder = ButterKnife.bind(this, v);
        datas = new ArrayList<>();
        initData();

        int[] colors = {0xff00ff00, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 0));
        for (int i = 1; i <= 10; i++) {
            barEntries.add(new BarEntry(i, datas.get(i - 1).getNum()));
        }

        XAxis xAxis = hbarchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMaximum(11);
        xAxis.setAxisMinimum(0);
        xAxis.setLabelCount(10);
        xAxis.setDrawGridLines(false);
//        xAxis.setXOffset(40);

        YAxis yAxis = hbarchart.getAxisLeft();
        yAxis.setEnabled(true);
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(150);
        yAxis.setDrawGridLines(true);
        yAxis.setGridLineWidth(2f);
        yAxis.setGridColor(Color.RED);


        YAxis yyAxis = hbarchart.getAxisRight();
        yyAxis.setAxisMinimum(0);
        yyAxis.setAxisMaximum(150);
        yyAxis.setLabelCount(6);
        yyAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value * 1 / 6 + "%";
            }
        });
        yyAxis.setDrawGridLines(false);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value < 1 || value > 10) {
                    return "";
                }
                return datas.get((int) value - 1).getTitle();
            }
        });

        BarDataSet barDataSet = new BarDataSet(barEntries, "");


        barDataSet.setColors(colors);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);
        hbarchart.setClickable(false);
        hbarchart.setExtraOffsets(100, 40, 100, 40);
        hbarchart.setData(barData);
        return v;
    }

    private void initData() {
        datas.add(new Q19BarBean("机动车逆向行驶", 31));
        datas.add(new Q19BarBean("违规使用机动车道", 41));
        datas.add(new Q19BarBean("违反禁止标记", 44));
        datas.add(new Q19BarBean("sb1", 51));
        datas.add(new Q19BarBean("sb2", 61));
        datas.add(new Q19BarBean("sb3", 71));
        datas.add(new Q19BarBean("sb4", 81));
        datas.add(new Q19BarBean("sb5", 111));
        datas.add(new Q19BarBean("超速行驶", 121));
        datas.add(new Q19BarBean("酒驾", 141));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
