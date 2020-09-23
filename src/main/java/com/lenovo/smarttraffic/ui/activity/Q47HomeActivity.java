package com.lenovo.smarttraffic.ui.activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.ui.fragment.Q47FragmentExpanda;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q47HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fm)
    FrameLayout fm;
    @BindView(R.id.iv_rq)
    ImageView ivRq;
    @BindView(R.id.tv_myorder)
    TextView tvMyorder;
    public GetBusInfoBean bean;

    @Override
    protected int getLayout() {
        return R.layout.activity_q47home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initToolBar(toolbar, true, "定制班车");
        loadRootFragment(R.id.fm, new Q47FragmentExpanda());

        ivRq.setOnClickListener(v ->{
            DialogFragment dialogFragment = new QRDialog();
            dialogFragment.show(getSupportFragmentManager(),"a");
        });

    }

    @Override
    public void onBackPressedSupport() {
//        Log.e("sss", "onBackPressedSupport: "+getSupportFragmentManager().getBackStackEntryCount());
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            finish();
        }


    }
}
