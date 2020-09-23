package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.fragment.FirstFragment;
import com.lenovo.smarttraffic.ui.fragment.QuestionsFragment21to1;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class Question21To1Activity extends BaseActivity {
    @BindView(R.id.toolbar)
  public   Toolbar toolbar;

    @BindView(R.id.frameContent)
    public  FrameLayout frameContent;

    @Override
    protected int getLayout() {
        return R.layout.activity_item11;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        setFragmentAnimator(new FragmentAnimator());
        initToolBar(toolbar,true,"title");
        loadRootFragment(R.id.frameContent, new QuestionsFragment21to1());
    }

    @Override
    public void onBackPressedSupport() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            pop();
        }else{
            finish();
        }
    }
}
