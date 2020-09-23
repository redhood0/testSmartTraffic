package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Switch;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q8Activity extends BaseActivity implements CalendarCallBack{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_cars)
    TextView tvCars;
    @BindView(R.id.sw_1)
    Switch sw1;
    @BindView(R.id.sw_2)
    Switch sw2;
    @BindView(R.id.sw_3)
    Switch sw3;
    @BindView(R.id.tv_cars_num)
    TextView tv_cars_num;

    @Override
    protected int getLayout() {
        return R.layout.activity_q8;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        initview();
        initAction();
    }

    private void initview() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd");
        String dateStr = simpleDateFormat.format(date);
        String day = simpleDateFormat2.format(date);
        tvDate.setText(dateStr);

        setCar(Integer.parseInt(day));



    }

    private void initAction() {
        sw1.setOnClickListener(v -> {
            checkSwitch();
        });

        sw2.setOnClickListener(v -> {
            checkSwitch();
        });

        sw3.setOnClickListener(v -> {
            checkSwitch();
        });
        tvDate.setOnClickListener(v ->{
            MyDateDialog my = new MyDateDialog();
            my.setCalendarCallBack(this);
            my.show(getFragmentManager(),"date");
//            my.setCallBack(this);
        });

    }

    private void setCar(int day){
        if(day%2 == 0){
            sw1.setChecked(false);
            sw1.setEnabled(false);
            sw3.setChecked(false);
            sw3.setEnabled(false);
            sw2.setChecked(true);
            sw2.setEnabled(true);
            tvCars.setText("双号出行车辆:");
        }else {
            sw1.setChecked(true);
            sw1.setEnabled(true);
            sw3.setChecked(true);
            sw3.setEnabled(true);
            sw2.setChecked(false);
            sw2.setEnabled(false);
            tvCars.setText("单号出行车辆:");
        }

        checkSwitch();
    }

    private void checkSwitch(){
        String x = "";

        if(sw1.isChecked()){
            x += "1";
        }

        if(sw2.isChecked()){
            x += "2";
        }

        if(sw3.isChecked()){
            if(x.length()==1){
                x += "、";
            }
            x += "3";
        }
        tv_cars_num.setText(x);

    }


    @Override
    public void dosomething(String date) {
        tvDate.setText(date);
        Log.e("sss", "date: "+date );
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd");
//        String day = simpleDateFormat2.format(date);
        String zhengze = "(\\d{1,2}月)";
        Pattern p = Pattern.compile(zhengze);
        Matcher m = p.matcher(date);
        m.find();
        Log.e("sss", "dosomething: "+m.group(0) );
//        setCar(Integer.parseInt(m.group(0)));
    }
}
