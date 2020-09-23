package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q35Fragment extends SupportFragment {
    @BindView(R.id.cl1)
    ConstraintLayout cl1;
    @BindView(R.id.cl2)
    ConstraintLayout cl2;
    @BindView(R.id.cl3)
    ConstraintLayout cl3;
    @BindView(R.id.cl4)
    ConstraintLayout cl4;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q35_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        Item11Activity activity = (Item11Activity) getActivity();
        activity.initToolBar(activity.getToolbar(), true, "旅行信息");

        initView();
        return v;
    }

    private void initView() {
        cl1.setOnClickListener(v ->{
            start(new Q35ChildFragment());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
