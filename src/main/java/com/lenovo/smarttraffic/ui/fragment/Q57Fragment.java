package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.MyQ60GridAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q57Fragment extends SupportFragment {
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.tv_newest)
    TextView tvNewest;
    @BindView(R.id.piechat)
    PieChart piechat;
    @BindView(R.id.gv)
    GridView gv;
    Unbinder unbinder;
    Timer timer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q57, container, false);

        unbinder = ButterKnife.bind(this, v);
        timer = new Timer();

        inintView();
        return v;
    }

    private void inintView() {
        //做假数据，显示piechat
        List<PieEntry> yVals = new ArrayList<>();

        yVals.add(new PieEntry(40,"北京"));
        yVals.add(new PieEntry(15,"天津"));
        yVals.add(new PieEntry(15,"武汉"));
        yVals.add(new PieEntry(15,"上海"));
        yVals.add(new PieEntry(15,"常州"));

        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(getResources().getColor(R.color.red_marker));
        colors.add(getResources().getColor(R.color.blue_marker));
        colors.add(getResources().getColor(R.color.gray));
        colors.add(getResources().getColor(R.color.Orange));
        colors.add(getResources().getColor(R.color.Green));


        PieDataSet pieDataSet = new PieDataSet(yVals,"1");
//        pieDataSet.setValueLinePart1OffsetPercentage(80);
        pieDataSet.setValueLinePart1Length(1);//设置线长度
        pieDataSet.setValueLinePart2Length(1);//设置线长度

        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        pieDataSet.setColors(colors);
        PieData pieData = new PieData();
        pieData.setDataSet(pieDataSet);
        pieData.setDrawValues(false);
        pieData.setValueTextSize(30);
        pieData.setValueTextColor(0xff000000);

        piechat.setData(pieData);
        piechat.setHoleRadius(0);
        piechat.setEntryLabelTextSize(30);

        piechat.setEntryLabelColor(0xff000000);
        piechat.setTransparentCircleRadius(0);

        List<String> gvData = new ArrayList<>();
        gvData.add("生活指数");
        gvData.add("最高");
        gvData.add("最低");
        gvData.add("平均数");
        String[] a = {"pm2.5","co2","湿度","温度","光照"};
        for(int i = 0 ; i < 5 ; i++){
            gvData.add(a[i]);
            gvData.add("20");
            gvData.add("30");
            gvData.add("25");
        }

        ArrayAdapter simpleAdapter = new ArrayAdapter(getContext(),R.layout.iten_simple_gv,R.id.tv_gv,gvData);
        gv.setAdapter(simpleAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
