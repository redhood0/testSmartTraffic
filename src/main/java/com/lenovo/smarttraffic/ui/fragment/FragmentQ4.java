package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class FragmentQ4 extends SupportFragment {
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.frame)
    FrameLayout frame;
    Unbinder unbinder;
    boolean flag = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q4_home, container, false);

        unbinder = ButterKnife.bind(this, v);

        loadRootFragment(R.id.frame, new FirstFragment());

        initAction();
        return v;
    }

    private void initAction() {
        tv1.setOnClickListener(v -> {
            if (flag == true) {

            } else {
                tv1.setBackgroundDrawable(getResources().getDrawable(R.drawable.normal_border));
                tv2.setBackgroundDrawable(getResources().getDrawable(R.color.colorGray));
                flag = true;
                SupportFragment s = (SupportFragment) getChildFragmentManager().getFragments().get(0);
                s.start(new FirstFragment());
            }
        });

        tv2.setOnClickListener(v -> {
            if (flag == false) {

            } else {
                tv2.setBackgroundDrawable(getResources().getDrawable(R.drawable.normal_border));
                tv1.setBackgroundDrawable(getResources().getDrawable(R.color.colorGray));
                flag = false;

                SupportFragment s = (SupportFragment) getChildFragmentManager().getFragments().get(0);
                s.start(new FragmentQ4P1());

//                this.getChildFragmentManager().getFragments().get(0).start(new FragmentQ4P1());
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
