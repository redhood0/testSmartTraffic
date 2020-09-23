package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q50Fragment extends SupportFragment {

    @BindView(R.id.bar_chart)
    BarChart barChart;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.q50fragment, container, false);
        unbinder = ButterKnife.bind(this, v);

        initView();
        return v;
    }

    private void initView() {


        List<BarEntry> entry1 = new ArrayList<>();
        entry1.add(new BarEntry(1,1));
        entry1.add(new BarEntry(2,2));
        entry1.add(new BarEntry(3,3));
        entry1.add(new BarEntry(4,4));

        List<BarEntry> entry2 = new ArrayList<>();
        entry2.add(new BarEntry(1,2));
        entry2.add(new BarEntry(2,3));
        entry2.add(new BarEntry(3,4));
        entry2.add(new BarEntry(4,5));

        List<BarEntry> entry3 = new ArrayList<>();
        entry3.add(new BarEntry(1,3));
        entry3.add(new BarEntry(2,2));
        entry3.add(new BarEntry(3,4));
        entry3.add(new BarEntry(4,1));



        BarDataSet barDataSet = new BarDataSet(entry1,"label1");
        barDataSet.setColor(Color.RED);
        barDataSet.setBarBorderWidth(1);
        barDataSet.setFormLineWidth(200);

        BarDataSet barDataSet2 = new BarDataSet(entry2,"label2");

        BarDataSet barDataSet3 = new BarDataSet(entry3,"label3");
        barDataSet3.setColor(Color.GREEN);



        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(20);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        YAxis right = barChart.getAxisRight();

        right.setAxisMaximum(5);
        right.setAxisMinimum(0);
        right.setLabelCount(5);
        right.setDrawAxisLine(true);
        right.setAxisLineWidth(2f);
        right.setAxisLineColor(Color.GREEN);

        YAxis left = barChart.getAxisLeft();
        left.setAxisMaximum(5);
        left.setAxisMinimum(0);
        left.setLabelCount(5);
        left.setDrawAxisLine(true);
        left.setAxisLineWidth(2f);
        left.setAxisLineColor(Color.GREEN);
        left.setValueFormatter(new RightValueFormatter());

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);
        barData.addDataSet(barDataSet2);
        barData.addDataSet(barDataSet3);
        barData.setBarWidth(0.2f);
        barData.groupBars(0,1,0.1f);

        Description des = new Description();
        des.setText("我是描述1111");
        des.setPosition(100,100);
        barChart.setDescription(des);
        barChart.setData(barData);

        Legend legend = barChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });
        barChart.invalidate();



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    class RightValueFormatter implements IAxisValueFormatter{
        String[] v = {"a1","a2","a3","a4","a5","a6"};
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
//            for (int i=0;i<v.length;i++){
//                if(value==(xAxisValues.get(i)-1)) {
//                    return xValues[i];
//                }
//            }
            return v[(int)value];
        }

    }
}
