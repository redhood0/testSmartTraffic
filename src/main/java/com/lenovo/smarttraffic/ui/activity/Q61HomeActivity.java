package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.fragment.FirstFragment;
import com.lenovo.smarttraffic.ui.fragment.Q61Fragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.anim.DefaultNoAnimator;

public class Q61HomeActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.fl_home)
    FrameLayout flHome;

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_q61_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar,true,"天气信息");

        loadRootFragment(R.id.fl_home,new Q61Fragment());
        //全局改变Fragment的动画
//        setFragmentAnimator(new DefaultNoAnimator());



        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);


    }

    @Override
    public void onBackPressedSupport() {

        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            pop();
        }else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
