package com.lenovo.smarttraffic.ui.fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.CalendarCallBack;
import com.lenovo.smarttraffic.ui.activity.DialogQ11;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;
import com.lenovo.smarttraffic.ui.activity.MyDateDialog;
import com.lenovo.smarttraffic.ui.adapter.MyQ58Format;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q58Fragment extends SupportFragment implements CalendarCallBack {

    @BindView(R.id.iv_calendar)
    ImageView ivCalendar;
    @BindView(R.id.tv_from)
    TextView tvFrom;
    @BindView(R.id.tv_to)
    TextView tvTo;
    @BindView(R.id.linechart)
    LineChart linechart;
    Unbinder unbinder;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q58, container, false);

        unbinder = ButterKnife.bind(this, v);
        Item11Activity item11Activity = (Item11Activity) getActivity();
        item11Activity.initToolBar(item11Activity.getToolbar(), true, "违章分析");

//        OkHttpUtil.doPost("");请求没有，造假数据
        createFakeData();

        initView();

        initAction();
        return v;
    }

    private void initAction() {
        tvFrom.setOnClickListener(v -> {
            openDialog(tvFrom);
        });

        tvTo.setOnClickListener(v -> {
            openDialog(tvTo);
        });

        ivCalendar.setOnClickListener(v ->{
            MyDateDialog dialogQ11 = new MyDateDialog();
            dialogQ11.setCalendarCallBack(this);
            dialogQ11.show(getActivity().getFragmentManager(),"ss");
        });
    }

    private void openDialog(TextView tv ) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText(year + "-" + month + "-" + dayOfMonth);
                    }
                });
            }
        }, 2019, 6, 1);
        datePickerDialog.show();
    }

    private void initView() {
        List<Entry> entries = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            entries.add(new Entry(i, (float) ((int) (Math.random() * 250 + 50))));
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "");
        lineDataSet.setColor(Color.RED);
        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);

        linechart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        linechart.getXAxis().setXOffset(50);
        linechart.getXAxis().setGranularity(1f);
        linechart.getXAxis().setGranularityEnabled(true);
        linechart.getXAxis().setLabelCount(7);
        linechart.getXAxis().setAxisMinimum(0);
        linechart.getXAxis().setAxisMaximum(6);
        linechart.getXAxis().setDrawGridLines(false);
//        linechart.getXAxis().setAvoidFirstLastClipping(true);
        linechart.getXAxis().setValueFormatter(new MyQ58Format());

        // linechart.getXAxis().setValueFormatter();//设置格式

        linechart.getAxisRight().setEnabled(false);
        YAxis yAxis = linechart.getAxisLeft();
        yAxis.setMinWidth(0);
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMinValue(0);
        yAxis.setStartAtZero(true);
        yAxis.setMaxWidth(300);
        yAxis.setMaxWidth(300);
        yAxis.setAxisMaxValue(300);

        yAxis.setLabelCount(6,true);

        linechart.getLegend().setEnabled(false);

        linechart.setData(lineData);

        //初始化日期

    }

    private void createFakeData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //做一个时间处理类，然后计算比例来显示随机的违章数

    private Date doStringToDate(String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = new Date();
        try {
            simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    @Override
    public void dosomething(String date) {

    }
}
