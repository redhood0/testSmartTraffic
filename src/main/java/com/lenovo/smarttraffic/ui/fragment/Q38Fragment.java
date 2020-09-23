package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q38Fragment extends SupportFragment {
    @BindView(R.id.tv_year)
    TextView tvYear;
    @BindView(R.id.calenar)
    CalendarView calenar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_days)
    TextView tvDays;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q38, container, false);

        unbinder = ButterKnife.bind(this, v);

        Item11Activity activity = (Item11Activity) getActivity();
        activity.initToolBar(activity.getToolbar(), false, "定制班车");

        initCarlendar();
        return v;
    }

    List<String> data = new ArrayList<>();

    private void initCarlendar() {
        tvYear.setText(2016 + "年" + 1 + "月");
        calenar.scrollToCalendar(2016, 1, 1);
        calenar.setOnMonthChangeListener(new CalendarView.OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                tvYear.post(new Runnable() {
                    @Override
                    public void run() {
                        tvYear.setText(year + "年" + month + "月");
                    }
                });
                Log.e("sss", "onMonthChange: " + year + "===" + month);
            }
        });

        calenar.setSelectMultiMode();

//        calenar.setOnCalendarSelectListener(new CalendarView.OnCalendarSelectListener() {
//            @Override
//            public void onCalendarOutOfRange(Calendar calendar) {
//
//            }
//
//            @Override
//            public void onCalendarSelect(Calendar calendar, boolean isClick) {
//                Log.e("sssss", "onCalendarSelect: "+calendar.toString() );
//            }
//        });

        calenar.setOnCalendarMultiSelectListener(new CalendarView.OnCalendarMultiSelectListener() {
            @Override
            public void onCalendarMultiSelectOutOfRange(Calendar calendar) {

            }

            @Override
            public void onMultiSelectOutOfSize(Calendar calendar, int maxSize) {
                Log.e("sssss", "onMultiSelectOutOfSize: " + calendar.toString());
            }

            @Override
            public void onCalendarMultiSelect(Calendar calendar, int curSize, int maxSize) {
                if(data.contains(processDate(calendar))){
                    data.remove(processDate(calendar));
                    Log.e("sssss", "remove>>>>>");
                }else {
                    data.add(processDate(calendar));
                    Log.e("sssss", "processDate>>>>>");

                }
                tvDays.post(new Runnable() {
                    @Override
                    public void run() {
                        tvDays.setText(data.toString());
                    }
                });
                Log.e("sssss", "onCalendarSelect: " + calendar.toString() + "--" + curSize + "--" + maxSize);
            }
        });
    }

    private String processDate(Calendar calendar){
        return  calendar.getYear() +"-" +calendar.getMonth() + "-" + calendar.getDay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
