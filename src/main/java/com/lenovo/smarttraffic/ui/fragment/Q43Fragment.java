package com.lenovo.smarttraffic.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetCarAccountBalance;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q43Fragment extends SupportFragment implements MyCallBack {
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.tv_name1)
    TextView tvName1;
    @BindView(R.id.tv_money_before)
    TextView tvMoneyBefore;
    @BindView(R.id.btn_add1)
    Button btnAdd1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.tv_name2)
    TextView tvName2;
    @BindView(R.id.tv_money_before2)
    TextView tvMoneyBefore2;
    @BindView(R.id.btn_add2)
    Button btnAdd2;
    @BindView(R.id.img3)
    ImageView img3;
    @BindView(R.id.tv_name3)
    TextView tvName3;
    @BindView(R.id.tv_money_before3)
    TextView tvMoneyBefore3;
    @BindView(R.id.btn_add3)
    Button btnAdd3;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q43, container, false);
        unbinder = ButterKnife.bind(this, v);

        HashMap<String, Object> req = new HashMap<>();
        req.put("CarId", 1);
        req.put("UserName", "user1");
        OkHttpUtil.doPost("GetCarAccountBalance.do", req, GetCarAccountBalance.class, this, 1);

        HashMap<String, Object> req2 = new HashMap<>();
        req.put("CarId", 1);
        req.put("UserName", "user1");
        OkHttpUtil.doPost("GetCarAccountBalance.do", req2, GetCarAccountBalance.class, this, 2);

        HashMap<String, Object> req3 = new HashMap<>();
        req.put("CarId", 1);
        req.put("UserName", "user1");
        OkHttpUtil.doPost("GetCarAccountBalance.do", req3, GetCarAccountBalance.class, this, 3);


        initView();
        return v;
    }

    private void initView() {
        btnAdd1.setOnClickListener(v -> {
            AlertDialog.Builder b = new AlertDialog.Builder(getContext());

            EditText editText = new EditText(getContext());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            b.setTitle("充值")
                    .setView(editText)
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String money = editText.getText().toString();
                            //大小判断
                            if(Integer.parseInt(money) >= 1000){
                                Toast.makeText(getActivity(), "金额不能大于1000yuan", Toast.LENGTH_SHORT).show();
                                return;
                            }

//                           {"CarId":1,"Money":200, "UserName":"user1"}
                            HashMap<String, Object> req = new HashMap<>();
                            req.put("CarId", 1);
                            req.put("UserName", "user1");
                            req.put("Money", money);
                            OkHttpUtil.doPost("SetCarAccountRecharge.do", req, Object.class, Q43Fragment.this, 4);
                            //刷新界面
                            tvMoneyBefore.post(new Runnable() {
                                @Override
                                public void run() {
                                    tvMoneyBefore.setText("余额："+(Integer.parseInt(tvMoneyBefore.getText().toString().split("：")[1]) + Integer.parseInt(money)));
                                }
                            });
                        }
                    }).show();
        });

        btnAdd2.setOnClickListener(v -> {
            AlertDialog.Builder b = new AlertDialog.Builder(getContext());

            EditText editText = new EditText(getContext());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            b.setTitle("充值")
                    .setView(editText)
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String money = editText.getText().toString();
                            //大小判断
                            if(Integer.parseInt(money) >= 1000){
                                Toast.makeText(getActivity(), "金额不能大于1000yuan", Toast.LENGTH_SHORT).show();
                                return;
                            }

//                           {"CarId":1,"Money":200, "UserName":"user1"}
                            HashMap<String, Object> req = new HashMap<>();
                            req.put("CarId", 2);
                            req.put("UserName", "user1");
                            req.put("Money", money);
                            OkHttpUtil.doPost("SetCarAccountRecharge.do", req, Object.class, Q43Fragment.this, 5);
                            //刷新界面
                            tvMoneyBefore2.setText("余额："+(Integer.parseInt(tvMoneyBefore2.getText().toString().split("：")[1]) + Integer.parseInt(money)));

                        }
                    }).show();
        });

        btnAdd3.setOnClickListener(v -> {
            AlertDialog.Builder b = new AlertDialog.Builder(getContext());

            EditText editText = new EditText(getContext());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            b.setTitle("充值")
                    .setView(editText)
                    .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String money = editText.getText().toString();
                            //大小判断
                            if(Integer.parseInt(money) >= 1000){
                                Toast.makeText(getActivity(), "金额不能大于1000yuan", Toast.LENGTH_SHORT).show();
                                return;
                            }

//                           {"CarId":1,"Money":200, "UserName":"user1"}
                            HashMap<String, Object> req = new HashMap<>();
                            req.put("CarId", 3);
                            req.put("UserName", "user1");
                            req.put("Money", money);
                            OkHttpUtil.doPost("SetCarAccountRecharge.do", req, Object.class, Q43Fragment.this, 6);
                            //刷新界面
                            tvMoneyBefore3.setText("余额："+(Integer.parseInt(tvMoneyBefore3.getText().toString()) + Integer.parseInt(money)));

                        }
                    }).show();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object t, int typeId) {

        if (typeId == 1) {
            GetCarAccountBalance bean = (GetCarAccountBalance) t;
            tvMoneyBefore.post(new Runnable() {
                @Override
                public void run() {
                    tvMoneyBefore.setText("余额：" + bean.getBalance());
                }
            });

        } else if (typeId == 2) {
            GetCarAccountBalance bean = (GetCarAccountBalance) t;
            tvMoneyBefore2.post(new Runnable() {
                @Override
                public void run() {
                    tvMoneyBefore2.setText("余额：" + bean.getBalance());
                }
            });


        } else if (typeId == 3) {
            GetCarAccountBalance bean = (GetCarAccountBalance) t;
            tvMoneyBefore3.post(new Runnable() {
                @Override
                public void run() {
                    tvMoneyBefore3.setText("余额：" + bean.getBalance());
                }
            });

        }

    }
}
