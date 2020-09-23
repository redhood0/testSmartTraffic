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
import com.lenovo.smarttraffic.ui.adapter.Q22RvAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q22Fragment extends SupportFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q22, container, false);
        unbinder = ButterKnife.bind(this, v);


        Q22RvAdapter q22RvAdapter = new Q22RvAdapter();

        ArrayList<String> strings = new ArrayList<>();
        strings.add("100");
        strings.add("200");
        strings.add("50");
        strings.add("100");
        q22RvAdapter.fragment = this;
        q22RvAdapter.yues = strings;
        rv.setAdapter(q22RvAdapter);
        rv.setSaveEnabled(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
