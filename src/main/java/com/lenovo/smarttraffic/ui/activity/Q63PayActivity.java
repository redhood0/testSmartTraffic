package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.util.CreateQRBitpam;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q63PayActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.tv_changan)
    TextView tvChangan;
    @BindView(R.id.iv)
    ImageView iv;

    Timer timer;

    @Override
    protected int getLayout() {
        return R.layout.activity_q63_pay;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initToolBar(toolbar,true,"支付界面");

//        iv.setImageDrawable(new );

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Glide.with(Q63PayActivity.this)
                                        .load(CreateQRBitpam.CreateQRBitMap("金额：200"+new Date().toString(),400,400))
                                        .into(iv);
                            } catch (WriterException e) {
                                e.printStackTrace();
                            }
                        }
                    });
            }
        },0,3000);

        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tvChangan.setText("金额：100元，地点：圆明园");
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
