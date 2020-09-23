package com.lenovo.smarttraffic.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.lenovo.smarttraffic.InitApp;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.AllSenseResultBean;
import com.lenovo.smarttraffic.bean.Q5GreenBean;
import com.lenovo.smarttraffic.bean.RoadStatus;
import com.lenovo.smarttraffic.greendao.DaoSession;
import com.lenovo.smarttraffic.greendao.Q5GreenBeanDao;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

public class Q5Activity extends BaseActivity implements MyCallBack {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.wendu_num)
    TextView wenduNum;
    @BindView(R.id.clayout_wendu)
    ConstraintLayout clayoutWendu;
    @BindView(R.id.shidu_num)
    TextView shiduNum;
    @BindView(R.id.clayout_shidu)
    ConstraintLayout clayoutShidu;
    @BindView(R.id.guangzhao_num)
    TextView guangzhaoNum;
    @BindView(R.id.clayout_guangzhao)
    ConstraintLayout clayoutGuangzhao;
    @BindView(R.id.cq_num)
    TextView cqNum;
    @BindView(R.id.clayout_cq)
    ConstraintLayout clayoutCq;
    @BindView(R.id.pm_num)
    TextView pmNum;
    @BindView(R.id.clayout_pm)
    ConstraintLayout clayoutPm;
    @BindView(R.id.daolu_num)
    TextView daoluNum;
    @BindView(R.id.clayout_daolu)
    ConstraintLayout clayoutDaolu;
    Timer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar, true, "环境指标");
        getMsg();

        initAction();
    }

    private void initAction() {
        clayoutWendu.setOnClickListener( v -> {
            Intent intent = new Intent(this,Q6Activity.class);
            startActivity(intent);
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_q5;
    }

    void getMsg() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("UserName", "user1");

//        InitApp.getHandler().postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                OkHttpUtil.doPost("GetAllSense.do",hashMap, AllSenseResultBean.class,Q5Activity.this,1);
////            }
////        },3000);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                OkHttpUtil.doPost("GetAllSense.do", hashMap, AllSenseResultBean.class, Q5Activity.this, 1);
            }
        }, 0, 3000);

        HashMap<String, Object> hashMap2 = new HashMap<>();
        hashMap2.put("RoadId", "1");
        hashMap2.put("UserName", "user1");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                Log.e("sss", "run: GetRoadStatus.do==={\"RoadId\":1,\"UserName\":\"user1\"}" );
                OkHttpUtil.doPost("GetRoadStatus.do", hashMap2, RoadStatus.class, Q5Activity.this, 2);
                Q5GreenBean q5GreenBean = new Q5GreenBean();
                addData(q5GreenBean);
            }
        }, 0, 3000);

    }

    Long i = 1l;
    int addFlag = 0;

    synchronized void flagAdd() {
        addFlag++;
    }


    @Override
    public void sendResult(Object t, int typeId) {

        if (typeId == 1) {
            AllSenseResultBean bean = (AllSenseResultBean) t;
//            Log.e("ssss", "Thread.currentThread(): " + Thread.currentThread().toString());
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            runOnUiThread(() -> {
                wenduNum.setText(String.valueOf(bean.getTemperature()));
                shiduNum.setText(String.valueOf(bean.getHumidity()));
                guangzhaoNum.setText(String.valueOf(bean.getLightIntensity()));
                cqNum.setText(String.valueOf(bean.getCo2()));
                pmNum.setText(String.valueOf(bean.get_$Pm25190()));
            });

//            q5GreenBean.setId(null);
//            q5GreenBean.setWendu(bean.getTemperature());
//            q5GreenBean.setShidu(bean.getHumidity());
//            q5GreenBean.setGuangzhao(bean.getLightIntensity());
//            q5GreenBean.setCq2(bean.getCo2());
//            q5GreenBean.setPm(bean.get_$Pm25190());


        } else if (typeId == 2) {
            Log.e("ssss", "Thread.currentThread(): " + Thread.currentThread().toString());
            RoadStatus bean = (RoadStatus) t;
            Log.e("ssss", "sendResult: " + bean);
            int status = bean.getStatus();
//            q5GreenBean.setTfStatus(status);
            runOnUiThread(() -> {
                if (status >= 3) {
                    clayoutDaolu.setBackgroundResource(R.drawable.item_q5_danger);
                } else {
                    clayoutDaolu.setBackgroundResource(R.drawable.item_q5bg);
                }
                daoluNum.setText(String.valueOf(status));
            });
//
//            flagAdd();// 这里记录+1，为1
//            //这里判断是否等于2,等于二则唤醒，不等于则睡觉
//            if(addFlag == 2){
//                notifyAll();
//            }else {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                return;
//            }
        }
//        addFlag=0;

    }

    void addData(Q5GreenBean q5GreenBean) {
        q5GreenBean.setId(null);
        q5GreenBean.setWendu(Integer.parseInt(wenduNum.getText().toString()));
        q5GreenBean.setShidu(Integer.parseInt(shiduNum.getText().toString()));
        q5GreenBean.setGuangzhao(Integer.parseInt(guangzhaoNum.getText().toString()));
        q5GreenBean.setCq2(Integer.parseInt(cqNum.getText().toString()));
        q5GreenBean.setPm(Integer.parseInt(pmNum.getText().toString()));
        q5GreenBean.setTfStatus(Integer.parseInt(daoluNum.getText().toString()));
        q5GreenBean.setDate(new Date());

        DaoSession daoSession = InitApp.getDaoSession();
        Q5GreenBeanDao q5 = daoSession.getQ5GreenBeanDao();
        Long l = q5.insert(q5GreenBean);
        Log.e("ss", "addData:>>>>>>>long = " + l);
        Log.e("ss", "addData:>>>>>>>long = " + q5GreenBean);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
