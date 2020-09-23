package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ15p1 extends SupportFragment {
    @BindView(R.id.piechat)
    PieChart piechat;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q15_p1, container, false);
        unbinder = ButterKnife.bind(this, v);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(286,"有违章"));
        pieEntries.add(new PieEntry(713,"无违章"));

        piechat.setUsePercentValues(true);


        PieDataSet pieDataSet = new PieDataSet(pieEntries,"");
        pieDataSet.setValueLinePart1Length(1);
        pieDataSet.setValueLinePart2Length(1);
        pieDataSet.setValueLinePart1OffsetPercentage(80f);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return value+"%";
            }
        });
        pieDataSet.setValueTextSize(30);
        pieDataSet.setFormSize(30);
        int[] colors = {Color.BLUE,Color.RED};
        pieDataSet.setColors(colors);

        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);
        piechat.setEntryLabelTextSize(30);
        piechat.setData(pieData);
        piechat.setHoleRadius(0);
        piechat.setTransparentCircleRadius(0);
        piechat.setExtraOffsets(40,40,40,40);
        piechat.setRotationEnabled(false);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
