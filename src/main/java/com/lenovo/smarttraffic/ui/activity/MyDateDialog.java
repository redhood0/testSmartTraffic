package com.lenovo.smarttraffic.ui.activity;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendarview.RangeMonthView;
import com.haibin.calendarview.RangeWeekView;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.zujian.CustomRangeMonthView;
import com.lenovo.smarttraffic.ui.zujian.CustomRangeMothView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyDateDialog extends DialogFragment {
    CalendarView calendarView;
    TextView tv_month;
    CalendarCallBack calendarCallBack;
    TimePickerView pvTime;

    public MyDateDialog() {

    }


//    public MyDateDialog(CalendarView calendarView) {
//        this.calendarView = calendarView;
//    }

    public void setCalendarCallBack(CalendarCallBack calendarCallBack){
        this.calendarCallBack = calendarCallBack;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calander, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calendarView = view.findViewById(R.id.calandar);
        tv_month = view.findViewById(R.id.tv_month);
        calendarView.setMonthViewScrollable(true);
        int month =  calendarView.getCurMonth();
        int year =  calendarView.getCurYear();
        tv_month.setText(year+"年"+month+"月");
        calendarView.setOnMonthChangeListener(new CalendarView.OnMonthChangeListener() {
                                                  @Override
                                                  public void onMonthChange(int year, int month) {
                                                      tv_month.setText(year+"年"+month+"月");
                                                  }
                                              }
        );

        calendarView.setSelectRangeMode();
        calendarView.setThemeColor(0x9900ffff,Color.RED);

        calendarView.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
            @Override
            public void onCalendarOutOfRange(Calendar calendar) {

            }

            @Override
            public void onCalendarSelect(Calendar calendar, boolean isClick) {
//                calendarView.select
                Log.e("xxx", "calendarView.setOnCalendarSelectListener: "+calendar.toString());
//                calendar.setSchemeColor(Color.BLUE);
//                calendar.setScheme("Scheme");
//                map.put(calendar.toString(),calendar);
//                calendarView.setSchemeDate(map);
//                calendarView.setTextColor(Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE);
            }
        });

        calendarView.setOnCalendarRangeSelectListener(new CalendarView.OnCalendarRangeSelectListener() {
            @Override
            public void onCalendarSelectOutOfRange(Calendar calendar) {

            }

            @Override
            public void onSelectOutOfRange(Calendar calendar, boolean isOutOfMinRange) {

            }

            @Override
            public void onCalendarRangeSelect(Calendar calendar, boolean isEnd) {
                Log.e("xxx", "onCalendarRangeSelect: "+calendar.toString() + ">>>>>"+isEnd);

                //存住，本地存一个值判断是否是range；

            }
        });


        tv_month.setOnClickListener(v -> {
//            calendarView.setWeekView(RangeWeekView.class);
            calendarView.setMonthView(CustomRangeMothView.class);

            java.util.Calendar selectedDate = java.util.Calendar.getInstance();
            java.util.Calendar startDate = java.util.Calendar.getInstance();
            startDate.set(2000,1,1);
            java.util.Calendar endDate = java.util.Calendar.getInstance();
            endDate.set(2020,1,1);
//
//            //正确设置方式 原因：注意事项有说明
//            startDate.set(2013,0,1);
//            endDate.set(2020,11,31);

            pvTime = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {//选中事件回调
//                    tvTime.setText(getTime(date));
                }
            }).setType(new boolean[]{true, false, false, false, false, false})// 默认全部显示
                    .setCancelText("Cancel")//取消按钮文字
                    .setSubmitText("Sure")//确认按钮文字
    //                .setContentSize(18)//滚轮文字大小

                    .setTitleSize(20)//标题文字大小
                    .setTitleText("Title")//标题文字
                    .setOutSideCancelable(false)//点击屏幕，点在控件外部范围时，是否取消显示
                    .isCyclic(false)//是否循环滚动
                    .setTitleColor(Color.BLACK)//标题文字颜色
                    .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                    .setCancelColor(Color.BLUE)//取消按钮文字颜色
                    .setTitleBgColor(0xFFffffff)//标题背景颜色 Night mode
                    .setBgColor(0xFFffffff)//滚轮背景颜色 Night mode
                    .setTextColorCenter(Color.RED)
                    .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                    .setRangDate(startDate,endDate)//起始终止年月日设定
                    .setLabel("","月","日","时","分","秒")//默认设置为年月日时分秒
                    .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                    .isDialog(true)//是否显示为对话框样式

                    .build();
            pvTime.show();
        });


    }

    @Override
    public void onResume() {
//        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
//        params.width = WindowManager.LayoutParams.MATCH_PARENT;
//        params.height = WindowManager.LayoutParams.MATCH_PARENT;
//        getDialog().getWindow().setAttributes(params);
        super.onResume();
//        getDialog().getWindow().setAttributes();
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }
}
