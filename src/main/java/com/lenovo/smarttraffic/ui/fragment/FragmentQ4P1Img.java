package com.lenovo.smarttraffic.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ4P1Img extends SupportFragment {
    @BindView(R.id.iv)
    ImageView iv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q4_p1_img, container, false);
        unbinder = ButterKnife.bind(this, v);

        initAction();
        return v;


    }

    private void initAction() {
        GestureDetector sc = new GestureDetector(getContext(), new MyNormalGesture());
        ScaleGestureDetector sd = new ScaleGestureDetector(getContext(), new MyGesture());


        iv.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getPointerCount() > 1) {
                    return sd.onTouchEvent(event);
                } else {
//                    Log.e("ssss", "onTouch: >>>" );
                    return sc.onTouchEvent(event);
                }
            }
        });
    }

    class MyNormalGesture implements GestureDetector.OnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e("sss", "onScroll: " + distanceX + ">>>>" + distanceY);
//            iv.setTranslationX(distanceX);
            iv.scrollBy((int) distanceX, (int) distanceY);
//            iv.setTranslationY(distanceY);
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }

    class MyGesture implements ScaleGestureDetector.OnScaleGestureListener {


        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            float f = detector.getScaleFactor();
            float x = 1;
            if (f > 1) {
                x = (float) (x + (f - 1) * 0.3);
            } else {
                x = (float) (x - (1 - f) * 0.3);
            }

            int h = getResources().getDisplayMetrics().heightPixels;
            int w = getResources().getDisplayMetrics().widthPixels;
            float bili = getResources().getDisplayMetrics().density;
            Log.e("sss", "onScale: " + h + ">>>" + w + ">>>" + bili);
            Log.e("sss", "iv changkuan: " + iv.getMeasuredWidth() + ">>>" + iv.getHeight() + ">>>" + iv.getLayoutParams().height);


            int height = iv.getHeight();
            int width = iv.getHeight();
            iv.setLayoutParams(new LinearLayout.LayoutParams((int) (width * x), (int) (height * x)));
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }


    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        Log.e("Sss", "onMultiWindowModeChanged: " + iv.getMeasuredWidth() + ">>>" + iv.getHeight());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
