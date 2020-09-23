package com.lenovo.smarttraffic.ui.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ChildBean;
import com.lenovo.smarttraffic.bean.GetBusStationInfoResult;
import com.lenovo.smarttraffic.bean.GroupBean;
import com.lenovo.smarttraffic.bean.MessageEvent;
import com.lenovo.smarttraffic.bean.Q11BusPeople;
import com.lenovo.smarttraffic.ui.adapter.ExpandableAdapter;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Q10ActivityHome extends BaseActivity implements MyCallBack {
    Timer timer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.AppBarLayout01)
    AppBarLayout AppBarLayout01;
    @BindView(R.id.btn_detail)
    Button btnDetail;
    @BindView(R.id.expandLv)
    ExpandableListView expandLv;

//    @BindView(R.id.btn_detail)
//    Button btnDetail;
//    @BindView(R.id.tv_zhan1_num1)
//    TextView tvZhan1Num1;
//    @BindView(R.id.tv_zhan1_people1)
//    TextView tvZhan1People1;
//    @BindView(R.id.tv_zhan1_time1)
//    TextView tvZhan1Time1;
//    @BindView(R.id.tv_zhan1_display1)
//    TextView tvZhan1Display1;
//    @BindView(R.id.tv_zhan1_num2)
//    TextView tvZhan1Num2;
//    @BindView(R.id.tv_zhan1_people2)
//    TextView tvZhan1People2;
//    @BindView(R.id.tv_zhan1_time2)
//    TextView tvZhan1Time2;
//    @BindView(R.id.tv_zhan1_display2)
//    TextView tvZhan1Display2;
//    @BindView(R.id.tv_zhan2_num1)
//    TextView tvZhan2Num1;
//    @BindView(R.id.tv_zhan2_people1)
//    TextView tvZhan2People1;
//    @BindView(R.id.tv_zhan2_time1)
//    TextView tvZhan2Time1;
//    @BindView(R.id.tv_zhan2_display1)
//    TextView tvZhan2Display1;
//    @BindView(R.id.tv_zhan2_num2)
//    TextView tvZhan2Num2;
//    @BindView(R.id.tv_zhan2_people2)
//    TextView tvZhan2People2;
//    @BindView(R.id.tv_zhan2_time2)
//    TextView tvZhan2Time2;
//    @BindView(R.id.tv_zhan2_display2)
//    TextView tvZhan2Display2;

    @Override
    protected int getLayout() {
        return R.layout.activity_q10;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar(toolbar,false,"公交查询");
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

        doPost();
        initView();
        initAction();
//        EventBus.getDefault().register(this);


    }

    private void doPost() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                HashMap<String,String> req1 = new HashMap<>();
                req1.put("BusStationId","1");
                req1.put("UserName","user1");
                OkHttpUtil.doPost("GetBusStationInfo.do",req1, GetBusStationInfoResult.class,Q10ActivityHome.this,1);

                HashMap<String,String> req2 = new HashMap<>();
                req2.put("BusStationId","2");
                req2.put("UserName","user1");
                OkHttpUtil.doPost("GetBusStationInfo.do",req2, GetBusStationInfoResult.class,Q10ActivityHome.this,2);

