package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class Q38Activity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        loadRootFragment();
//        initToolBar();
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    public void onBackPressedSupport() {
        if(getFragmentManager().getBackStackEntryCount() > 1){
            pop();
        }else {
            finish();
        }
    }
}
