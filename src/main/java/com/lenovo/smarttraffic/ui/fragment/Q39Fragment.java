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
import android.widget.TableLayout;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.Q39ViewPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q39Fragment extends SupportFragment {
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    @BindView(R.id.tb)
    TabLayout tb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q39, container, false);
        unbinder = ButterKnife.bind(this, v);
        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new FirstFragment());
        arrayList.add(new FirstFragment());
        arrayList.add(new FirstFragment());
        Q39ViewPagerAdapter q39ViewPagerAdapter = new Q39ViewPagerAdapter(getFragmentManager(), arrayList);
        vp.setAdapter(q39ViewPagerAdapter);
        tb.setupWithViewPager(vp);

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
