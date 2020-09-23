package com.lenovo.smarttraffic.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.util.CommonUtil;

import java.util.List;

public class ChartsAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    String[] titles;
    public ChartsAdapter(List<Fragment> fragmentList, FragmentManager fm) {
        super(fm);
        this.fragmentList = fragmentList;
        titles = CommonUtil.getStringArray(R.array.tab_names4chart);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
