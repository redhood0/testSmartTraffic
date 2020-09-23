package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.util.CreateQRBitpam;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q37FragmentHome extends SupportFragment {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.sp)
    Spinner sp;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.et_time)
    EditText etTime;
    @BindView(R.id.qr)
    ImageView qr;
    @BindView(R.id.ll_imgs)
    LinearLayout llImgs;
    @BindView(R.id.tv_msg)
    TextView tv_msg;

    Unbinder unbinder;
    String[] strs = {"1", "2", "3"};
    @BindView(R.id.btn)
    Button btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q37_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.item_just_text, R.id.tv, strs);
        sp.setAdapter(arrayAdapter);

        initAction();
        return v;
    }
    String content;
    private void initAction() {
        btn.setOnClickListener(v -> {
            String num = sp.getSelectedItem().toString();
            String money = etMoney.getText().toString();
            content =    "车辆编号：" + num + "，付款金额：" + money;
            try {
                Bitmap bitmap = CreateQRBitpam.CreateQRBitMap(content, 400, 400);
                Glide.with(getContext())
                        .load(bitmap)
                        .into(qr);

                llImgs.post(new Runnable() {
                    @Override
                    public void run() {
                        llImgs.setVisibility(View.VISIBLE);
                    }
                });
            } catch (WriterException e) {
                e.printStackTrace();
            }
        });

        llImgs.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                tv_msg.post(new Runnable() {
                    @Override
                    public void run() {
                        tv_msg.setText(content);
                    }
                });
                return false;
            }
        });

        llImgs.setOnClickListener(v ->{
            //弹一个新的fragment
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