//                for(int i = 1; i < 13;i++){
//                    HashMap<String,Object> req3 = new HashMap<>();
//                    req3.put("BusId",i);
//                    req3.put("UserName","user1");
//                    OkHttpUtil.doPost("GetBusCapacity.do",req3, Q10DialogBean.class,Q10Activity.this,3);
//                }
                q11BusPeople = new ArrayList<>();
                q11BusPeople.add(new Q11BusPeople(1,100));
                q11BusPeople.add(new Q11BusPeople(2,100));
                q11BusPeople.add(new Q11BusPeople(3,100));
                q11BusPeople.add(new Q11BusPeople(4,100));

                runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
                        if(expandLv == null){
                            return;
                        }
                        expandLv.collapseGroup(0);
                        expandLv.collapseGroup(1);
                        //刷新界面
                        ExpandableAdapter ea = new ExpandableAdapter(stations, groupBeans);
                        expandLv.setDivider(getResources().getDrawable(R.drawable.divider_gray_line));
                        expandLv.setChildDivider(getResources().getDrawable(R.drawable.divider_gray_line));
                        expandLv.setAdapter(ea);
                        expandLv.expandGroup(0);
                        expandLv.expandGroup(1);
                    }
                });
                MessageEvent s = new MessageEvent();
                s.setSuccss("sb");
                EventBus.getDefault().post(s);

            }
        }, 0, 3000);
    }

    private void initAction() {
        btnDetail.setOnClickListener(v ->{
            //todo:判断是否有数据可以取
            if(q11BusPeople == null){
                return;
            }
            DialogQ11 q11 = new DialogQ11();
            q11.setPeopleLists(q11BusPeople,this);
            q11.show(getSupportFragmentManager(),"q11");
        });
    }
    List<Q11BusPeople> q11BusPeople ;
    List<String> stations ;
    List<GroupBean> groupBeans;
    private void initView() {

        stations = new ArrayList<>();
        stations.add("站台1");
        stations.add("站台2");

        groupBeans = new ArrayList<>();//父容器

        GroupBean groupBean1 = new GroupBean();
        List<ChildBean> childBeans = new ArrayList<>();//子容器
        ChildBean childBean = new ChildBean();//子对象
        childBeans.add(childBean);
        groupBean1.setChildBeanList(childBeans);

        GroupBean groupBean2 = new GroupBean();
        groupBean2.setChildBeanList(childBeans);

        groupBeans.add(groupBean1);
        groupBeans.add(groupBean2);
        ExpandableAdapter ea = new ExpandableAdapter(stations, groupBeans);
        expandLv.setDivider(getResources().getDrawable(R.drawable.divider_gray_line));
        expandLv.setChildDivider(getResources().getDrawable(R.drawable.divider_gray_line));
        expandLv.setAdapter(ea);
        expandLv.expandGroup(0);
        expandLv.expandGroup(1);
    }

    @Override
    public void sendResult(Object t, int typeId) {
        if(typeId == 1){
            GetBusStationInfoResult result = (GetBusStationInfoResult)t;
            List<GetBusStationInfoResult.ROWSDETAILBean> rowsdetailBeans = result.getROWS_DETAIL();
//            runOnUiThread(() ->{
//                expandLv.setAdapter();
//            });
            List<ChildBean> childBeans = new ArrayList<>();
            Log.e("sss", "sendResult: "+rowsdetailBeans );
            if(rowsdetailBeans == null){
                return;
            }
            for(GetBusStationInfoResult.ROWSDETAILBean bean : rowsdetailBeans){
                ChildBean childBean = new ChildBean();
                childBean.setTv_zhan1_num1(String.valueOf(bean.getBusId()));
                childBean.setTv_zhan1_display1(String.valueOf(bean.getDistance()));
                childBean.setTv_zhan1_people1(String.valueOf(40));
                childBean.setTv_zhan1_time1("5分钟到达");
                childBeans.add(childBean);
            }
            ChildBean childBean = new ChildBean();
            Collections.sort(childBeans, (Comparator)childBean);
            groupBeans.get(0).setChildBeanList(childBeans);

        }else if(typeId == 2){
            GetBusStationInfoResult result = (GetBusStationInfoResult)t;
            List<GetBusStationInfoResult.ROWSDETAILBean> rowsdetailBeans = result.getROWS_DETAIL();
            if(rowsdetailBeans == null){
                return;
            }
            List<ChildBean> childBeans = new ArrayList<>();
            for(GetBusStationInfoResult.ROWSDETAILBean bean : rowsdetailBeans){
                ChildBean childBean = new ChildBean();
                childBean.setTv_zhan1_num1(String.valueOf(bean.getBusId()));
                childBean.setTv_zhan1_display1(String.valueOf(bean.getDistance()));
                childBean.setTv_zhan1_people1(String.valueOf(40));
                childBean.setTv_zhan1_time1("5分钟到达");
                childBeans.add(childBean);
            }
            ChildBean childBean = new ChildBean();
            Collections.sort(childBeans, (Comparator)childBean);
            groupBeans.get(1).setChildBeanList(childBeans);
        }
        //设置groupbean 刷新界面
        //EventBus.getDefault().post(new);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dosomeSubscribe(MessageEvent msg){
        Log.e("eventbus", "dosomeSubscribe: "+ msg.getSuccss());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dosomeSubscribe(String msg){
        Log.e("eventbus", "dosomeSubscribe:>>> "+ msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        timer.cancel();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }
}
