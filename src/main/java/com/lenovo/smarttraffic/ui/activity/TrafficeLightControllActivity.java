package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TrafficLightBean;
import com.lenovo.smarttraffic.bean.TrafficLightSearchBean;
import com.lenovo.smarttraffic.bean.TrafficeLightWithStreet;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrafficeLightControllActivity extends BaseActivity implements MyCallBack {
    final  static int STREETID_1 = 1;
    final  static int STREETID_2 = 2;
    final  static int STREETID_3 = 3;

    List<TrafficeLightWithStreet> result = new ArrayList<>();

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.spinner_lukou)
    Spinner spinnerLukou;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.gv_tflight)
    GridView gvTflight;

    @Override
    protected int getLayout() {
        return R.layout.activity_trafficlightcontroll;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initCompant();
        initAction();

    }

    boolean first = true;

    private void initAction() {

        spinnerLukou.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TrafficeLightControllActivity.this, "" + position, Toast.LENGTH_SHORT).show();
//                if(first){
//                    try {
//                        TimeUnit.SECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    first = false;
//                }
                if(result.size() >= 3){
                    initGridView(position);
                }else {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    spinnerLukou.setSelection(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //开场自动查一次
        searchLight();
    }

    private void initCompant() {
        initToolBar(toolbar, true, "交通管理");

        List<String> spinnerItems = new ArrayList<>();
        spinnerItems.add("路口升序");
        spinnerItems.add("路口降序");
        spinnerItems.add("红灯升序");
        spinnerItems.add("红灯降序");
        spinnerItems.add("绿灯升序");
        spinnerItems.add("绿灯降序");
        spinnerItems.add("黄灯升序");
        spinnerItems.add("黄灯降序");
        SpinnerAdapter sa = new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.tv_spinner, spinnerItems);
        spinnerLukou.setAdapter(sa);

    }

    private void searchLight(){
//        Log.e("ss", "searchLight: >>" );
        //网络请求,1,2,3路口

        for(int i = 1 ; i <= 3; i++ ){
            TrafficLightSearchBean tb = new TrafficLightSearchBean(Integer.toString(i),"user1");
            OkHttpUtil.doPost("GetTrafficLightConfigAction.do",tb, TrafficLightBean.class,this,i);
        }

        //loading

        //
    }

    private boolean flag = true;
    @Override
    public void sendResult(Object t, int typeId) {
        TrafficLightBean tl = (TrafficLightBean) t;
        switch (typeId){
            case 1:
                TrafficeLightWithStreet tlw1 = new TrafficeLightWithStreet(tl,1);
                result.add(tlw1);
                break;
            case 2:
                TrafficeLightWithStreet tlw2 = new TrafficeLightWithStreet(tl,2);
                result.add(tlw2);
                break;
            case 3:
                TrafficeLightWithStreet tlw3 = new TrafficeLightWithStreet(tl,3);
                result.add(tlw3);
                break;
        }

        if(result.size() >= 3 && flag ){
            initGridView(0);
            flag = false;
        }
    }

    private void initGridView(int position){

        List<String> list = new ArrayList<>();
        list.add("路口");
        list.add("红灯时常（s）");
        list.add("绿灯时常（s）");
        list.add("黄灯时常（s）");

        //后面进行排序
        switch (position){
            case 0:
                shortTypeOne(list);
                break;
            case 1:
                shortTypeTwo(list);
                break;
            case 2:
                shortTypeOne(list);
                break;
            case 3:
                shortTypeOne(list);
                break;
            case 4:
                shortTypeOne(list);
                break;
            case 5:
                shortTypeOne(list);
                break;
            case 6:
                shortTypeOne(list);
                break;
            case 7:
                shortTypeOne(list);
                break;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.spinner_item,R.id.tv_spinner,list);

        runOnUiThread(() ->{
            gvTflight.setAdapter(arrayAdapter);
        });

    }

    void shortTypeOne(List<String> list){
        Comparator<TrafficeLightWithStreet> comparatorAge =new Comparator <TrafficeLightWithStreet>(){
            public int compare(TrafficeLightWithStreet p1,TrafficeLightWithStreet p2){
                if (p1.getStreetId() > p2.getStreetId())
                    return 1;
                else if (p1.getStreetId() < p2.getStreetId())
                    return -1;
                else
                    return 0;
            }
        };

        Collections.sort(result,comparatorAge);
        for(TrafficeLightWithStreet tl : result){
            list.add(String.valueOf(tl.getStreetId()));
            list.add(String.valueOf(tl.getTl().getRedTime()));
            list.add(String.valueOf(tl.getTl().getGreenTime()));
            list.add(String.valueOf(tl.getTl().getYellowTime()));
            Log.e("sss", "shortTypeOne: "+ tl.getStreetId() );
        }
    }

    void shortTypeTwo(List<String> list){
        Comparator<TrafficeLightWithStreet> comparatorAge = new Comparator<TrafficeLightWithStreet>() {
            @Override
            public int compare(TrafficeLightWithStreet o1, TrafficeLightWithStreet o2) {
                if(o1.getStreetId() < o2.getStreetId()){
                    return 1;
                }else if(o1.getStreetId() > o2.getStreetId()){
                    return -1;
                }else {
                    return 0;
                }
            }
        };

        Collections.sort(result,comparatorAge);
        for(TrafficeLightWithStreet tl : result){
            list.add(String.valueOf(tl.getStreetId()));
            list.add(String.valueOf(tl.getTl().getRedTime()));
            list.add(String.valueOf(tl.getTl().getGreenTime()));
            list.add(String.valueOf(tl.getTl().getYellowTime()));
            Log.e("sss", "shortTypeOne: "+ tl.getStreetId() );
        }
    }
}
