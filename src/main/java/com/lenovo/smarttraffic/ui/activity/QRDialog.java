package com.lenovo.smarttraffic.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
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

public class QRDialog extends DialogFragment {
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.iv)
    ImageView iv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_erweima, container, false);

        unbinder = ButterKnife.bind(this, view);
        try {
            Bitmap bitmap =  CreateQRBitpam.CreateQRBitMap("{\"UserName\":\"user1\",\"Id\":[\"23\",\"2\",\"73\"]}",400,400);
            Glide.with(getActivity()).load(bitmap).into(iv);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
