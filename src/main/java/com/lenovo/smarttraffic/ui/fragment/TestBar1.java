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
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.lenovo.smarttraffic.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;
import me.yokeyword.fragmentation.SupportFragment;

public class TestBar1 extends SupportFragment {
    @BindView(R.id.barchart)
    BarChart barchart;
    Unbinder unbinder;
    @BindView(R.id.hbarchart)
    HorizontalBarChart hbarchart;
    @BindView(R.id.hellow)
    ColumnChartView hellow;
    @BindView(R.id.linechart)
    LineChart linechart;

    List<Integer> co2 = new ArrayList<>();
    int i = 10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.test_bar1, container, false);
        unbinder = ButterKnife.bind(this, v);

        int[] colors = new int[]{Color.BLUE, Color.YELLOW};

        barchart.setExtraOffsets(40, 40, 40, 40);
        barchart.setDrawValueAboveBar(false);


        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, new float[]{21, 33}));
        entries.add(new BarEntry(2, new float[]{33, 33}));
        entries.add(new BarEntry(3, new float[]{70, 77}));
        entries.add(new BarEntry(4, new float[]{60, 40}));


        BarDataSet barDataSet = new BarDataSet(entries, "");
        barDataSet.setStackLabels(new String[]{"aaa", "bbb"});
        barDataSet.setColors(colors);
        BarData barData = new BarData();

        barData.addDataSet(barDataSet);
        barchart.setData(barData);

        XAxis x = barchart.getXAxis();
        x.setAxisMinimum(0);
        x.setAxisMaximum(5);
        x.setLabelCount(5);
        x.setDrawGridLines(false);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis y = barchart.getAxisLeft();
        y.setAxisMinimum(0);
        y.setMaxWidth(150);

        barchart.setTouchEnabled(false);


//        hbarchart

        List<BarEntry> entries1 = new ArrayList<>();
        entries1.add(new BarEntry(1, 220));
        entries1.add(new BarEntry(2, 250));
        entries1.add(new BarEntry(3, 270));
        entries1.add(new BarEntry(4, 290));
        entries1.add(new BarEntry(5, 320));
        BarDataSet barDataSet1 = new BarDataSet(entries1, "111");
        barDataSet1.setColor(Color.RED);

        List<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(1, 120));
        entries2.add(new BarEntry(2, 150));
        entries2.add(new BarEntry(3, 170));
        entries2.add(new BarEntry(4, 190));
        entries2.add(new BarEntry(5, 120));
        BarDataSet barDataSet2 = new BarDataSet(entries2, "222");
        barDataSet2.setColor(Color.BLUE);


        BarData barData1 = new BarData();
        barData1.addDataSet(barDataSet1);
        barData1.addDataSet(barDataSet2);
        barData1.setBarWidth(0.1f);


        hbarchart.setData(barData1);
        hbarchart.groupBars(0, 0.2f, 0.1f);

        Legend legend = hbarchart.getLegend();


        hbarchart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.e("sss", "onValueSelected: " + e.toString() + ">>>" + h);

            }

            @Override
            public void onNothingSelected() {

            }
        });

        List<Column> columns = new ArrayList<>();
        List<SubcolumnValue> subcolumnValues = new ArrayList<>();
        subcolumnValues.add(new SubcolumnValue(100, Color.RED));
