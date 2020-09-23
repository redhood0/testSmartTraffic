package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q32Fragment extends SupportFragment {
    @BindView(R.id.map)
    ImageView map;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q32, container, false);
        unbinder = ButterKnife.bind(this, v);

//        map.setOnGenericMotionListener(new );

        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(getContext(), new MyGestureDectore());


        map.post(new Runnable() {
            @Override
            public void run() {
                imgx = map.getMeasuredWidth();
                imgy = map.getMeasuredHeight();
                Log.e("sss", "onScale:>>> " + imgx + ">>>" + imgy);
            }
        });


//        map.setOnTouchListener(new View.OnTouchListener() {
////            @Override
////            public boolean onTouch(View v, MotionEvent event) {
////
////
////                return scaleGestureDetector.onTouchEvent(event);
////            }
////        });

        processBitMap();
        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    int imgx;
    int imgy;

    class MyGestureDectore extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public MyGestureDectore() {
            super();
        }

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float f = detector.getScaleFactor();
//            Log.e("sss", "onScale:>>> " + f);

            map.post(new Runnable() {
                @Override
                public void run() {
                    ViewGroup.LayoutParams layoutParams = map.getLayoutParams();
//                    imgx = layoutParams.height;
//                    imgy= layoutParams.width;


                    double x = 1;
//                    Log.e("sss", "onScale:>>> " + y +">>>" + xx);
                    if (f > 1) {
                        x = 1 + f * 0.05;
                        //map.setLayoutParams(new LinearLayout.LayoutParams((int) (imgy * (1 + f *0.05)), (int) (imgx * (1 + f *0.05))));
                    } else {
                        x = 1 - f * 0.05;
                        //map.setLayoutParams(new LinearLayout.LayoutParams((int) (imgy * (1 - f *0.1)), (int) (imgx * (1 - f *0.1))));
                    }
                    imgx = (int) (imgx * x);
                    imgy = (int) (imgy * x);
//                    map.setLayoutParams(new LinearLayout.LayoutParams(imgx, imgy));
                    map.setScaleX((float) x);
                    map.setScaleY((float) x);

                }
            });

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

    public void processBitMap() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ditie_map);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();

        Matrix matrix = new Matrix();
        matrix.postScale(2,2);
//        matrix.postTranslate(1000,400);
        map.setScaleType(ImageView.ScaleType.MATRIX);


//        Bitmap newb = Bitmap.createBitmap(bitmap,0,0,1600, 1000,matrix,true );
        Log.e("ssss", "processBitMap>>>>>: " + w + "---" + h);
        Glide.with(getContext())
                .load(bitmap)
                //.override(3200,2000)
                .into(map);
        map.setImageMatrix(matrix);


    }
}
