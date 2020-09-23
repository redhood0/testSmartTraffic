package com.lenovo.smarttraffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q63Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_buy)
    Button btnBuy;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_title1)
    TextView tvTitle1;
    @BindView(R.id.btn_buy1)
    Button btnBuy1;
    @BindView(R.id.tv_money1)
    TextView tvMoney1;
    @BindView(R.id.tv_title2)
    TextView tvTitle2;
    @BindView(R.id.btn_buy2)
    Button btnBuy2;
    @BindView(R.id.tv_money2)
    TextView tvMoney2;
    @BindView(R.id.tv_title3)
    TextView tvTitle3;
    @BindView(R.id.btn_buy3)
    Button btnBuy3;
    @BindView(R.id.tv_money3)
    TextView tvMoney3;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;

    @Override
    protected int getLayout() {
        return R.layout.activity_q63_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

        initToolBar(toolbar, true, "旅行助手");
        ButterKnife.bind(this);

        initAction();
    }

    private void initAction() {
        iv.setOnClickListener(new MyImageviewListener());
        iv1.setOnClickListener(new MyImageviewListener());
        iv2.setOnClickListener(new MyImageviewListener());
        iv3.setOnClickListener(new MyImageviewListener());

        btnBuy.setOnClickListener(new MyTextViewListener());
        btnBuy1.setOnClickListener(new MyTextViewListener());
        btnBuy2.setOnClickListener(new MyTextViewListener());
        btnBuy3.setOnClickListener(new MyTextViewListener());
    }

    class MyTextViewListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent integer = new Intent(Q63Activity.this,Q63ShopCartActivity.class);
            startActivity(integer);
        }
    }

    class MyImageviewListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent integer = new Intent(Q63Activity.this,Q63DetailActivity.class);
            startActivity(integer);
        }
    }
}
