package com.lenovo.smarttraffic.ui.adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.lenovo.smarttraffic.bean.Q5GreenBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TimeValueFormat  implements IAxisValueFormatter {
    List<Q5GreenBean> q5s;
    public TimeValueFormat(List<Q5GreenBean> q5s) {
        this.q5s = q5s;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        int position = (int) value ;
        if(position > q5s.size() || position < 1){
            return "";
        }
        Date data = q5s.get(position-1).getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        String result  = sdf.format(data);

        return result;
    }
}
