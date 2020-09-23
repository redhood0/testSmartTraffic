package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q54User;
import com.lenovo.smarttraffic.ui.adapter.Q54RvAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q54Fragment extends SupportFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q54, container, false);
        unbinder = ButterKnife.bind(this, v);
        initView();

        return v;
    }

    private void initView() {
        List<Q54User> q54Users = new ArrayList<>();
        q54Users.add(new Q54User());
        q54Users.add(new Q54User());
        q54Users.add(new Q54User());
        Q54RvAdapter q54RvAdapter = new Q54RvAdapter(q54Users,getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(q54RvAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
