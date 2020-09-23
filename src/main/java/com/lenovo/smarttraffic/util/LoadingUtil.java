package com.lenovo.smarttraffic.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lenovo.smarttraffic.R;

import java.util.zip.Inflater;

public class LoadingUtil {

    View loadingView;

    public void showLoading(Activity activity){
        loadingView = View.inflate(activity, R.layout.page_loading,null);

        activity.addContentView(loadingView,new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }

    public void closeLoading(Activity activity){
        CommonUtil.removeSelfFromParent(loadingView);
    }


}
