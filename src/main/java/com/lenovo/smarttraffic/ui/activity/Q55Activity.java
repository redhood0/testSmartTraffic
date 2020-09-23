package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.Q55PagerAdapter;
import com.lenovo.smarttraffic.ui.fragment.Q55Fragment1;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q55Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_num1)
    TextView tvNum1;
    @BindView(R.id.tv_num2)
    TextView tvNum2;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected int getLayout() {
        return R.layout.activity_q55_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initToolBar(toolbar,true,"1号站台");
        initView();

        initAction();
    }

    private void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Q55Fragment1());
        fragments.add(new Q55Fragment1());
        Q55PagerAdapter pagerAdapter = new Q55PagerAdapter(getSupportFragmentManager(),fragments);
        vp.setAdapter(pagerAdapter);

        TextView[] textViews = {tvNum1,tvNum2};
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("sss", "onPageScrolled: " + position  +"---" + positionOffset);

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("sss", "onPageSelected: " + position );
                for(TextView tv : textViews){
                    tv.setBackgroundColor(Color.WHITE);
                }
                textViews[position].setBackgroundColor(Color.BLUE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("sss", "onPageScrollStateChanged: " + state );

            }
        });


    }

    private void initAction() {
        tvNum1.setOnClickListener(v -> {
            vp.setCurrentItem(0,true);
            tvNum1.setBackgroundColor(Color.BLUE);
            tvNum2.setBackgroundColor(Color.WHITE);
            toolbar.setTitle("1号站台");
        });
        tvNum2.setOnClickListener(v -> {
            vp.setCurrentItem(1,true);
            tvNum2.setBackgroundColor(Color.BLUE);
            tvNum1.setBackgroundColor(Color.WHITE);
            toolbar.setTitle("2号站台");
        });
    }
}
