package com.lenovo.smarttraffic.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q63DetailActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @Override
    protected int getLayout() {
        return R.layout.activity_q63_detial;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolBar(toolbar,true,"详细信息");
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        tvPhone.setOnClickListener(v ->{
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"010-88888888"));
            startActivity(intent);
        });
    }
}
