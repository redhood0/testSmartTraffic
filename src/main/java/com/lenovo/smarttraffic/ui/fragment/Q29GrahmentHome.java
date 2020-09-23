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
import com.lenovo.smarttraffic.ui.adapter.Q39ViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q29GrahmentHome extends SupportFragment {

    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q29home, container, false);
        unbinder = ButterKnife.bind(this, v);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Q29FragmentChild1());
        fragments.add(new Q29FragmentChild1());
        fragments.add(new Q29FragmentChild1());
        tabs.setupWithViewPager(vp);
        Q39ViewPagerAdapter pagerAdapter = new Q39ViewPagerAdapter(getChildFragmentManager(),fragments);
        vp.setAdapter(pagerAdapter);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
