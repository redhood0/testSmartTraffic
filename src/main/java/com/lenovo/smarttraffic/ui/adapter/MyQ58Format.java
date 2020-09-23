package com.lenovo.smarttraffic.ui.adapter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class MyQ58Format implements IAxisValueFormatter {
    String[] strings = {"0","学院路", "联想路", "医院路", "幸福路", "aa路", "bb路"};

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        int position = (int)value;
        return strings[position];
//        switch ( (int)value) {
//            case 0:
//
//                return "0";
//            case 1:
//
//                return strings[0];
//            case 2:
//
//                return strings[1];
//            case 3:
//
//                return strings[2];
//            case 4:
//
//                return strings[3];
//            case 5:
//
//                return strings[4];
//            case 6:
//
//                return strings[5];
//        }
//        return null;
    }
}
