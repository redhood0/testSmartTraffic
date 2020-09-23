package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;
import com.lenovo.smarttraffic.ui.adapter.Q26VpAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q26FragmentHome extends SupportFragment {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q26_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        Item11Activity i = (Item11Activity) getActivity();
        i.initToolBar(i.getToolbar(), true, "数据分析");

        tabs.setupWithViewPager(vp);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("有无重复违章记录");
        titles.add("违章记录占比分布");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Q26FragmentPieChart());
        fragments.add(new Q26FragmentBarChart());
        vp.setAdapter(new Q26VpAdapter(getChildFragmentManager(),fragments,titles));



        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
