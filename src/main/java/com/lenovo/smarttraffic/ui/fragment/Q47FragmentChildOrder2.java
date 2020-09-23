package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Q47HomeActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q47FragmentChildOrder2 extends SupportFragment {
    @BindView(R.id.tv_from_to)
    TextView tvFromTo;
    @BindView(R.id.sp_shangche)
    Spinner spShangche;
    @BindView(R.id.sp_xiache)
    Spinner spXiache;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q47_order2, container, false);
        unbinder = ButterKnife.bind(this, v);

        initView();
        return v;
    }

    private void initView() {
        Q47HomeActivity activity = (Q47HomeActivity) getActivity();
        List<String> sits = activity.bean.getROWS_DETAIL().get(0).getSites();
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.item_just_text, R.id.tv, sits);
        spShangche.setAdapter(arrayAdapter);

        ArrayAdapter arrayAdapte2 = new ArrayAdapter(getContext(), R.layout.item_just_text, R.id.tv, sits);
        spXiache.setAdapter(arrayAdapte2);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
