package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.fragment.FirstFragment;
import com.lenovo.smarttraffic.ui.fragment.Q45FragmentChongzhi;
import com.lenovo.smarttraffic.ui.fragment.Q45FragmentJiLu;
import com.lenovo.smarttraffic.ui.fragment.Q45FragmentYue;
import com.lenovo.smarttraffic.ui.fragment.Q47FragmentExpanda;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.ISupportFragment;

public class Q45Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_yue)
    TextView tvYue;
    @BindView(R.id.tv_yuancheng)
    TextView tvYuancheng;
    @BindView(R.id.tv_chongzhi)
    TextView tvChongzhi;
    @BindView(R.id.ll_tabs)
    LinearLayout llTabs;
    Q45FragmentYue q45FragmentYue;
    Q45FragmentJiLu q45FragmentJiLu;
    Q45FragmentChongzhi q45FragmentChongzhi;
    @Override
    protected int getLayout() {
        return R.layout.activity_q45_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        initToolBar(toolbar,true,"我的座驾");
        q45FragmentYue =   new Q45FragmentYue();
        loadRootFragment(R.id.fl,q45FragmentYue);
//        loadRootFragment(R.id.fm, new Q47FragmentExpanda());
        before = tvYue;
        switchTab();
    }

    TextView before;
    private void switchTab() {
        tvYue.setOnClickListener(v ->{
            if(before == tvYue){
                return;//no change
            }else {
                before.setTypeface(Typeface.DEFAULT);
                tvYue.setTypeface(Typeface.DEFAULT_BOLD);
//                pop();
                if(q45FragmentYue == null){
                    q45FragmentYue = new Q45FragmentYue();
                }
                q45FragmentYue.start(q45FragmentYue, ISupportFragment.SINGLETASK);
//                getTopFragment();
                before = tvYue;
            }
        });

        tvYuancheng.setOnClickListener(v ->{
            if(before == tvYuancheng){
                return;//no change
            }else {
                before.setTypeface(Typeface.DEFAULT);
                tvYuancheng.setTypeface(Typeface.DEFAULT_BOLD);
                if(q45FragmentChongzhi == null){
                   q45FragmentChongzhi =new Q45FragmentChongzhi();
                }
                q45FragmentYue.start(q45FragmentChongzhi);
                before = tvYuancheng;
            }
        });

        tvChongzhi.setOnClickListener(v ->{
            if(before == tvChongzhi){
                return;//no change
            }else {
                before.setTypeface(Typeface.DEFAULT);
                tvChongzhi.setTypeface(Typeface.DEFAULT_BOLD);
                if(q45FragmentJiLu == null){
                    q45FragmentJiLu = new Q45FragmentJiLu();
                }
//                pop();

                q45FragmentYue.start(q45FragmentJiLu);
                before = tvChongzhi;
            }
        });
    }
}
