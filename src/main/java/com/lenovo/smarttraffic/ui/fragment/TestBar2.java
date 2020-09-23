package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class TestBar2 extends SupportFragment {
    @BindView(R.id.piechat)
    PieChart piechat;
    Unbinder unbinder;
    @BindView(R.id.radar)
    RadarChart radar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.test_bar2, container, false);
        unbinder = ButterKnife.bind(this, v);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(10, "a"));
        pieEntries.add(new PieEntry(20, "b"));
        pieEntries.add(new PieEntry(30, "c"));
        pieEntries.add(new PieEntry(40, "d"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");

        int[] color = new int[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN,Color.GREEN};
        pieDataSet.setColors(color);

        pieDataSet.setValueLinePart1Length(1);
        pieDataSet.setValueLinePart2Length(1);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        piechat.setUsePercentValues(true);
        piechat.setTransparentCircleRadius(0);
        piechat.setHoleRadius(0);
        PieData pieData = new PieData(pieDataSet);
        piechat.setData(pieData);
        piechat.setRotationEnabled(false);

        piechat.setExtraOffsets(50, 50, 50, 50);


        List<RadarEntry> yVals =  new ArrayList<>();
        yVals.add(new RadarEntry(30));
        yVals.add(new RadarEntry(40));
        yVals.add(new RadarEntry(70));
        yVals.add(new RadarEntry(20));
        yVals.add(new RadarEntry(100));

        List<RadarEntry> yVals2 =  new ArrayList<>();
        RadarEntry entry = new RadarEntry(100);
        entry.setIcon(getResources().getDrawable(R.drawable.shape_round));

        yVals2.add(entry);
        yVals2.add(entry);
        yVals2.add(entry);
        yVals2.add(entry);
        yVals2.add(entry);

        RadarDataSet dataSet = new RadarDataSet(yVals,"111");

        dataSet.setDrawFilled(true);//填充
        dataSet.setFillAlpha(30);
        dataSet.setFillColor(Color.BLUE);//设置颜色
        dataSet.setValueTextSize(40);

        radar.getXAxis().setDrawLabels(false);


        dataSet.setColor(Color.RED);
        RadarDataSet dataSet2 = new RadarDataSet(yVals,"2222");
        dataSet2.setColor(Color.BLUE);
        RadarDataSet dataSet3 = new RadarDataSet(yVals,"3333");
        dataSet3.setColor(Color.YELLOW);
        RadarDataSet dataSet4 = new RadarDataSet(yVals,"4444");
        dataSet4.setColor(Color.GREEN);
        RadarDataSet dataSet5 = new RadarDataSet(yVals,"5555");
        dataSet5.setColor(Color.RED);

        RadarDataSet dataSetforConner = new RadarDataSet(yVals2,"");
        dataSetforConner.setColor(Color.TRANSPARENT);

        RadarData radarData = new RadarData();

        radarData.setValueTextSize(40);
        radarData.setValueTextColor(Color.BLUE);

        radarData.addDataSet(dataSet);
        radarData.addDataSet(dataSet2);
        radarData.addDataSet(dataSet3);
        radarData.addDataSet(dataSet4);
        radarData.addDataSet(dataSet5);
        radarData.addDataSet(dataSetforConner);

        YAxis yAxis =  radar.getYAxis();
        yAxis.setAxisMaximum(80);
        yAxis.setAxisMinimum(0);


        radar.setData(radarData);
        radar.setRotationEnabled(false);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
