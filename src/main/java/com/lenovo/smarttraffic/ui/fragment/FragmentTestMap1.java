package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentTestMap1 extends Fragment {
    @BindView(R.id.map)
    MapView map;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.item_test_map1, container, false);

        unbinder = ButterKnife.bind(this, v);

        map.onCreate(savedInstanceState);//必须写
        AMap aMap = map.getMap();
        aMap.setTrafficEnabled(true);

        LatLng l = new LatLng(1,1);

        MarkerOptions markerOption = new MarkerOptions();
        markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.marker_one)));
        Marker marker = aMap.addMarker(new MarkerOptions().position(l).title("北京").snippet("xxx"));



        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
