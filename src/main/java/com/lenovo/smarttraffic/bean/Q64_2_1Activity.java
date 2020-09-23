package com.lenovo.smarttraffic.bean;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.BaseActivity;
import com.lenovo.smarttraffic.ui.adapter.Q64_2Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q64_2_1Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.rv_yue)
    RecyclerView rvYue;

    @Override
    protected int getLayout() {
        return R.layout.activity_q64_2_1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initToolBar(toolbar, true, "ETC余额");
        Log.e("sss", "onCreate: >>>>"+ Datas.beans );
        rvYue.setLayoutManager(new LinearLayoutManager(this));
        rvYue.setAdapter(new Q64_2Adapter(Datas.beans, this));
    }


}
