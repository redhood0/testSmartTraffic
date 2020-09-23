package com.lenovo.smarttraffic.ui.zujian;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.MainActivity;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.ui.activity.BaseActivity;
import com.lenovo.smarttraffic.util.LoadingUtil;

import java.util.concurrent.TimeUnit;

public class PopUpWindow4Q22 extends DialogFragment {
    public EditText et;
    public Button btn_chongzhi;
    public Button btn_quit;
    public Activity ac;
    public LinearLayout loading;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        this.getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View v = inflater.inflate(R.layout.popup_q22, container, false);



//        btn_quit.setOnClickListener(n ->{
//            dismiss();
//        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();

        Window win = getDialog().getWindow();
        //win.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        et = v.findViewById(R.id.money);
        btn_chongzhi = v.findViewById(R.id.btn_chongzhi);
        btn_quit = v.findViewById(R.id.quit);
        loading = v.findViewById(R.id.loading);
        btn_quit.setOnClickListener( b ->{
            dismiss();
        });

        btn_chongzhi.setOnClickListener(n ->{
            String money = et.getText().toString();
            Log.e("dialog", "onViewCreated: "+money );
            if(money == null || "".equals(money)){
                return;
            }
            int moneyInt = Integer.parseInt(money);
            if(moneyInt <= 0 || moneyInt > 999){
                Toast.makeText(v.getContext(), "充值范围1~999", Toast.LENGTH_SHORT).show();
            }else {
//                LoadingUtil loadingUtil = new LoadingUtil();
//                loadingUtil.showLoading(ac);
                //loading
//                ProgressDialog progressDialog = new ProgressDialog(v.getContext());
//                progressDialog.show();
                //okhttp请求
                loading.setVisibility(View.VISIBLE);

                //结束loading

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //toast，关闭

                        //钱变多
                        loading.post(new Runnable() {
                            @Override
                            public void run() {
                                loading.setVisibility(View.GONE);
                            }
                        });
                        dismiss();
                    }
                }).start();

            }
        });
    }

    @Override
    public void onResume() {
//        getDialog().getWindow().setAttributes(new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        super.onResume();
//
//        btn_quit.setOnClickListener( n ->{
//            dismiss();
//        });
    }
}
