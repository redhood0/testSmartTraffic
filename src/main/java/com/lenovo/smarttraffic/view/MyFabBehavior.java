package com.lenovo.smarttraffic.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;

public class MyFabBehavior extends FloatingActionButton.Behavior {

    float dependencyOriginalY = 0;
    float fabOriginalY = 0;

    //自定义的behavior必须重写带两个参数的构造方法
    public MyFabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //layoutDepentsOn至少会调用一次，用于判断coordinatorlayout下的dependency是否是我们指定的依赖
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency) || dependency instanceof NestedScrollView;
    }

    //上面的方法返回true的画，coordinatorlayout会不断调用onDependentViewChanged方法来改变子view的参数和状态


    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        //初始状态下，取得fab和dependency的原始y值
        if(dependency instanceof NestedScrollView){
            //初始状态下，取得fab和dependency的原始y值
            if(dependencyOriginalY == 0){
                dependencyOriginalY = dependency.getY();
                fabOriginalY = child.getY();
            }else{
                //计算dependency移动的deltaY值
                float deltaY = dependencyOriginalY - dependency.getY();
                //让fab也移动deltaY值
                child.setTranslationY(deltaY);
            }
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
