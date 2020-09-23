package com.lenovo.smarttraffic.ui.zujian;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarView;
import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CalenDarTest1 extends DialogFragment {
    @BindView(R.id.calandar)
    CalendarView calandar;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_rili, container, false);
        unbinder = ButterKnife.bind(this, v);
        getDialog().requestWindowFeature(STYLE_NO_TITLE);

        calandar.setSelectRangeMode();
        calandar.setOnCalendarRangeSelectListener(new CalendarView.OnCalendarRangeSelectListener() {
            @Override
            public void onCalendarSelectOutOfRange(Calendar calendar) {

            }

            @Override
            public void onSelectOutOfRange(Calendar calendar, boolean isOutOfMinRange) {

            }

            @Override
            public void onCalendarRangeSelect(Calendar calendar, boolean isEnd) {

            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
