package com.lenovo.smarttraffic.ui.fragment;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Deng;
import com.lenovo.smarttraffic.bean.GetTrafficLightConfigAction;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import me.yokeyword.fragmentation.SupportFragment;

public class Q21Fragment extends SupportFragment implements MyCallBack {
    @BindView(R.id.red)
    CircleImageView red;
    @BindView(R.id.yellow)
    CircleImageView yellow;
    @BindView(R.id.green)
    CircleImageView green;
    @BindView(R.id.ll_img)
    LinearLayout llImg;
    Unbinder unbinder;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.gv)
    GridView gv;

    Timer timer1;
    ArrayList<String> times = new ArrayList<>();

    CircleImageView[] circleImageViews;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q21, container, false);
        unbinder = ButterKnife.bind(this, v);

        circleImageViews = new CircleImageView[]{red, yellow, green};

        HashMap<String,Object> req = new HashMap<>();
        req.put("TrafficLightId","1");
        req.put("UserName","user1");

        HashMap<String,Object> req2 = new HashMap<>();
        req2.put("TrafficLightId","2");
        req2.put("UserName","user1");

        HashMap<String,Object> req3 = new HashMap<>();
        req3.put("TrafficLightId","3");
        req3.put("UserName","user1");
        OkHttpUtil.doPost("GetTrafficLightConfigAction.do",req, GetTrafficLightConfigAction.class,this,1);
        OkHttpUtil.doPost("GetTrafficLightConfigAction.do",req2, GetTrafficLightConfigAction.class,this,2);
        OkHttpUtil.doPost("GetTrafficLightConfigAction.do",req3, GetTrafficLightConfigAction.class,this,3);

        timer1 = new Timer();

        timer1.schedule(new TimerTask() {
            int i = 0;

            @Override
            public void run() {

                int y = i % 3;
                switch (y) {
                    case 0:
                        red.post(new Runnable() {
                            @Override
                            public void run() {
                                red.setImageResource(R.color.Red);
                                green.setImageResource(R.color.Grey);
                                yellow.setImageResource(R.color.Grey);
                            }
                        });

                        break;
                    case 1:
                        red.post(new Runnable() {
                            @Override
                            public void run() {
                                yellow.setImageResource(R.color.Yellow);
                                green.setImageResource(R.color.Grey);
                                red.setImageResource(R.color.Grey);
                            }
                        });

                        break;
                    case 2:
                        red.post(new Runnable() {
                            @Override
                            public void run() {
                                yellow.setImageResource(R.color.Grey);
                                green.setImageResource(R.color.Green);
                                red.setImageResource(R.color.Grey);
                            }
                        });

                        break;
                }
                i++;
//                Log.e("sssss", "run: " + i + ">>" + y);
            }
        }, 0, 2000);

        initView();
        return v;

    }

    ArrayAdapter<String> gvAdapter;
    private void initView() {
        String[] strings = {"路口升序", "路口降序", "红灯升序", "红灯升序"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(getContext(), R.layout.item_just_text, R.id.tv, strings);
        spinner.setAdapter(stringArrayAdapter);

        times.add("路口");
        times.add("红灯时长（S）");
        times.add("黄灯时长（S）");
        times.add("绿灯时长（S）");
        for(int i = 1 ; i <=3 ;i++){
            times.add(String.valueOf(i));
            times.add("10");
            times.add("10");
            times.add("10");
        }

        gvAdapter = new ArrayAdapter<String>(getContext(), R.layout.item_just_text, R.id.tv, times);
        gvAdapter.notifyDataSetChanged();
        gv.setAdapter(gvAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        chuliDate1();
                        break;
                    case 1:
                        chuliDate2();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        timer1.cancel();
        unbinder.unbind();
    }



    @Override
    public void sendResult(Object t, int typeId) {
        GetTrafficLightConfigAction bean = (GetTrafficLightConfigAction) t;

        switch (typeId){
            case 1:
                times.set(5,String.valueOf(bean.getRedTime()));
                times.set(6,String.valueOf(bean.getGreenTime()));
                times.set(7,String.valueOf(bean.getYellowTime()));
                Deng deng = new Deng(1,bean.getRedTime(),bean.getYellowTime(),bean.getGreenTime());
                dengs.add(deng);
                Log.e("sssss", "sendResult:1>>> "+ bean);
                break;
            case 2:
                times.set(9,String.valueOf(bean.getRedTime()));
                times.set(10,String.valueOf(bean.getGreenTime()));
                times.set(11,String.valueOf(bean.getYellowTime()));
                Deng deng2 = new Deng(2,bean.getRedTime(),bean.getYellowTime(),bean.getGreenTime());
                Log.e("sssss", "sendResult:2>>> "+ bean);

                dengs.add(deng2);
                break;
            case 3:
                times.set(13,String.valueOf(bean.getRedTime()));
                times.set(14,String.valueOf(bean.getGreenTime()));
                times.set(15,String.valueOf(bean.getYellowTime()));
                Deng deng3 = new Deng(3,bean.getRedTime(),bean.getYellowTime(),bean.getGreenTime());
                dengs.add(deng3);
                Log.e("sssss", "sendResult:3>>> "+ bean);

                break;
        }

        gv.post(new Runnable() {
            @Override
            public void run() {
                gvAdapter.notifyDataSetChanged();

            }
        });
    }
    List<Deng> dengs = new ArrayList<>();

    private void chuliDate1(){
//        List<Deng> dengs = new ArrayList<>();
        //遍历节点，添加数据
        Collections.sort(dengs,new Lukou1to3());
        //然后用这个容器去填充
        int i = 4;
        for(Deng deng :dengs){
            times.set(i,String.valueOf(deng.getId()));
            times.set(i+1,String.valueOf(deng.getRedTime()));
            times.set(i+2,String.valueOf(deng.getYellowTime()));
            times.set(i+3,String.valueOf(deng.getGreenTime()));
            i = i+4;
        }
        gv.post(new Runnable() {
            @Override
            public void run() {
                gvAdapter.notifyDataSetChanged();

            }
        });
    }

    private void chuliDate2(){
//        List<Deng> dengs = new ArrayList<>();
        //遍历节点，添加数据
        Collections.sort(dengs,new Lukou3to1());
        //然后用这个容器去填充
        int i = 4;
        for(Deng deng :dengs){
            times.set(i,String.valueOf(deng.getId()));
            times.set(i+1,String.valueOf(deng.getRedTime()));
            times.set(i+2,String.valueOf(deng.getYellowTime()));
            times.set(i+3,String.valueOf(deng.getGreenTime()));
            i = i+4;
        }
        gv.post(new Runnable() {
            @Override
            public void run() {
                gvAdapter.notifyDataSetChanged();

            }
        });
    }

    class Lukou1to3 implements Comparator<Deng>{

        @Override
        public int compare(Deng o1, Deng o2) {
            int i1 = o1.getId();
            int i2 = o2.getId();
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
            return 0;
        }
    }

    class Lukou3to1 implements Comparator<Deng>{

        @Override
        public int compare(Deng o1, Deng o2) {
            int i1 = o1.getId();
            int i2 = o2.getId();
            if (i1 < i2) {
                return 1;
            } else if (i1 > i2) {
                return -1;
            }
            return 0;
        }
    }
}
