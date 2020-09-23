package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.lenovo.smarttraffic.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

import static com.github.mikephil.charting.data.PieDataSet.ValuePosition.OUTSIDE_SLICE;

public class Fragment_922_3 extends SupportFragment {

    Unbinder unbinder;

    @BindView(R.id.tv_shijian)
    TextView tv_shijian;
    @BindView(R.id.tv_update)
    TextView tv_update;
    @BindView(R.id.piechat)
    PieChart piechat;
    @BindView(R.id.gv_zhishu)
    GridView gv_zhishu;

    List<PieEntry> pieEntries;
    //增加一个值和地名的映射
    List<Integer> colors;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_922_3, container, false);
        unbinder = ButterKnife.bind(this, v);

        initData();
        initView();

        return v;
    }

    private void initData() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(30, "北京"));
        pieEntries.add(new PieEntry(20, "天津"));
        pieEntries.add(new PieEntry(10, "上海"));
        pieEntries.add(new PieEntry(40, "四川"));
        pieEntries.add(new PieEntry(5, "南京"));


        colors = new ArrayList<>();

        colors.add(getResources().getColor(R.color.red_marker));
        colors.add(getResources().getColor(R.color.blue_marker));
        colors.add(getResources().getColor(R.color.grey_line));
        colors.add(getResources().getColor(R.color.Brown));
        colors.add(getResources().getColor(R.color.Deep_Orange));
    }


    private void initData2() {
        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(20, "北京"));
        pieEntries.add(new PieEntry(10, "天津"));
        pieEntries.add(new PieEntry(40, "上海"));
        pieEntries.add(new PieEntry(20, "四川"));
        pieEntries.add(new PieEntry(52, "南京"));


        colors = new ArrayList<>();

        colors.add(getResources().getColor(R.color.red_marker));
        colors.add(getResources().getColor(R.color.blue_marker));
        colors.add(getResources().getColor(R.color.grey_line));
        colors.add(getResources().getColor(R.color.Brown));
        colors.add(getResources().getColor(R.color.Deep_Orange));
    }
    private void initView() {
        tv_shijian.setOnClickListener(v -> {
            TimePickerView tp = new TimePickerBuilder(this.getContext(), new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                    tv_shijian.setText(simpleDateFormat.format(date));
                }
            }).build();
            tp.show();
        });

//
//
//        PieDataSet pieDataSet = new PieDataSet(pieEntries,"label1111");
//        pieDataSet.setColors(colors);
//
//        PieData pieData = new PieData();
//        pieData.setDataSet(pieDataSet);
//
//        piechat.setData(pieData);

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "label2222");
        pieDataSet.setColors(colors);
        pieDataSet.setValueTextSize(30);
        pieDataSet.setValueTextColor(0xff000000);
        pieDataSet.setDrawValues(false);
        //设置线
        pieDataSet.setValueLinePart1Length(1);
        pieDataSet.setValueLinePart2Length(1);
        pieDataSet.setYValuePosition(OUTSIDE_SLICE);
        pieDataSet.setXValuePosition(OUTSIDE_SLICE);


        //设置内圈消失
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);

        piechat.setData(pieData);
        piechat.setHoleRadius(0);
        piechat.setTransparentCircleRadius(0);
        piechat.setEntryLabelColor(getResources().getColor(R.color.red_marker));
        piechat.setRotationEnabled(false);
        //取消描述
        Description description = new Description();
        description.setText("");
        piechat.setDescription(description);

        //设置图例位置
        piechat.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        piechat.setExtraOffsets(20,20,20,20);
        piechat.setCenterTextColor(getResources().getColor(R.color.blue_marker));
//        piechat.setScrollbarFadingEnabled(false);
        //更新视图
        piechat.postInvalidate();
        //点击事件
        piechat.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Toast.makeText(_mActivity, "e"+e.toString()+"h"+h.toString(), Toast.LENGTH_SHORT).show();
                Log.e("piechart click", "onValueSelected: "+"e>>"+e.toString()+"h>>"+h.toString());
                piechat.clear();
                initData2();
//                PieDataSet pieDataSet = new PieDataSet(pieEntries, "label2222");
//                PieData pieData1 = new PieData();
//                pieData1.setDataSet(pieDataSet);
//                piechat.setData(pieData1);

                piechat.notifyDataSetChanged();
                piechat.invalidate();

            }

            @Override
            public void onNothingSelected() {

            }
        });




    }


}
