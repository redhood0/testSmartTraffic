package com.lenovo.smarttraffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.adapter.MyGridViewDapater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class Q4Activity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.tv_vedio)
    TextView tvVedio;
    @BindView(R.id.tv_img)
    TextView tvImg;
    @BindView(R.id.gv_things)
    GridView gvThings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar,true,"车辆违章");

        initAction();
        tvVedio.callOnClick();
    }

    private void initAction() {
        tvVedio.setOnClickListener( v ->{
            toogleChange((TextView)v);
        });

        tvImg.setOnClickListener( v ->{
            toogleChange((TextView)v);
        });
    }

    void toogleChange(TextView tv){
        if(tv.getId() == R.id.tv_vedio){
            tvImg.setBackgroundDrawable(getResources().getDrawable(R.drawable.tv_bg));
            tvVedio.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_unselected));
            setVedioData();
        }else {
            tvVedio.setBackgroundDrawable(getResources().getDrawable(R.drawable.tv_bg));
            tvImg.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_unselected));
            setImgData();
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_q4;
    }

    void setVedioData(){
        String[] vedioArray = {"视频1","视频2","视频3","视频4","视频5"};
        List<String> vedios = new ArrayList<>(Arrays.asList(vedioArray));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.item_q4_gv,R.id.tv_q4,vedios);
        gvThings.setAdapter(arrayAdapter);

        gvThings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(Q4Activity.this,VedioActivity.class));
            }
        });
    }

    void setImgData(){
        Integer[] imgs = {R.mipmap.weizhang01,R.mipmap.weizhang02,R.mipmap.weizhang03,R.mipmap.weizhang04};
        MyGridViewDapater md = new MyGridViewDapater( new ArrayList<>(Arrays.asList(imgs)),this);
        gvThings.setAdapter(md);

        gvThings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent =  new Intent(Q4Activity.this,ImageActivity.class);
                intent.putExtra("imgId",imgs[position]);
                startActivity(intent);
            }
        });
    }
}
