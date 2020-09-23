package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q5GreenBean;
import com.lenovo.smarttraffic.greendao.DaoSession;
import com.lenovo.smarttraffic.greendao.Q5GreenBeanDao;
import com.lenovo.smarttraffic.ui.adapter.TimeValueFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TestChart1Fragment extends Fragment {
    private static TestChart1Fragment instance = null;
    @BindView(R.id.lc_1)
    LineChart lc1;
    Unbinder unbinder;
    Timer timer;

//    public static TestChart1Fragment getInstance() {
//        if (instance == null) {
//            instance = new TestChart1Fragment();
//        }
//        return instance;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chart1, container, false);
        timer = new Timer();

        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initChart();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getData();
            }
        }, 0, 3000);

    }

    private void initChart() {
        ArrayList<Entry> values = new ArrayList<Entry>();
//        values.add(new Entry(5, 50));
//        values.add(new Entry(10, 66));
//        values.add(new Entry(15, 120));
//        values.add(new Entry(20, 30));
//        values.add(new Entry(35, 10));
//        values.add(new Entry(40, 110));
//        values.add(new Entry(45, 30));
//        values.add(new Entry(50, 160));
//        values.add(new Entry(100, 30));


        //限制线
//        YAxis leftAxis = lc1.getAxisLeft();
//        LimitLine ll = new LimitLine(140f, "Blood Pressure High");
//        leftAxis.addLimitLine(ll);

//        LineDataSet dataSet = new LineDataSet(values,"OKL");
//        LineData data = new LineData(dataSet);
//        lc1.setData(data);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int n = 100;
//                LineData data = lc1.getData();
//                LineDataSet set = (LineDataSet) data.getDataSetByIndex(0);
//
//                while (true){
//                    n += 5;
//                    data.addEntry(new Entry((float) (n), (float) (Math.random()*100)),0);
//                    Log.e("chart", "run: >>>>"+ n );
//                    lc1.post(() ->{
//                        lc1.notifyDataSetChanged();
//                        lc1.invalidate();
//                        Log.e("chart", "run: >>>>"+ data.getXMax() );
//                        lc1.setVisibleXRangeMaximum(50);
//                        lc1.moveViewToX(data.getXMax() - 5);
//                    });
//
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            }
//        }).start();

//        lc1.animateX(2000);
        lc1.getAxisRight().setEnabled(false);
        lc1.setNoDataText("123456");
        lc1.setScaleEnabled(false);

//        lc1.setData(data);
        XAxis xAxis = lc1.getXAxis();
        xAxis.setTextSize(20);
        YAxis yAxis = lc1.getAxisLeft();
        yAxis.setTextSize(20);
        yAxis.setDrawZeroLine(true);

        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(50);
        yAxis.setGranularity(5);
        yAxis.setLabelCount(10, true); // force 6 labels
//        ArrayList<String> xVals = new ArrayList<String>();
//        xVals.add("1.Q"); xVals.add("2.Q"); xVals.add("3.Q"); xVals.add("4.Q");


        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setLabelRotationAngle(-90);


//        lc1.invalidate();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void getData() {
//        LineData data = lc1.getLineData();
//        if(data == null){
//            data = new LineData();
//        }
        DaoSession daoSession = InitApp.getDaoSession();

        Q5GreenBeanDao q5 = daoSession.getQ5GreenBeanDao();
        List<Q5GreenBean> q5ss = q5.queryBuilder().orderDesc(Q5GreenBeanDao.Properties.Date).limit(10).list();
        Log.e("Q5GreenBean", "get>>>>> " + q5ss);
        List<Entry> entries = new ArrayList<>();
        Collections.reverse(q5ss);
        int n = 0;
        for (Q5GreenBean q5GreenBean : q5ss) {
            entries.add(new Entry(n++, q5GreenBean.getWendu()));
        }
//         lc1.getLineData();
        LineDataSet dataSet = new LineDataSet(entries, "OKL");
        LineData data = new LineData(dataSet);
        if(lc1 == null){
            return;
        }
        lc1.setData(data);
        XAxis xAxis = lc1.getXAxis();
        xAxis.setLabelCount(9);
        xAxis.setValueFormatter(new TimeValueFormat(q5ss));
        xAxis.setLabelRotationAngle(90);
        lc1.post(() -> {
            if(lc1 == null){
                return;
            }
            lc1.invalidate();
        });

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
