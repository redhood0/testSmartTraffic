package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q26FragmentBarChart extends SupportFragment {

    Unbinder unbinder;
    @BindView(R.id.barchart)
    HorizontalBarChart barchart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q26_chart2, container, false);
        unbinder = ButterKnife.bind(this, v);

        int[] colors = {Color.RED, Color.BLUE, Color.GREEN};

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(0, 0));

        barEntries.add(new BarEntry(1, 60.15f));
        barEntries.add(new BarEntry(2, 26.28f));
        barEntries.add(new BarEntry(3, 13.20f));

        BarDataSet barDataSet = new BarDataSet(barEntries, "");
        barDataSet.setDrawValues(true);

        barDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return value+"%";
            }
        });
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setDrawValues(true);
        barDataSet.setValueTextSize(15f);
        barDataSet.setColors(colors);
//        barDataSet.setDrawValues(true);
        BarData barData = new BarData();
        barData.addDataSet(barDataSet);
        barData.setBarWidth(0.5f);

        barchart.setData(barData);


        barchart.setExtraOffsets(40, 40, 40, 40);


        XAxis xAxis = barchart.getXAxis();
        xAxis.setAxisMaximum(4);
        xAxis.setAxisMinimum(0);
        xAxis.setLabelCount(3);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            String[] title = {"1-2条违章", "3-5条违章", "5条以上违章"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {

                if (value < 1 || value > 3) {
                    return "";
                }
                return title[(int) value - 1];
            }
        });


//        barchart.setScaleEnabled(false);

//        barchart.setDrawBarShadow(true);
//        barchart.setHighlightFullBarEnabled(true);

        barchart.invalidate();
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
