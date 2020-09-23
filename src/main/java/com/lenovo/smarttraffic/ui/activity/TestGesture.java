package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestGesture extends BaseActivity {
    @BindView(R.id.iv)
    ImageView iv;
    Matrix mMartix;

    float scale = 1;

    @Override
    protected int getLayout() {
        return R.layout.activity_gesture_test;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        iv.setImageResource(R.mipmap.jiaojing1_1);
        iv.setScaleType(ImageView.ScaleType.MATRIX);

        iv.measure(0, 0);

        int h = iv.getDrawable().getIntrinsicHeight();
        int w = iv.getDrawable().getIntrinsicWidth();
        mMartix = iv.getMatrix();

        Log.e("ss", "matrix:>>>> " + h + ">>" + w);
        iv.post(new Runnable() {
            @Override
            public void run() {
                Log.e("ss", "matrix:>>>> " + iv.getWidth() + ">>" + iv.getHeight());
                Log.e("ss", "iv.getMeasuredHeight()+\">>\"+iv.getMeasuredWidth():>>>> " + iv.getMeasuredHeight() + ">>" + iv.getMeasuredWidth());

            }
        });
        Log.e("ss", "getMeasuredHeight:>>>> " + iv.getMeasuredHeight() + ">>" + iv.getMeasuredWidth());

        GestureDetector ges = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Log.e("sss", "onDown: >>>");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.e("sss", "onShowPress: >>>");

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.e("sss", "onSingleTapUp: >>>");

                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.e("sss", "onScroll: >>>onScroll: >>>" + distanceX + ">>>" + distanceY);
                iv.scrollBy((int) distanceX, (int) distanceY);

                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.e("sss", "onLongPress>>>");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.e("sss", "onFling>>>" + velocityX + velocityY);

                return true;
            }
        });

        GestureDetector doubleges = new GestureDetector(this, new MydoubleListener());

        ScaleGestureDetector sc = new ScaleGestureDetector(this, new ScaleGestureDetector.OnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {
                float factor = detector.getScaleFactor();


                Log.e("mMartix", "factor:>>>>> " + factor);

                if (factor < 1) {
                    scale *= (1 - (1 - factor) * 0.2);
                } else {
                    scale *= (float) (1 + (factor - 1) * 0.2);
                }
//
//
                mMartix.setScale(scale, scale,detector.getFocusX(),detector.getFocusY());
//                Log.e("sss", "ScaleGestureDetector: >>>>>>" + scale+mMartix);
                iv.setImageMatrix(mMartix);
//                Log.e("mMartix", "onScale:>>>>> "+mMartix );
                return true;
            }

            @Override
            public boolean onScaleBegin(ScaleGestureDetector detector) {
                Log.e("mMartix", "onScaleBegin: >>>>>>");
                return true;
            }

            @Override
            public void onScaleEnd(ScaleGestureDetector detector) {
                Log.e("mMartix", "onScaleEnd: >>>>>>");


            }
        });

        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getPointerCount()>1){
                    if (sc.onTouchEvent(event)) {
                        return true;
                    }
                }else {
                    if (ges.onTouchEvent(event)) {
                        return true;
                    }

                    if (doubleges.onTouchEvent(event)) {
                        return true;
                    }
                }








//                Log.e("sss", "onTouch: " + event.getHistorySize());
//                if( sc.onTouchEvent(event)){
//                    return true;
//                }


                return true;
            }
        });
//        ProccseeDp();

    }

    public void ProccseeDp() {
//        getResources().getDisplayMetrics().density;
        float x = getResources().getDisplayMetrics().density;
        Log.e("ss", "getDisplayMetrics:>>>> " + x);

    }


    class MydoubleListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
        boolean flag = true;

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (flag) {
                Log.e("sss", "onDoubleTap: " + "图片放大111");
//                iv.setImageMatrix();
                scale = 2;

                mMartix.setScale(2, 2);
//                mMartix.postTranslate(20, 20);
                Matrix cMartix = new Matrix(mMartix);

                Log.e("mMartix", "图片放大111:>>>>> " + mMartix + ">>>>" + cMartix);
                iv.setImageMatrix(cMartix);
                mMartix = cMartix;

                Log.e("mMartix", "图片放大111:>>>>> " + mMartix + ">>>>" + cMartix);

                flag = false;
            } else {
                Log.e("sss", "onDoubleTap: " + "图片恢复正常");
                scale = 1;
                mMartix.setScale(1, 1);
                iv.setImageMatrix(mMartix);
                Log.e("mMartix", "图片恢复正常:>>>>> " + mMartix);
                flag = true;
            }
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return false;
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
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    }


}
