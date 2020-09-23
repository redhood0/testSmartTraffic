package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q17Bean;
import com.lenovo.smarttraffic.ui.adapter.Q17Adapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q17Fragment extends SupportFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q17, container, false);
        unbinder = ButterKnife.bind(this, v);
        rv.setLayoutManager(new GridLayoutManager(getContext(),3));
        ArrayList<String> datas = new ArrayList<>();
        datas.add("11");
        datas.add("11");
        datas.add("11");
        datas.add("11");
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.item_just_text,R.id.tv,datas);

        List<Q17Bean> q17BeanList = new ArrayList<>();
        q17BeanList.add(new Q17Bean());
        q17BeanList.add(new Q17Bean());
        q17BeanList.add(new Q17Bean());
        q17BeanList.add(new Q17Bean());
        q17BeanList.add(new Q17Bean());
        Q17Adapter adapter =new Q17Adapter();
        adapter.data = q17BeanList;

        rv.setAdapter(adapter);
        rv.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.HORIZONTAL));
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
