package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.AccountAdd;
import com.lenovo.smarttraffic.bean.AccountAddResult;
import com.lenovo.smarttraffic.bean.AccountSearch;
import com.lenovo.smarttraffic.bean.ChongZhiRecord;
import com.lenovo.smarttraffic.bean.SerachResult;
import com.lenovo.smarttraffic.greendao.ChongZhiRecordDao;
import com.lenovo.smarttraffic.greendao.DaoSession;
import com.lenovo.smarttraffic.util.CommonUtil;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;
import com.lenovo.smarttraffic.widget.ContentPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class AccountActivity extends BaseActivity implements MyCallBack {
    final static int SEARCH = 1;
    final static int ADD = 2;
    View load;

    @BindView(R.id.sp_account)
    Spinner spAccount;
    Button btn_search;
    Button btn_add;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.et_addmoney)
    EditText etAddmoney;

    public ContentPage contentPage;

    View nowView;
//    @Override
//    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
//        return super.onCreateView(parent, name, context, attrs);
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(findViewById(R.id.toolbar),true,"我的账户");

        btn_search = findViewById(R.id.btn_search);
        btn_add = findViewById(R.id.btn_add);

        initConpant();
        initAction();
    }

    private void initAction() {
        btn_search.setOnClickListener(v ->{
            searchAccount();
        });

        btn_add.setOnClickListener(v ->{
            addMoney();
        });
    }

    private void initConpant() {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        spAccount.setAdapter(new ArrayAdapter<String>(this, R.layout.spinner_item, R.id.tv_spinner, lists));

        spAccount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AccountActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        nowView = getWindow().getDecorView().findViewById(android.R.id.content);

        //进来先查一次
        AccountSearch search = new AccountSearch(1,"user1");
        OkHttpUtil.doPost("GetCarAccountBalance.do",search, SerachResult.class, this,SEARCH);
        //加载loading
        startLoading();
//
//设置动画
//        setContentView(contentPage);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_myaccount;
    }

    @Override
    public void sendResult(Object t, int typeId) {
        if(typeId == SEARCH){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //loading close
            stopLoading();
            if(((SerachResult)t).getRESULT().equals("S")){
                CommonUtil.runOnUIThread(() -> {
                    tvMoney.setText(String.valueOf(((SerachResult)t).getBalance()) + "元");

                });
            }else {
                runOnUiThread(() -> {
                    Toast.makeText(this, "网络异常，稍后重试", Toast.LENGTH_SHORT).show();
                });
            }
        }else if(typeId == ADD){
            runOnUiThread(() -> {
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
            });
            searchAccount();

        }
    }

    boolean isLoading = false;
    private void startLoading(){

        if(load == null){
//            FrameLayout frameLayout = new FrameLayout(this);
//            frameLayout.
            load = View.inflate(this, R.layout.page_loading, null);
        }
        if(!isLoading){
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            loadingFly.addView(load);
            addContentView(load,params);
            isLoading = true;
        }
    }

    private void stopLoading(){
        CommonUtil.runOnUIThread(() -> {
            CommonUtil.removeSelfFromParent(load);
            Log.e("sssss", "stopLoading: "+load );
            isLoading = false;
        });
    }

    private void searchAccount(){
        String carId = spAccount.getSelectedItem().toString();

        //发送请求
        AccountSearch search = new AccountSearch(Integer.parseInt(carId),"user1");
        OkHttpUtil.doPost("GetCarAccountBalance.do",search, SerachResult.class, this,SEARCH);
        //加载loading
        startLoading();
    }

    private void addMoney(){
        String carId = spAccount.getSelectedItem().toString();
        String momney = etAddmoney.getText().toString();
        if(!checkNum(Integer.parseInt(momney))){
            runOnUiThread(() -> {
                Toast.makeText(this, "金额范围1~999", Toast.LENGTH_SHORT).show();
            });
            return;
        }
        AccountAdd accountAdd = new AccountAdd(Integer.parseInt(carId),Integer.parseInt(momney),"user1");
        OkHttpUtil.doPost("SetCarAccountRecharge.do",accountAdd, AccountAddResult.class, this,ADD);
        //存入数据库
        ChongZhiRecord chongZhiRecord = new ChongZhiRecord();
        chongZhiRecord.setCarId(Integer.parseInt(carId));
        chongZhiRecord.setMoney(Integer.parseInt(momney));
        Calendar rightNow = Calendar.getInstance();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        chongZhiRecord.setTime(dateFormat.format(date));
        chongZhiRecord.setUsername("user1");
        saveDB(chongZhiRecord);
        //加载loading
        startLoading();
    }

    private boolean checkNum(int num){
        if(num <= 0 || num >999){
            return false;
        }else {
            return true;
        }
    }

    private void saveDB(ChongZhiRecord record){
        DaoSession session =  InitApp.getDaoSession();
        ChongZhiRecordDao chongZhiRecordDao = session.getChongZhiRecordDao();
        chongZhiRecordDao.insert(record);

    }
}
