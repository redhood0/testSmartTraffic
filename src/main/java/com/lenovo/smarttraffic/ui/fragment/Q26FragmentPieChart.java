package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.lenovo.smarttraffic.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q26FragmentPieChart extends SupportFragment {
    @BindView(R.id.pie)
    PieChart pie;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q26_chart1, container, false);

        unbinder = ButterKnife.bind(this, v);

        List<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);

        List<PieEntry> pieEntries1 = new ArrayList<>();
        pieEntries1.add(new PieEntry(31, "有重复违章"));
        pieEntries1.add(new PieEntry(87, "无重复违章"));

//        List<PieEntry> pieEntries2 = new ArrayList<>();
//        pieEntries2.add(new PieEntry(87));

        PieDataSet pieDataSet = new PieDataSet(pieEntries1, "");
        pieDataSet.setColors(colors);
        pieDataSet.setSliceSpace(3);//设置各个饼的间隔
        pieDataSet.setSelectionShift(5);//设置选中移动出去的距离

        //设置线
        pieDataSet.setValueLinePart1Length(1);
        pieDataSet.setValueLinePart2Length(1);
        pieDataSet.setValueLinePart1OffsetPercentage(80f);
        pieDataSet.setValueLineColor(Color.BLACK);
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

//        PieDataSet pieDataSet2 = new PieDataSet(pieEntries2,"无重复违章");
//        pieDataSet2.setColors(colors);

        PieData pieData = new PieData();
        pieData.addDataSet(pieDataSet);

        pieData.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                DecimalFormat format = new DecimalFormat();
                format.applyPattern("0.00");
                String x = format.format(value);
                String result = x + "%";
                return result;
            }
        });
        pieData.setValueTextSize(30);

//        pieData.addDataSet(pieDataSet2);
        pie.setData(pieData);
        pie.setRotationEnabled(false);


        pie.setExtraOffsets(40, 40, 40, 40);
        pie.setTransparentCircleRadius(0);
        pie.setHoleRadius(0);
        pie.setUsePercentValues(true);

        Legend legend = pie.getLegend();
        legend.setTextSize(30);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

//        pie.setScrollbarFadingEnabled(false);

        pie.invalidate();


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
