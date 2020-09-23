package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.lenovo.smarttraffic.R;

import butterknife.BindView;

public class Q51Activity extends BaseActivity {
    //    @BindView(R.id.map)
    MapView map;
    @BindView(R.id.change1)
    Button change1;
    @BindView(R.id.change2)
    Button change2;
    @BindView(R.id.change3)
    Button change3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        map = findViewById(R.id.map);
        map.onCreate(savedInstanceState);
        AMap amap = map.getMap();

        amap.setMapType(AMap.MAP_TYPE_NIGHT);

        MarkerOptions markeroptions = new MarkerOptions();
        LatLng latLng = new LatLng(39.956475258915894, 116.39450514871629);
        markeroptions.position(latLng);
        markeroptions.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.marker_thrid)));
        markeroptions.title("1111aA");
        markeroptions.snippet("内容111");
        Marker marker = amap.addMarker(markeroptions);



//        map.onCreate(savedInstanceState);
//        AMap aMap = map.getMap();
////        (39.956475258915894,116.39450514871629)
////        (39.87701305616043,116.38958061304919)
////        (39.923655677912436,116.26911858493763)
////        (39.909564897668616,116.51345038765587)
//        LatLng latLng = new LatLng(39.956475258915894, 116.39450514871629);
//        MarkerOptions mo = new MarkerOptions();
//        mo.position(latLng);
//        mo.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.marker_thrid)));
//        Marker marker = aMap.addMarker(mo);
//
//        aMap.setOnMapClickListener(new AMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                Log.e("xxx", "onMapClick: " + latLng.toString());
//            }
//        });
//
//        change1.setOnClickListener(v -> {
//            aMap.setMapType(AMap.MAP_TYPE_NAVI);
//        });
//        change2.setOnClickListener(v -> {
//            aMap.setMapType(AMap.MAP_TYPE_NIGHT);
//        });
//        change3.setOnClickListener(v -> {
//            aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
//        });
//
////        aMap.setOnMapClickListener();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_q51;
    }
}
