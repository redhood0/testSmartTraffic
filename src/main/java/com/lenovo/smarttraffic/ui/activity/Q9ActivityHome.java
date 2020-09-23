package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q9Bean;
import com.lenovo.smarttraffic.ui.adapter.Q9Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q9ActivityHome extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_recoder)
    TextView tvRecoder;
    @BindView(R.id.tv_piliang)
    TextView tvPiliang;
    @BindView(R.id.rv)
    RecyclerView rv;
    List<Q9Bean> q9Beans = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_q9;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initToolBar(toolbar, true, "账户管理");
        q9Beans.add(new Q9Bean(1, R.mipmap.baoma, "辽1010101", 100, false));
        q9Beans.add(new Q9Bean(2, R.mipmap.benchi, "辽101013", 0, false));
        q9Beans.add(new Q9Bean(3, R.mipmap.baoma, "辽1010133", 40, false));
        q9Beans.add(new Q9Bean(4, R.mipmap.baoma, "辽1010155", 300, false));


        Q9Adapter adapter = new Q9Adapter();
        adapter.activity = this;

        adapter.q9Beans = q9Beans;
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
