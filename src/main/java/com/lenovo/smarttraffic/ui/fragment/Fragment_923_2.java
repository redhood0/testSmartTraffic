package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment_923_2 extends SupportFragment {
    Unbinder u;

    @BindView(R.id.map)
    MapView mapView;
    AMap aMap;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_923_2,container,false);
        u=  ButterKnife.bind(this,v);
        initView(savedInstanceState);
        return v;
    }

    private void initView( Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);

//
//        if(aMap == null){
//            aMap = mapView.getMap();
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        u.unbind();

    }
}
