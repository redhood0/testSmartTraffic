package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.BasePagerAdapter;
import com.lenovo.smarttraffic.ui.adapter.ChartsAdapter;
import com.lenovo.smarttraffic.ui.fragment.DesignFragment;
import com.lenovo.smarttraffic.ui.fragment.FirstFragment;
import com.lenovo.smarttraffic.ui.fragment.SecondFragment;
import com.lenovo.smarttraffic.ui.fragment.TestChart1Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class CartTestActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar,true,"testChart");

        initViewPager();
    }

    private void initViewPager(){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new TestChart1Fragment());
        fragments.add(new SecondFragment());
        fragments.add(DesignFragment.getInstance());
        ChartsAdapter ca = new ChartsAdapter(fragments,getSupportFragmentManager());
        vp.setAdapter(ca);
        vp.setCurrentItem(0);
//
//        BasePagerAdapter basePagerAdapter = new BasePagerAdapter(getSupportFragmentManager());
//        vp.setAdapter(basePagerAdapter);
//        vp.setOffscreenPageLimit(2);


    }

    @Override
    protected int getLayout() {
        return R.layout.activity_chart_q7;
    }
}
