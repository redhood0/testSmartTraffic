package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Datas;
import com.lenovo.smarttraffic.bean.Q64Bean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q64ChongzhiAcctivity2 extends BaseActivity {
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

        initView();
    }

    private void initView() {
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
                if (s.toString().equals("")) {
                    return;
                }
                if (Integer.parseInt(s.toString()) < 1 || Integer.parseInt(s.toString()) > 999) {
                    textInputLayoutMoney.setError("范围必须在1~999");
                    s.clear();
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
                switch (id) {
                    case 1:
                        tvChepai.setText(Datas.beans.get(0).chepai);
                        break;
                    case 2:
                        tvChepai.setText(Datas.beans.get(1).chepai);
                        break;
                    case 3:
                        tvChepai.setText(Datas.beans.get(2).chepai);
                        break;
                    default:
                        tvChepai.setText("编号不存在");
                        break;
                }
            }
        });

        btnChongzhi.setOnClickListener(v -> {
            //loading加载
//            ProgressBar progressBar = new ProgressBar(this);
//            progressBar.setIndeterminateDrawable();
//
//            ll.addView(progressBar);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            String id = etNum.getText().toString();
            String money = etMoney.getText().toString();
            if (id.isEmpty() || money.isEmpty()) {
                return;
            }
            int idI = Integer.parseInt(id);
            int moneyI = Integer.parseInt(money);
            for(int i =0 ; i < 3; i++){
                if( Datas.beans.get(i).id == idI){
                    Datas.beans.get(i).yue += moneyI;
                    break;
                }
            }
            //loading结束
        });

//        tv10yuan.setOnClickListener(v ->{
//            etMoney.setText("10");
//        });
//        tv50yuan.setOnClickListener(v ->{
//            etMoney.setText("50");
//        });
//        tv100yuan.setOnClickListener(v ->{
//            etMoney.setText("100");
//        });
    }


}
