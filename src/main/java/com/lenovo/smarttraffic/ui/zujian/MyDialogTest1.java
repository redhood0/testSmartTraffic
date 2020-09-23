package com.lenovo.smarttraffic.ui.zujian;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.lenovo.smarttraffic.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyDialogTest1 extends DialogFragment {
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.sss)
    LinearLayout sss;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_test1, container, false);
//        v.setLayoutParams(new LinearLayout.LayoutParams(400,300));
        unbinder = ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
//        WindowManager.LayoutParams layoutParams = window.getAttributes();
//        layoutParams.width = 400;
//        layoutParams.height = 300;
//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//        dm.density;
        window.setLayout(800, 1000);

        btn.setOnClickListener(v ->{
            dismiss();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
