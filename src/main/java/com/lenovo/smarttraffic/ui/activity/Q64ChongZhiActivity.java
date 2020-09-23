package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q64Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Q64ChongZhiActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.et_num)
    EditText etNum;
    @BindView(R.id.tv_chepai)
    TextView tvChepai;
    @BindView(R.id.tv_10yuan)
    TextView tv10yuan;
    @BindView(R.id.tv_50yuan)
    TextView tv50yuan;
    @BindView(R.id.tv_100yuan)
    TextView tv100yuan;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.textInputLayoutMoney)
    TextInputLayout textInputLayoutMoney;
    @BindView(R.id.btn_chongzhi)
    Button btnChongzhi;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected int getLayout() {
        return R.layout.activity_q64_2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        initview();
    }

    private void initview() {
        initToolBar(toolbar, true, "ETC充值");
        textInputLayoutMoney.setErrorEnabled(true);

        etMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals("") || Integer.parseInt(s.toString()) < 1 || Integer.parseInt(s.toString()) > 999) {
                    textInputLayoutMoney.setError("范围必须在1~999");
                    etMoney.setText("1");
                }
            }
        });

        etNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().equals("")) {
                    return;
                }
                int id = Integer.parseInt(s.toString());
//                switch (id) {
//                    case 1:
//                        tvChepai.setText(beans.get(0).chepai);
//                        break;
//                    case 2:
//                        tvChepai.setText(beans.get(1).chepai);
//                        break;
//                    case 3:
//                        tvChepai.setText(beans.get(2).chepai);
//                        break;
//                    default:
//                        tvChepai.setText("编号不存在");
//                        break;
//                }
            }
        });



//        btnChongzhi.setOnClickListener(v -> {
//            loadingStart();
//            String id = etNum.getText().toString();
//            String money = etMoney.getText().toString();
//            if(id==null || id.equals("") || money==null || money.equals("") ){
//                return;
//            }else {
//                Q64Bean q = Q64Bean.beans.get(Integer.parseInt(id));
//                q.yue += Integer.parseInt(money);
//            }
//
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            loadingStop();
//        });
    }


//    ProgressBar progressBar;
//    boolean hasProgress = false;
//    private void loadingStart() {
//        progressBar = new ProgressBar(this);
//        progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.indeterminate_drawable));
//        if(hasProgress){
//            ll.addView(progressBar);
//            hasProgress = true;
//        }else{
//            progressBar.setVisibility(View.VISIBLE);
//        }
//    }
//
//    private void loadingStop() {
//        if(progressBar == null){
//            return;
//        }else{
//            progressBar.setVisibility(View.GONE);
//        }
//    }
//



    @OnClick({R.id.tv_10yuan, R.id.tv_50yuan, R.id.tv_100yuan, R.id.btn_chongzhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_10yuan:
                etMoney.setText("10");
                break;
            case R.id.tv_50yuan:
                etMoney.setText("50");
                break;
            case R.id.tv_100yuan:
                etMoney.setText("100");
                break;
            case R.id.btn_chongzhi:

                break;
        }
    }
}
