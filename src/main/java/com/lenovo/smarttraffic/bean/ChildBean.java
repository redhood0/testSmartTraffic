package com.lenovo.smarttraffic.bean;

import android.widget.TextView;

import java.util.Comparator;

public class ChildBean implements Comparator<ChildBean>{
    String tv_zhan1_num1;
    String tv_zhan1_people1;
    String tv_zhan1_time1;
    String tv_zhan1_display1;

    public String getTv_zhan1_num1() {
        return tv_zhan1_num1;
    }

    public void setTv_zhan1_num1(String tv_zhan1_num1) {
        this.tv_zhan1_num1 = tv_zhan1_num1;
    }

    public String getTv_zhan1_people1() {
        return tv_zhan1_people1;
    }

    public void setTv_zhan1_people1(String tv_zhan1_people1) {
        this.tv_zhan1_people1 = tv_zhan1_people1;
    }

    public String getTv_zhan1_time1() {
        return tv_zhan1_time1;
    }

    public void setTv_zhan1_time1(String tv_zhan1_time1) {
        this.tv_zhan1_time1 = tv_zhan1_time1;
    }

    public String getTv_zhan1_display1() {
        return tv_zhan1_display1;
    }

    public void setTv_zhan1_display1(String tv_zhan1_display1) {
        this.tv_zhan1_display1 = tv_zhan1_display1;
    }



    @Override
    public int compare(ChildBean o1, ChildBean o2) {
        if(Integer.parseInt(o1.tv_zhan1_display1) > Integer.parseInt(o2.tv_zhan1_display1)){
            return -1;
        }else if(Integer.parseInt(o1.tv_zhan1_display1) < Integer.parseInt(o2.tv_zhan1_display1)){
            return 1;
        }
        return 0;
    }
}
