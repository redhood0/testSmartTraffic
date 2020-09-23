package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q33Fragment extends SupportFragment {

    Unbinder unbinder;
    @BindView(R.id.marquee)
    TextView marquee;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q33, container, false);

        unbinder = ButterKnife.bind(this, v);
        marquee.setText(" 进出口银行再次融资支持印尼万隆高速公路项目,记者8日从中国进出口银行获悉，进出口银行日前与印度尼西亚财政部签署贷款协议，将给予万隆高速公路三期项目融资支持。此前，进出口银行已支持了万隆高速公路一、二期项目。");

        marquee.setSelected(true);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
