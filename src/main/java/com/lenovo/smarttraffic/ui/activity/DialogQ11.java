package com.lenovo.smarttraffic.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q11BusPeople;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DialogQ11 extends DialogFragment {
    List<Q11BusPeople> peopleLists;
    Context context;
    @BindView(R.id.gv)
    GridView gv;
    Unbinder unbinder;

    void setPeopleLists(List<Q11BusPeople> peopleLists, Context context){
        this.peopleLists = peopleLists;
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_q10_dialog, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //第一次初始化
        List<String> strs = new ArrayList<>();
        strs.add("序号");
        strs.add("公交车编号");
        strs.add("承载人数");
        for(Q11BusPeople people : peopleLists){
            strs.add(String.valueOf(people.getId()));
            strs.add(String.valueOf(people.getId()));
            strs.add(String.valueOf(people.getPeopleNum()));
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(context,R.layout.item_just_text,R.id.tv,strs);
        gv.setAdapter(arrayAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
