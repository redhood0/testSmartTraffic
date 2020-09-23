package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lenovo.smarttraffic.R;

import butterknife.BindView;

public class ImageActivity extends BaseActivity {

    private ScaleGestureDetector detector;
    int imgX;
    int imgY;

    @BindView(R.id.iv4show)
    ImageView iv4show;
    int imgId;

//    @Override
//    protected void onStart() {
//        super.onStart();
////        Log.e("onStart>>>", "onStart: "+iv4show.getWidth() );
//    }



    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume>>>", "onStart: "+iv4show.getWidth() );
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (true){
            Log.e("onWindowFocusChanged>>>", "onStart: "+iv4show.getWidth() );
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imgId = getIntent().getIntExtra("imgId", 0);

        Drawable drawable = getResources().getDrawable(imgId);
        iv4show.setImageDrawable(drawable);
//        iv4show.getViewTreeObserver().addOnGlobalFocusChangeListener();

//        Log.e("drawable", "onCreate: " + drawable.getIntrinsicWidth() + "==" + drawable.getIntrinsicHeight());
//        Log.e("drawable", "iv4show.getWidth(): " + iv4show.getWidth() + "==" + iv4show.getHeight());
        ViewGroup.LayoutParams para = iv4show.getLayoutParams();
        int w = para.width;
        int h = para.height;
//        Log.e("drawable", "iv4show.getWidth(): " + w + "==" + h);
//
//        Matrix matrix = new Matrix();
//        Matrix matrix2 = new Matrix();
//        Matrix matrix3 = new Matrix();
//        RectF rect1 = new RectF(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
//        RectF rect2 = new RectF(0, 0, iv4show.getWidth(), iv4show.getHeight());
//        matrix.setRectToRect(rect1, rect2, Matrix.ScaleToFit.CENTER);
//        matrix2.set(matrix);

//        matrix3.postScale(0.5f,0.5f,0,0);
////        iv4show.setImageMatrix(matrix3);

        detector = new ScaleGestureDetector(this, new MyScaleGenstureListener());

        iv4show.post(() -> {
            imgX = iv4show.getWidth();
            imgY = iv4show.getHeight();
            Log.e("ssss", "onCreate: " + imgX + "==" + imgY);
        });
        //iv4show
        iv4show.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }
        });
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_img;
    }

    private class MyScaleGenstureListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public MyScaleGenstureListener() {
            super();
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
//            Log.e("x", "onScale");
//            Log.e("x", "getCurrentSpan" + detector.getCurrentSpan());
//            Log.e("x", "getPreviousSpan" + detector.getPreviousSpan());
//            Log.e("x", "getScaleFactor" + detector.getScaleFactor());
//            Log.e("x", "getEventTime" + detector.getEventTime());
//            Log.e("x", "getTimeDelta" + detector.getTimeDelta());
//            Matrix matrix = new Matrix();
//            float x = detector.getFocusX();
//            float y = detector.getFocusY();

            float scaleFactor = detector.getScaleFactor();

            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }

            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) iv4show.getLayoutParams();
            if (scaleFactor > 1) {
                scaleFactor = (float) (scaleFactor * 0.05 + 1);
            } else {
                scaleFactor = (float) (1 - scaleFactor * 0.1);
            }
            imgX = (int) (imgX * scaleFactor);
            imgY = (int) (imgY * scaleFactor);
            iv4show.setLayoutParams(new LinearLayout.LayoutParams(imgX, imgY));

            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            super.onScaleEnd(detector);
        }
    }
}
