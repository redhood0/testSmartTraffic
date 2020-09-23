package com.lenovo.smarttraffic.ui.zujian;

import android.content.Context;
import android.graphics.Canvas;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.RangeMonthView;

public class CustomRangeMothView extends RangeMonthView {
    public CustomRangeMothView(Context context) {
        super(context);
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelectedPre, boolean isSelectedNext) {
        //头
        if(isSelectedPre){
            if(isSelectedNext){
                canvas.drawRect(x,y,x+mItemWidth,y+mItemHeight,mSelectedPaint);
            }else {
                canvas.drawRect(x,y,x+mItemWidth/2,y+mItemHeight,mSelectedPaint);
                canvas.drawCircle(x+mItemHeight/2,y+mItemHeight/2,mItemHeight/2,mSelectedPaint);
            }

        }else {
            if(isSelectedNext){
                canvas.drawRect((x+mItemWidth/2),y,x+mItemWidth,y+mItemHeight,mSelectedPaint);
                canvas.drawCircle(x+mItemHeight/2,y+mItemHeight/2,mItemHeight/2,mSelectedPaint);
            }else {
                canvas.drawCircle((x+mItemWidth/2),y+mItemHeight/2,mItemHeight/2,mSelectedPaint);
            }

        }

        //中间

        //尾

        return false;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y, boolean isSelected) {

    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        int t_x = x + mItemWidth/2;
        int t_y = (int) (y + mTextBaseLine);


        canvas.drawText(String.valueOf(calendar.getDay()),t_x,t_y,calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);
    }
}