//        subcolumnValues.add(new SubcolumnValue(50,Color.GREEN));
//        subcolumnValues.add(new SubcolumnValue(20,Color.YELLOW));


        List<SubcolumnValue> subcolumnValues2 = new ArrayList<>();
        subcolumnValues2.add(new SubcolumnValue(30, Color.GREEN));


        List<SubcolumnValue> subcolumnValues3 = new ArrayList<>();
        subcolumnValues3.add(new SubcolumnValue(70, Color.YELLOW));


        Column column1 = new Column(subcolumnValues);
        column1.setHasLabels(true);

        Column column2 = new Column(subcolumnValues2);
        column2.setHasLabels(true);

        Column column3 = new Column(subcolumnValues3);
        column3.setHasLabels(true);


        columns.add(column1);
        columns.add(column2);
        columns.add(column3);
        ColumnChartData columnChartData = new ColumnChartData(columns);
        columnChartData.setFillRatio(0.1f);
        hellow.setColumnChartData(columnChartData);

        Axis axisButtom = new Axis();
        axisButtom.setHasLines(false);
        axisButtom.setLineColor(Color.parseColor("#ff000000"));
        axisButtom.setHasTiltedLabels(true);
        axisButtom.setName("底部");
        axisButtom.setHasTiltedLabels(false);

        axisButtom.setMaxLabelChars(2);

        axisButtom.setTextColor(Color.BLACK);
        axisButtom.setTextSize(10);

        List<AxisValue> axisValues = new ArrayList<>();
        axisValues.add(new AxisValue(0f).setLabel("早"));
        axisValues.add(new AxisValue(1f).setLabel("中"));
        axisValues.add(new AxisValue(2f).setLabel("晚"));
        axisButtom.setValues(axisValues);
        columnChartData.setAxisXBottom(axisButtom);

        Axis axisLeft = new Axis();
        axisLeft.setName("左侧名字");

        axisLeft.setTextSize(20);

        columnChartData.setAxisYLeft(axisLeft);

//        columnChartData.setFillRatio(0.5f);
//        hellow.setInteractive(true);

        hellow.setOnValueTouchListener(new ColumnChartOnValueSelectListener() {
            @Override
            public void onValueSelected(int i, int i1, SubcolumnValue subcolumnValue) {
                Log.e("onValueSelected", "onValueSelected: " + i + ">>" + i1 + ">>" + subcolumnValue);
                subcolumnValue.setValue(0);
            }

            @Override
            public void onValueDeselected() {

            }
        });

        for (int i = 0; i < 10; i++) {
            co2.add((int) (10 + Math.random() * 35));
        }

        hellow.setZoomEnabled(false);
        hellow.offsetLeftAndRight(200);
        hellow.offsetTopAndBottom(200);
        hellow.setPadding(50, 50, 50, 50);

        List<Entry> entries3 = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            entries3.add(new Entry(i, co2.get(i - 1)));
        }


        XAxis xAxis = linechart.getXAxis();


        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
//        xAxis.setAxisMaximum(20);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(1000);

//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                //todo：从容器中取时间
//                //data.get(value).getTime
//                return value;
//            }
//        });

        xAxis.setLabelCount(20);
        linechart.setVisibleXRangeMaximum(20);// 当前统计图表中最多在x轴坐标线上显示的总量


        linechart.getAxisRight().setEnabled(false);
        YAxis yAxis = linechart.getAxisLeft();
        yAxis.setAxisMaximum(50);
        yAxis.setAxisMinimum(0);
        yAxis.setLabelCount(5);
        yAxis.setDrawGridLines(false);


        LineDataSet lineDataSet = new LineDataSet(entries3, "");
        lineDataSet.setLineWidth(10);
        lineDataSet.setColor(Color.RED);
        LineData lineData = new LineData(lineDataSet);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        linechart.setData(lineData);
        linechart.setScaleEnabled(false);
        linechart.setDrawBorders(true);
        linechart.setDragEnabled(false);
        linechart.animateX(1500);


        linechart.setExtraOffsets(50, 50, 50, 50);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                co2.add((int) (20 + Math.random() * 30));
                i++;
                entries3.add(new Entry(i, (int) (20 + Math.random() * 30)));


                linechart.post(new Runnable() {
                    @Override
                    public void run() {
                        linechart.notifyDataSetChanged();
                        if(i-18>0){
                            linechart.moveViewToAnimated(i-18,0, YAxis.AxisDependency.LEFT,1000);
                        }
                        linechart.invalidate();

                    }
                });
            }
        }, 0, 1000);
        return v;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
