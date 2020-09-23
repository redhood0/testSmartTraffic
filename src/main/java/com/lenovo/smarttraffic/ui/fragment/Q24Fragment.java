package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q24Fragment extends SupportFragment {

    @BindView(R.id.wendu)
    TextView wendu;
    @BindView(R.id.wendu2)
    TextView wendu2;
    @BindView(R.id.linechart)
    LineChart linechart;
    Unbinder unbinder;
    ArrayList<String> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q24, container, false);
        unbinder = ButterKnife.bind(this, v);
        arrayList.add("昨天");
        arrayList.add("今天");
        arrayList.add("明天");
        arrayList.add("周五");
        arrayList.add("周六");
        arrayList.add("周日");

        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0,22));
        entries.add(new Entry(1,24));
        entries.add(new Entry(2,22));
        entries.add(new Entry(3,25));
        entries.add(new Entry(4,22));
        entries.add(new Entry(5,21));

        List<Entry> entrie2 = new ArrayList<>();
        entrie2.add(new Entry(0,12));
        entrie2.add(new Entry(1,14));
        entrie2.add(new Entry(2,12));
        entrie2.add(new Entry(3,15));
        entrie2.add(new Entry(4,12));
        entrie2.add(new Entry(5,11));

        LineDataSet lineDataSet = new LineDataSet(entries,"白天");
        lineDataSet.setColor(Color.RED);
        LineDataSet lineDataSet2 = new LineDataSet(entrie2,"晚上");
        lineDataSet2.setColor(Color.BLUE);
        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);
        lineData.addDataSet(lineDataSet2);
        XAxis xAxis =linechart.getXAxis();
        xAxis.setAxisMaximum(5);
        xAxis.setAxisMinimum(0);
        xAxis.setLabelCount(5);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                return arrayList.get((int) value);
            }
        });

        linechart.setExtraOffsets(40,40,40,40);
        linechart.setData(lineData);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
