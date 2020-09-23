package com.lenovo.smarttraffic.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q45FragmentYue extends SupportFragment implements MyCallBack {

    @BindView(R.id.tv_card1)
    TextView tvCard1;
    @BindView(R.id.tv_style1)
    TextView tvStyle1;
    @BindView(R.id.tv_money1)
    TextView tvMoney1;
    @BindView(R.id.cl_car1)
    ConstraintLayout clCar1;
    @BindView(R.id.tv_card2)
    TextView tvCard2;
    @BindView(R.id.tv_style2)
    TextView tvStyle2;
    @BindView(R.id.tv_money2)
    TextView tvMoney2;
    @BindView(R.id.cl_car2)
    ConstraintLayout clCar2;
    @BindView(R.id.tv_card3)
    TextView tvCard3;
    @BindView(R.id.tv_style3)
    TextView tvStyle3;
    @BindView(R.id.tv_money3)
    TextView tvMoney3;
    @BindView(R.id.cl_car3)
    ConstraintLayout clCar3;
    @BindView(R.id.tv_card4)
    TextView tvCard4;
    @BindView(R.id.tv_style4)
    TextView tvStyle4;
    @BindView(R.id.tv_money4)
    TextView tvMoney4;
    @BindView(R.id.cl_car4)
    ConstraintLayout clCar4;
    Unbinder unbinder;

    Timer timer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q45_yue, container, false);
        unbinder = ButterKnife.bind(this, v);

        clCar1.setOnClickListener(m -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            final EditText et = new EditText(getContext());
            et.setHint("输入充值金额");
            et.setInputType(InputType.TYPE_CLASS_NUMBER);
            builder.setTitle("我的充值")
                    .setView(et)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //发起okhttp请求
                            HashMap<String,Object> hashMap = new HashMap<>();
                            hashMap.put("CarId",1);
                            hashMap.put("UserName","user1");
                            hashMap.put("Money",et.getText().toString());

                            OkHttpUtil.doPost("SetCarAccountRecharge.do",hashMap, GetBusInfoBean.class,Q45FragmentYue.this,1);
                            //记录存档
                            tvMoney1.setText(String.valueOf(Integer.parseInt(tvMoney1.getText().toString()) + Integer.parseInt(et.getText().toString())));
                            //稍等一下就退出去
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    })
                    .setNegativeButton("取消",null).show();
        });
        //计时器轮询，刷新小车金额
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },0,5000);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        timer.cancel();
    }

    @Override
    public void sendResult(Object t, int typeId) {
        if(typeId == 1){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getActivity(), "充值成功", Toast.LENGTH_SHORT).show();
                }
            });


        }else if(typeId == 2){

        }

    }
}
