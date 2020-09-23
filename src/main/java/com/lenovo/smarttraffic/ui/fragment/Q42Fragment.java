package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import me.yokeyword.fragmentation.SupportFragment;

public class Q42Fragment extends SupportFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q42, container, false);
        Item11Activity activity = (Item11Activity) getActivity();
        activity.initToolBar(activity.getToolbar(), true, "停车场");
        return v;
    }
}
