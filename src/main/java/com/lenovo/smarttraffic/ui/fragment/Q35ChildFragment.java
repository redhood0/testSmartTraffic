package com.lenovo.smarttraffic.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q35ChildFragment extends SupportFragment {
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_phone_name)
    TextView tvPhoneName;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q35_child, container, false);

        Item11Activity activity = (Item11Activity) getActivity();
        activity.initToolBar(activity.getToolbar(), true, "详细信息");


        unbinder = ButterKnife.bind(this, v);

        tvPhoneName.setOnClickListener(n ->{
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-888888"));
            startActivity(i);
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
