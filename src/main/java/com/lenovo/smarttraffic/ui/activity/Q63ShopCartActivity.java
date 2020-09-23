package com.lenovo.smarttraffic.ui.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.TestJson1;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q63ShopCartActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.tv_today)
    TextView tvToday;
    @BindView(R.id.tv_tomorrow)
    TextView tvTomorrow;
    @BindView(R.id.tv_more_date)
    TextView tvMoreDate;
    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.iv_1)
    ImageView iv1;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_desc)
    TextView tvDesc;
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.tv_num)
    TextView tvNum;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.tv_total_pay)
    TextView tvTotalPay;
    @BindView(R.id.cl_item)
    ConstraintLayout clItem;

    @Override
    protected int getLayout() {
        return R.layout.activity_q63_buy_cart;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar, true, "购物车");
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        initAction();

//        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:asdasdasd"));
    }

    private void initAction() {
        tvToday.setOnClickListener(v -> {
            tvToday.setTextColor(getResources().getColor(R.color.Black));
            tvTomorrow.setTextColor(getResources().getColor(R.color.gray));
            tvMoreDate.setTextColor(getResources().getColor(R.color.gray));
        });
        tvTomorrow.setOnClickListener(v -> {
            tvTomorrow.setTextColor(getResources().getColor(R.color.Black));
            tvToday.setTextColor(getResources().getColor(R.color.gray));
            tvMoreDate.setTextColor(getResources().getColor(R.color.gray));
        });

        //打开日期选择器
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, new MyOnDateSetListener(), 2020, 4, 20);

        tvMoreDate.setOnClickListener(v -> {
            datePickerDialog.show();
        });

        ivAdd.setOnClickListener(v -> {
            String num = tvNum.getText().toString();
            int numInt = Integer.parseInt(num);
            numInt += 1;
            int price = numInt * 80;
            tvNum.setText(String.valueOf(numInt));
            tvTotalPay.setText("总金额：" + String.valueOf(price) + "元");
        });

        ivPlus.setOnClickListener(v -> {
            String num = tvNum.getText().toString();
            int numInt = Integer.parseInt(num);
            int price = numInt * 80;
            numInt -= 1;
            if (numInt < 0) {
                Toast.makeText(this, "数量不能小于0张", Toast.LENGTH_SHORT).show();
                return;
            }
            tvNum.setText(String.valueOf(numInt));
            tvTotalPay.setText("总金额：" + String.valueOf(price) + "元");
        });

        btnDelete.setOnClickListener(v -> {
            clItem.setVisibility(View.GONE);
            Gson gson = new Gson();
            Log.e("sss", "initAction: >>>>>>>>>>>>");
            String str = "{\"name\":\"zhangsan\",\"sex\":\"男\",\"age\":\"24\"}";
            JSONObject jsonObject = gson.fromJson(str, JSONObject.class);

            com.alibaba.fastjson.JSONObject jsonObject1 = JSON.parseObject(str, com.alibaba.fastjson.JSONObject.class);
            Log.e("sss", "initAction: " + jsonObject1.getString("name"));

            Log.e("sss", "initAction: ");
        });

        btnPay.setOnClickListener(v -> {
            Intent intent = new Intent(this,Q63PayActivity.class);
            startActivity(intent);
        });


    }

    class MyOnDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            tvMoreDate.setText(month + "月/" + dayOfMonth + "日\n预定");
            tvMoreDate.setTextColor(getResources().getColor(R.color.Black));
            tvTomorrow.setTextColor(getResources().getColor(R.color.gray));
            tvToday.setTextColor(getResources().getColor(R.color.gray));
        }
    }
}
