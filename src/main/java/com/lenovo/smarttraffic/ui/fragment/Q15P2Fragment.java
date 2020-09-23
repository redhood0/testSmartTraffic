package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q15P2Fragment extends SupportFragment {
    @BindView(R.id.twobar)
    BarChart twobar;
    Unbinder unbinder;
    int i = 1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q15_p2, container, false);
        unbinder = ButterKnife.bind(this, v);

        List<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1,new float[]{220,140}));
        barEntries.add(new BarEntry(2,new float[]{420,440}));
        barEntries.add(new BarEntry(3,new float[]{320,240}));
        barEntries.add(new BarEntry(4,new float[]{120,100}));

        int[] colors = {Color.GREEN,Color.YELLOW};
        BarDataSet barDataSet = new BarDataSet(barEntries,"");
        barDataSet.setStackLabels(new String[]{"男性","女性"});
        barDataSet.setColors(colors);

        barDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                Log.e("ssss", "getFormattedValue: "+entry.getData() + ">>" + entry.toString());
                i++;
                if(i%2 == 0){
                    return "";
                }else {
                    return "20%";
                }

            }
        });

        BarData barData = new BarData(barDataSet);

        twobar.setData(barData);
        twobar.setTouchEnabled(false);
        twobar.setDrawValueAboveBar(false);

        twobar.getXAxis().setDrawGridLines(false);
        twobar.setFitBars(true);
//        String[] titles = {"111","222"};
//        twobar.getXAxis().setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                if(value<0 || value > titles.length - 1){
//                    return "";
//                }
//                return titles[(int) value];
//            }
//        });
//        twobar.groupBars(0,0.2f,0.2f);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
