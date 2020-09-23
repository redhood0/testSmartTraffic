package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ChongzhiRecoder;
import com.lenovo.smarttraffic.ui.fragment.Item11BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Item11Activity extends BaseActivity {
    //    @BindView(R.id.q8)
//    Button q8;
//    @BindView(R.id.q9)
//    Button q9;
//    @BindView(R.id.q10)
//    Button q10;
//    @BindView(R.id.q11)
//    Button q11;
//
//    @BindView(R.id.q64)
//    Button q64;
//    @BindView(R.id.q63)
//    Button q63;
//    @BindView(R.id.q62)
//    Button q62;
//    @BindView(R.id.q61)
//    Button q61;
    @BindView(R.id.frameContent)
    FrameLayout frameContent;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
//    @BindView(R.id.frameContent)
//    FrameLayout frameContent;

   public List<ChongzhiRecoder> recoders = new ArrayList<>();

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_item11;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        loadRootFragment(R.id.frameContent, new Item11BaseFragment());


    }

    @Override
    public void onBackPressedSupport() {
//        super.onBackPressedSupport();
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            pop();
        }else {
            finish();
        }
    }
}
