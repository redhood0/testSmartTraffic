package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class Q19FrgamentP1 extends Fragment {
    @BindView(R.id.piechat)
    PieChart piechat;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q19_p1, container, false);

        unbinder = ButterKnife.bind(this, v);
        piechat.setRotationEnabled(false);
        piechat.setExtraOffsets(40, 40, 40, 40);
        piechat.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        piechat.setHoleRadius(0);
        piechat.setTransparentCircleRadius(0);
        int[] colors = {Color.RED, Color.BLUE};


        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(286, "有违章"));
        entries.add(new PieEntry(713, "无违章"));
        PieDataSet pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setColors(colors);

        pieDataSet.setValueLinePart1Length(1);
        pieDataSet.setValueLinePart2Length(1);
        pieDataSet.setValueLinePart1OffsetPercentage(80f);
        pieDataSet.setValueLineColor(Color.BLACK);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        pieDataSet.setSliceSpace(1);

        pieDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                DecimalFormat format = new DecimalFormat("0.00");

                return format.format(value) + "%";
            }
        });
        PieData pieData = new PieData(pieDataSet);
        piechat.setUsePercentValues(true);

        piechat.setData(pieData);


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
