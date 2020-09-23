package com.lenovo.smarttraffic.ui.zujian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.MultiMonthView;

public class CustomMutilpMothView extends MultiMonthView {
    public CustomMutilpMothView(Context context) {
        super(context);
    }

    @Override
    protected boolean onDrawSelected(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelectedPre, boolean isSelectedNext) {

        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawRect(x, y, x + mItemWidth, y + mItemHeight, paint);

        return false;
    }

    @Override
    protected void onDrawScheme(Canvas canvas, Calendar calendar, int x, int y, boolean isSelected) {

    }

    @Override
    protected void onDrawText(Canvas canvas, Calendar calendar, int x, int y, boolean hasScheme, boolean isSelected) {
        canvas.drawText(String.valueOf(calendar.getDay()), x+mItemWidth/2, y+mTextBaseLine, calendar.isCurrentMonth() ? mCurMonthTextPaint : mOtherMonthTextPaint);
    }
}
