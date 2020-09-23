package com.lenovo.smarttraffic.ui.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.lenovo.smarttraffic.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DialogQ11 extends DialogFragment {
    @BindView(R.id.red)
    EditText red;
    @BindView(R.id.green)
    EditText green;
    @BindView(R.id.yellow)
    EditText yellow;
    @BindView(R.id.sure)
    Button sure;
    @BindView(R.id.quit)
    Button quit;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        View v = inflater.inflate(R.layout.item_q11_p2, container, false);
        unbinder = ButterKnife.bind(this, v);

        sure.setOnClickListener(n ->{
            //取值，填充


            //具体如何填充可以用EventBus
            EventBus.getDefault().post("sb");
        });
        quit.setOnClickListener(n ->{
            dismiss();
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
