package com.lenovo.smarttraffic.ui.zujian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.RangeMonthView;

public class RangeMonthView1 extends RangeMonthView {

    public RangeMonthView1(Context context) {
        super(context);
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelectedPre, boolean isSelectedNext) {
        Paint paint  = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(x,y,x+mItemWidth,y+mItemHeight,paint);
        return false;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y, boolean isSelected) {

    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(30);

        int centerx = x + mItemWidth/2;
        Log.e("SSSS", "onDrawText: "+y+">>>>>>"+mTextBaseLine );


        canvas.drawText(calendar.getDay()+"",centerx,y+mTextBaseLine,calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);
    }
}
