package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.util.MyCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q34V2Fragment extends SupportFragment implements MyCallBack {
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.yue)
    TextView yue;
    @BindView(R.id.btn_search)
    Button btnSearch;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q34_yue, container, false);
        unbinder = ButterKnife.bind(this, v);

        btnSearch.setOnClickListener(n -> {
            //走okhttp请求
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object t, int typeId) {
        //接收数据，回写textview
    }
}
