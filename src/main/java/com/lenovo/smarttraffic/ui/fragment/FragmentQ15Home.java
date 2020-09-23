package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.EasyVpAdapter;
import com.lenovo.smarttraffic.ui.adapter.Q19VpAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ15Home extends SupportFragment {
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q15_home, container, false);
        unbinder = ButterKnife.bind(this, v);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentQ15p1());
        fragments.add(new Q15P2Fragment());


        EasyVpAdapter adapter = new EasyVpAdapter(getChildFragmentManager(),fragments);
        vp.setAdapter(adapter);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
