package com.lenovo.smarttraffic.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author Amoly
 * @date 2019/4/11.
 * description：
 */
public class BottomNavigationBehavior extends CoordinatorLayout.Behavior<View> {

    private ObjectAnimator outAnimator, inAnimator;

    int offsetY = 0;

    public BottomNavigationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    // 垂直滑动
//    @Override
//    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
//        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL;
//    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        if(axes == ViewCompat.SCROLL_AXIS_VERTICAL){
            int ch = coordinatorLayout.getMeasuredHeight();
            int ct = child.getTop();
            offsetY = ch - ct;
//            Log.e("sssssss", "onStartNestedScroll: ch:"  + ch + ",ct:" +ct );
            //获取子控件到父控件底部的偏移量
            return true;
        }
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (dy > 0) {// 上滑隐藏
            if (outAnimator == null) {
                outAnimator = ObjectAnimator.ofFloat(child, "translationY", 0, child.getHeight());
//                Log.e("sssssss", "onStartNestedScroll: dy:"  + dy + "child.getHeight():" +child.getHeight() );

                outAnimator.setDuration(200);
            }
            if (!outAnimator.isRunning() && child.getTranslationY() <= 0) {
//                Log.e("sssssss", "onStartNestedScroll: dy:"  + dy + "child.getHeight():" +coordinatorLayout.getTranslationY() );
                outAnimator.start();
            }
        } else if (dy < 0) {// 下滑显示
            if (inAnimator == null) {
                inAnimator = ObjectAnimator.ofFloat(child, "translationY", child.getHeight(), 0);
                inAnimator.setDuration(200);
            }
            if (!inAnimator.isRunning() && child.getTranslationY() >= child.getHeight()) {
                inAnimator.start();
            }
//
//            ViewPropertyAnimatorCompat s = ViewCompat.animate(child).translationY(-200).setDuration(2000).setInterpolator(new FastOutLinearInInterpolator());
//            s.start();
        }
    }
}