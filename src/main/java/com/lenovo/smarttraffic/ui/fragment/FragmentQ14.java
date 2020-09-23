package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.EasyVpAdapter;
import com.lenovo.smarttraffic.ui.adapter.Q19VpAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ14 extends SupportFragment {
    @BindView(R.id.tv_now_tmp)
    TextView tvNowTmp;
    @BindView(R.id.btn_refresh)
    ImageView btnRefresh;
    @BindView(R.id.tv_now_uptodown)
    TextView tvNowUptodown;
    @BindView(R.id.linechart)
    LineChart linechart;
    @BindView(R.id.tv_jinri)
    TextView tvJinri;
    @BindView(R.id.sun1)
    ImageView sun1;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.tv_num1)
    TextView tvNum1;
    @BindView(R.id.tv_desc1)
    TextView tvDesc1;
    @BindView(R.id.cl1)
    ConstraintLayout cl1;
    @BindView(R.id.sun2)
    ImageView sun2;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.tv_num2)
    TextView tvNum2;
    @BindView(R.id.tv_desc2)
    TextView tvDesc2;
    @BindView(R.id.cl2)
    ConstraintLayout cl2;
    @BindView(R.id.sun3)
    ImageView sun3;
    @BindView(R.id.tv_title3)
    TextView tvTitle3;
    @BindView(R.id.tv_num3)
    TextView tvNum3;
    @BindView(R.id.tv_desc3)
    TextView tvDesc3;
    @BindView(R.id.cl3)
    ConstraintLayout cl3;
    @BindView(R.id.sun4)
    ImageView sun4;
    @BindView(R.id.tv_title4)
    TextView tvTitle4;
    @BindView(R.id.tv_num4)
    TextView tvNum4;
    @BindView(R.id.tv_desc4)
    TextView tvDesc4;
    @BindView(R.id.cl4)
    ConstraintLayout cl4;
    @BindView(R.id.sun5)
    ImageView sun5;
    @BindView(R.id.tv_title5)
    TextView tvTitle5;
    @BindView(R.id.tv_num5)
    TextView tvNum5;
    @BindView(R.id.tv_desc5)
    TextView tvDesc5;
    @BindView(R.id.cl5)
    ConstraintLayout cl5;
    @BindView(R.id.ll_zhishu)
    LinearLayout llZhishu;
    @BindView(R.id.tv_zhengdian)
    TextView tvZhengdian;
    Unbinder unbinder;

    List<String> tmpsWhite = new ArrayList<>();
    List<String> tmpNight = new ArrayList<>();
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tabs)
    TabLayout tabs;
    List<Entry> entries;
    List<Entry> entries2;
    LineDataSet lineDataSet;
    LineDataSet lineDataSet2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q14, container, false);
        unbinder = ButterKnife.bind(this, v);
        createTmpData();

        initView();

        initAction();

        return v;
    }

    private void initAction() {
        btnRefresh.setOnClickListener(v ->{
            Log.e("ssss", "btnRefresh:》》》》》》》》》》》》 ");
            for (int i = 0; i < 6; i++) {
                tmpsWhite.set(i,String.valueOf((int) (Math.random() * 10 + 20)));
                tmpNight.set(i,String.valueOf((int) (Math.random() * 4 + 6)));
            }
            Log.e("ssss", "btnRefresh:》》》》》》》》》》》》 "+tmpNight);

            for (int i = 0; i < 6; i++) {
                entries.set(i,new Entry(i, Integer.parseInt(tmpsWhite.get(i))));
                entries2.set(i,new Entry(i, Integer.parseInt(tmpNight.get(i))));
            }
            lineDataSet = new LineDataSet(entries, "白天");
            lineDataSet2 = new LineDataSet(entries2, "晚上");

//            lineDataSet.setColor(Color.WHITE);
//            lineDataSet.setLineWidth(2);

//            LineData lineData = new LineData();
//            linechart.setData(lineData);
//            linechart.setBackgroundColor(Color.BLUE);

            linechart.post(new Runnable() {
                @Override
                public void run() {
                    linechart.notifyDataSetChanged();
                    linechart.invalidate();

                }
            });


        });
    }

    private void initView() {
        tvNowTmp.setText("19°");
        tvNowUptodown.setText("今天：" + tmpsWhite.get(0) + "-" + tmpNight.get(0) + "°");
        //初始化左边表格
        entries = new ArrayList<>();
        entries2 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            entries.add(new Entry(i, Integer.parseInt(tmpsWhite.get(i))));
            entries2.add(new Entry(i, Integer.parseInt(tmpNight.get(i))));
        }

        String[] labs = new String[]{"白天", "晚上"};
        lineDataSet = new LineDataSet(entries, "白天");
        lineDataSet2 = new LineDataSet(entries2, "晚上");

        lineDataSet.setColor(Color.WHITE);
        lineDataSet.setLineWidth(2);

        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);
        lineData.addDataSet(lineDataSet2);
        linechart.setData(lineData);
        linechart.setBackgroundColor(Color.BLUE);

        //动态加载vp
        String[] strings = new String[]{"111","222"};
        ArrayList<String> titles = new ArrayList<>();
        titles.add("111");
        titles.add("2222");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentQ15p1());
        fragments.add(new Q15P2Fragment());
        Q19VpAdapter adapter = new Q19VpAdapter(getChildFragmentManager(),titles,fragments);
        vp.setAdapter(adapter);

        tabs.setupWithViewPager(vp);

    }

    private void createTmpData() {
        for (int i = 0; i < 6; i++) {
            tmpsWhite.add(String.valueOf((int) (Math.random() * 10 + 20)));
            tmpNight.add(String.valueOf((int) (Math.random() * 4 + 6)));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
