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
import com.lenovo.smarttraffic.ui.adapter.Q19VpAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q19HomeFragment extends SupportFragment {
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q19_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        tabs.setupWithViewPager(vp);
        ArrayList<String> titles = new ArrayList<>();
        titles.add("平台有违章车辆和没有违章车辆占比统计");
        titles.add("排名前十的交通违法行为占比");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Q19FrgamentP1());
        fragments.add(new Q19FragmentP2());
        Q19VpAdapter adapter = new Q19VpAdapter(getChildFragmentManager(), titles, fragments);
        vp.setAdapter(adapter);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
