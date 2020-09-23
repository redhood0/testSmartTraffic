package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ChongZhiRecord;
import com.lenovo.smarttraffic.bean.ChongzhiRecoder;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q34V1Fragment extends SupportFragment {
    @BindView(R.id.tv_money1)
    TextView tvMoney1;
    @BindView(R.id.tv_money2)
    TextView tvMoney2;
    @BindView(R.id.tv_money3)
    TextView tvMoney3;
    Unbinder unbinder;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.btn_add)
    Button btnAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q34_iv1, container, false);
        unbinder = ButterKnife.bind(this, v);

        tvMoney1.setOnClickListener(n -> {
            etMoney.setText("10");
        });
        tvMoney2.setOnClickListener(n -> {
            etMoney.setText("50");
        });
        tvMoney3.setOnClickListener(n -> {
            etMoney.setText("100");
        });
        btnAdd.setOnClickListener(n ->{
            String money = etMoney.getText().toString();
            if(money.isEmpty() || "".equals(money)){
                return;
            }else {

                ChongzhiRecoder chongZhiRecord = new ChongzhiRecoder();
                chongZhiRecord.setChepai("辽A10001");
                chongZhiRecord.setMoney(Integer.parseInt(money));
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                chongZhiRecord.setDate(simpleDateFormat.format(date));
                //发送充值请求
                //OKHTTP
                //静态记录充值数据
                Item11Activity item11Activity = (Item11Activity) getActivity();
                item11Activity.recoders.add(chongZhiRecord);
                Log.e("item11Activity", "item11Activity:>>> " +item11Activity.recoders);
            }
        });
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
