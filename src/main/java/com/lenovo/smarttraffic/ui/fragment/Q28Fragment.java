package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q28Bean;
import com.lenovo.smarttraffic.ui.adapter.Q28ExpandableAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q28Fragment extends SupportFragment {
    @BindView(R.id.el)
    ExpandableListView el;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q28, container, false);
        unbinder = ButterKnife.bind(this, v);
        Q28ExpandableAdapter q28ExpandableAdapter = new Q28ExpandableAdapter();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("一号公交车  100米");
        arrayList.add("二号公交车  500米");
        q28ExpandableAdapter.q28Beans.add(new Q28Bean("一号站台",arrayList));
        q28ExpandableAdapter.q28Beans.add(new Q28Bean("二号站台",arrayList));
        el.setAdapter(q28ExpandableAdapter);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
