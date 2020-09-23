package com.lenovo.smarttraffic.ui.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.AllSenseResultBean;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q7Activity extends BaseActivity implements MyCallBack {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;

    @BindView(R.id.sw)
    Switch sw;
    @BindView(R.id.et_1)
    EditText et1;
    @BindView(R.id.et_2)
    EditText et2;
    @BindView(R.id.et_3)
    EditText et3;
    @BindView(R.id.et_4)
    EditText et4;
    @BindView(R.id.et_5)
    EditText et5;
    @BindView(R.id.et_6)
    EditText et6;
    @BindView(R.id.btn)
    Button btn;

    Timer timer;

    static final int[] yuzhi = {30,80,2000,400,200,4};

    @Override
    protected int getLayout() {
        return R.layout.q7;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initToolBar(toolbar,false,"阈值设置");
        EditText[] editTexts = {et1,et2,et3,et4,et5,et6};
        for(EditText et : editTexts){
            et.setBackgroundColor(getResources().getColor(R.color.colorGray));
            et.setFocusable(false);
            et.setFocusableInTouchMode(false);
            et.setEnabled(false);
        }
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    int i = 0;
                    for(EditText et : editTexts){
                        et.setBackgroundColor(getResources().getColor(R.color.colorGray));
                        et.setFocusable(false);
                        et.setFocusableInTouchMode(false);
                        et.setEnabled(false);
                        et.setText(String.valueOf(yuzhi[i]));
                        i++;
                    }
                    getMsg();
                }else {
                    for(EditText et : editTexts){
                        et.setBackgroundColor(getResources().getColor(R.color.White));
                        et.setFocusable(true);
                        et.setFocusableInTouchMode(true);
                        et.setEnabled(true);
                    }
                    if(timer != null){
                        timer.cancel();

                    }
                }
            }
        });

        //保存按钮，点击保存阈值

    }
    private Notification.Builder builder;
    private NotificationManager notificationManager;

    private void getMsg(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("UserName", "user1");
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                OkHttpUtil.doPost("GetAllSense.do", hashMap, AllSenseResultBean.class, Q7Activity.this, 1);
            }
        }, 0, 10000);

    }

    private void tongzhi(String type,int yuzhi, int nowpoint){
        builder =new Notification.Builder(this);


        builder.setSmallIcon(R.mipmap.ic_launcher);//小图标
        builder.setContentTitle(type+"警告通知");
        builder.setContentText("阈值：" + yuzhi + ", 当前值：" + nowpoint);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.getNotification());
    }

    @Override
    public void sendResult(Object t, int typeId) {
        if(typeId == 1){
//            AllSenseResultBean
            AllSenseResultBean all = (AllSenseResultBean)t;
            if(all.getTemperature() >= yuzhi[0]){
                tongzhi("温度",yuzhi[0],all.getTemperature());
                return;
            }
            if(all.getHumidity() >= yuzhi[1]){
                tongzhi("湿度",yuzhi[1],all.getHumidity());
                return;
            }
            if(all.getTemperature() >= yuzhi[0]){
                tongzhi("温度",yuzhi[0],all.getTemperature());
                return;
            }
            if(all.getTemperature() >= yuzhi[0]){
                tongzhi("温度",yuzhi[0],all.getTemperature());
                return;
            }
            if(all.getTemperature() >= yuzhi[0]){
                tongzhi("温度",yuzhi[0],all.getTemperature());
                return;
            }
            if(all.getTemperature() >= yuzhi[0]){
                tongzhi("温度",yuzhi[0],all.getTemperature());
                return;
            }

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(timer != null){
            timer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
