package com.lenovo.smarttraffic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.ui.activity.Q47HomeActivity;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q47FragmentChild1 extends SupportFragment {


    HashMap<String, Integer> pos;

    public void setPos(HashMap<String, Integer> pos) {
        this.pos = pos;
    }

    @BindView(R.id.iv_map)
    ImageView ivMap;
    @BindView(R.id.tv_from_to)
    TextView tvFromTo;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_dis)
    TextView tvDis;
    @BindView(R.id.btn_next)
    Button btnNext;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q47_order1, container, false);
        unbinder = ButterKnife.bind(this, v);

        initView();
        return v;
    }

    private void initView() {
        Q47HomeActivity activity = (Q47HomeActivity) getActivity();
        GetBusInfoBean busInfoBean = activity.bean;
        if (pos == null) {
            return;
        }
        Integer gid = pos.get("groupPosition");
        Integer cid = pos.get("childPosition");
        GetBusInfoBean.ROWSDETAILBean rowsdetailBean = busInfoBean.getROWS_DETAIL().get(gid);
        String fromto = rowsdetailBean.getSites().get(0) + "---" + rowsdetailBean.getSites().get(rowsdetailBean.getSites().size() - 1);
        tvFromTo.setText(fromto);

        btnNext.setOnClickListener(v -> {
            start(new Q47FragmentChildData());
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
