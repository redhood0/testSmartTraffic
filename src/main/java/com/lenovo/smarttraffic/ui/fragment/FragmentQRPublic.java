package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.util.CreateQRBitpam;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentQRPublic extends Fragment {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.iv)
    ImageView iv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_erweima, container, false);
        unbinder = ButterKnife.bind(this, v);
        //生成二维码
        try {
            Bitmap bitmap =  CreateQRBitpam.CreateQRBitMap("{\"UserName\":\"user1\",\"Id\":[\"23\",\"2\",\"73\"]}",400,400);
            Glide.with(getContext()).load(bitmap).into(iv);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        //刷新

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
