package com.lenovo.smarttraffic.ui.activity;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.ChartsAdapter;
import com.lenovo.smarttraffic.ui.fragment.TestChart1Fragment;
import com.lenovo.smarttraffic.ui.fragment.TestChart2Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q6Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.vp)
    ViewPager vp;



    @Override
    protected int getLayout() {
        return R.layout.activity_chart_q7;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initToolBar(toolbar,true,"图表");

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new TestChart1Fragment());
        fragmentList.add(new TestChart2Fragment());
        fragmentList.add(new TestChart1Fragment());
        fragmentList.add(new TestChart1Fragment());
        fragmentList.add(new TestChart1Fragment());
        fragmentList.add(new TestChart1Fragment());

        ChartsAdapter ca = new ChartsAdapter(fragmentList,getSupportFragmentManager());
        vp.setAdapter(ca);

    }
}
