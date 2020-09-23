package com.lenovo.smarttraffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q64_2_1Activity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q64Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.sound1)
    ImageView sound1;
    @BindView(R.id.sound2)
    ImageView sound2;
    @BindView(R.id.iv_zhongchi)
    ImageView ivZhongchi;
    @BindView(R.id.iv_yue)
    ImageView ivYue;
    @BindView(R.id.iv_jilu)
    ImageView ivJilu;

    Timer t;

    @Override
    protected int getLayout() {
        return R.layout.activity_q64;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        t = new Timer();
        initView();
    }

    private void initView() {
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() ->{
                    if(sound1.getVisibility() == View.GONE){
                        sound1.setVisibility(View.VISIBLE);
                        sound2.setVisibility(View.GONE);
                    }else {
                        sound2.setVisibility(View.VISIBLE);
                        sound1.setVisibility(View.GONE);
                    }

                });
            }
        },0,1000);


        ivZhongchi.setOnClickListener(v ->{
            Intent intent = new Intent(this,Q64ChongzhiAcctivity2.class);
            startActivity(intent);
        });

        ivYue.setOnClickListener(v ->{
            Intent intent = new Intent(this, Q64_2_1Activity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.cancel();
    }
}
