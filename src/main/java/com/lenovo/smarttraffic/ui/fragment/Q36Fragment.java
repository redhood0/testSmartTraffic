package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetWeather;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q36Fragment extends SupportFragment implements MyCallBack {
    @BindView(R.id.img_today)
    ImageView imgToday;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.tv_yubao)
    TextView tvYubao;
    @BindView(R.id.tv_where)
    TextView tvWhere;
    @BindView(R.id.tv_temp)
    TextView tvTemp;
    @BindView(R.id.tv_day1)
    TextView tvDay1;
    @BindView(R.id.tv_weather1)
    TextView tvWeather1;
    @BindView(R.id.tv_tmp1)
    TextView tvTmp1;
    @BindView(R.id.ll_day1)
    LinearLayout llDay1;
    @BindView(R.id.tv_day2)
    TextView tvDay2;
    @BindView(R.id.tv_weather2)
    TextView tvWeather2;
    @BindView(R.id.tv_tmp2)
    TextView tvTmp2;
    @BindView(R.id.ll_day2)
    LinearLayout llDay2;
    @BindView(R.id.tv_day3)
    TextView tvDay3;
    @BindView(R.id.tv_weather3)
    TextView tvWeather3;
    @BindView(R.id.tv_tmp3)
    TextView tvTmp3;
    @BindView(R.id.ll_day3)
    LinearLayout llDay3;
    @BindView(R.id.tv_day4)
    TextView tvDay4;
    @BindView(R.id.tv_weather4)
    TextView tvWeather4;
    @BindView(R.id.tv_tmp4)
    TextView tvTmp4;
    @BindView(R.id.ll_day4)
    LinearLayout llDay4;
    @BindView(R.id.tv_day5)
    TextView tvDay5;
    @BindView(R.id.tv_weather5)
    TextView tvWeather5;
    @BindView(R.id.tv_tmp5)
    TextView tvTmp5;
    @BindView(R.id.ll_day5)
    LinearLayout llDay5;
    @BindView(R.id.ll_days)
    LinearLayout llDays;
    Unbinder unbinder;

    HashMap<String, Integer> weahterMap = new HashMap<>();


    @BindView(R.id.iv_we1)
    ImageView ivWe1;
    @BindView(R.id.iv_we2)
    ImageView ivWe2;
    @BindView(R.id.iv_we3)
    ImageView ivWe3;
    @BindView(R.id.iv_we4)
    ImageView ivWe4;
    @BindView(R.id.iv_we5)
    ImageView ivWe5;


//    ArrayList<TextView> tvDays;
//    ArrayList<ImageView> ivs;
//    ArrayList<TextView> tvWs;
//    ArrayList<TextView> tvTmp;
    TextView[] tvDays ;
    ImageView[] ivs;
    TextView[] tvWs;
    TextView[] tvTmp;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View c = inflater.inflate(R.layout.fragment_q36, container, false);
        unbinder = ButterKnife.bind(this, c);

        weahterMap.put("小雨", R.mipmap.rain);
        weahterMap.put("晴", R.mipmap.sun);
        weahterMap.put("阴", R.mipmap.idea);

        HashMap<String, Object> req = new HashMap<>();
        req.put("UserName", "user1");
        OkHttpUtil.doPost("GetWeather.do", req, GetWeather.class, this, 1);


       Item11Activity item11Activity = (Item11Activity) getActivity();
        item11Activity.initToolBar(item11Activity.getToolbar(),true,"天气预报");
        tvDays = new TextView[]{tvDay1,tvDay2,tvDay3,tvDay4,tvDay5};
         ivs  = new ImageView[]{ivWe1,ivWe2,ivWe3,ivWe4,ivWe5};
        tvWs  = new TextView[]{tvWeather1,tvWeather2,tvWeather3,tvWeather4,tvWeather5};
        tvTmp  = new TextView[]{tvTmp1,tvTmp2,tvTmp3,tvTmp4,tvTmp5};

        initView();
        return c;
    }

    private void initView() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);

        String data = simpleDateFormat.format(date);

        tvData.setText(data + "  " + "周" + week);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object t, int typeId) {
        GetWeather gw = (GetWeather) t;
        if (gw == null) {
            return;
        }
        List<GetWeather.ROWSDETAILBean> list = gw.getROWS_DETAIL();
        if (list.size() <= 0) {
            return;
        }
        //遍历数据，渲染界面
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < list.size(); i++) {

                    GetWeather.ROWSDETAILBean rowsdetailBean = list.get(i);
                    Log.e("rowsdetailBean", "run: >>>"+ rowsdetailBean.toString());

                    if(i == 1 ){
                        tvTemp.setText(rowsdetailBean.getTemperature());
                    }
                    tvDays[i-1].setText(rowsdetailBean.getWData());
                    tvWs[i-1].setText(rowsdetailBean.getType());
                    tvTmp[i-1].setText(rowsdetailBean.getTemperature());
                    Glide.with(getActivity()).load(weahterMap.get(rowsdetailBean.getType())).into(ivs[i-1]);
                }
            }
        });

    }
}
