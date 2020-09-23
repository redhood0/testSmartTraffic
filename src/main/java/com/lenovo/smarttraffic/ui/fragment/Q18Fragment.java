package com.lenovo.smarttraffic.ui.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.Q18Bean;
import com.lenovo.smarttraffic.ui.adapter.Q18Adapter;
import com.lenovo.smarttraffic.util.MyCallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q18Fragment extends SupportFragment implements MyCallBack {
    @BindView(R.id.page1)
    ConstraintLayout page1;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.tv_fenxi)
    TextView tvFenxi;
    @BindView(R.id.ll)
    LinearLayout ll;
    Unbinder unbinder;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.llchoice)
    LinearLayout llchoice;
    @BindView(R.id.pie)
    PieChart pie;
    @BindView(R.id.page2)
    LinearLayout page2;
    List<Q18Bean> q18Beans = new ArrayList<>();
    List<Q18Bean> showDate = new ArrayList<>();

    String[] types = {"全部", "湿度", "光照", "温度", "CO2", "PM2.5"};
    Timer timer = new Timer();
    @BindView(R.id.rv)
    RecyclerView rv;
    Q18Adapter q18Adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q18, container, false);
        unbinder = ButterKnife.bind(this, v);
        q18Adapter = new Q18Adapter();
        q18Adapter.datas = q18Beans;
        rv.setAdapter(q18Adapter);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setSaveEnabled(true);
        initData();
        initView();
        initAction();

        return v;
    }

    private void initData() {
        //随机生成值，然后进行报警
        timer.schedule(new TimerTask() {
            int i = 0;

            @Override
            public void run() {
//                int x = (int) Math.random() * 3;
//                Log.e("xxxx", "run: >>>>>>>>>>>>>>>>>>>>>>>"+Math.random()  );
                switch ((int)(Math.random()*3)) {
                    case 0:
                        q18Beans.add(new Q18Bean("【湿度报警】", 80, (int) (Math.random() * 20 + 80)));
                        break;
                    case 1:
                        q18Beans.add(new Q18Bean("【温度报警】", 20, (int) (Math.random() * 10 + 20)));
                        break;
                    case 2:
                        q18Beans.add(new Q18Bean("【光照报警】", 2000, (int) (Math.random() * 1000 + 2000)));
                        break;
                }
                //数据生成之后,根据具体的类型更新表格
                rv.post(new Runnable() {
                    @Override
                    public void run() {
                        q18Adapter.notifyDataSetChanged();
                    }
                });

            }
        }, 0, 5000);
    }

    private void initView() {
        pie.setNoDataText("当前还没有报警信息");
        pie.setNoDataTextColor(Color.BLACK);
        pie.setNoDataTextTypeface(Typeface.DEFAULT_BOLD);
        //假数据填充
        ArrayAdapter spA = new ArrayAdapter(getContext(), R.layout.item_just_text, R.id.tv, types);
        spinner.setAdapter(spA);

    }

    private void initAction() {
        tvSearch.setOnClickListener(n -> {
            tvFenxi.post(new Runnable() {
                @Override
                public void run() {
                    tvFenxi.setBackgroundColor(Color.WHITE);
                    tvSearch.setBackgroundColor(Color.RED);
                    page1.setVisibility(View.VISIBLE);
                    page2.setVisibility(View.GONE);
                }
            });
        });

        tvFenxi.setOnClickListener(n -> {
            tvFenxi.post(new Runnable() {
                @Override
                public void run() {
                    tvSearch.setBackgroundColor(Color.WHITE);
                    tvFenxi.setBackgroundColor(Color.RED);
                    page2.setVisibility(View.VISIBLE);
                    page1.setVisibility(View.GONE);
                }
            });
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("ssss", "onItemSelected: "+position+">>>" +id );
                //改变显示方式
                switch (position){

                    case 0:
                        rv.post(new Runnable() {
                            @Override
                            public void run() {
                                q18Adapter.datas = q18Beans;
                                q18Adapter.notifyDataSetChanged();
                            }
                        });
                        break;
                    case 1:
                        chooseGuangzhao();

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
        timer.cancel();
        unbinder.unbind();
    }
    //筛选
    private void chooseGuangzhao(){
        Log.e("sssss", "chooseGuangzhao: >>>" );
        for(Q18Bean q18Bean : q18Beans){
            if(q18Bean.getType().equals("【光照报警】")){
                showDate.add(q18Bean);
            }
        }
        rv.post(new Runnable() {
            @Override
            public void run() {
                q18Adapter.datas = showDate;
                q18Adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void sendResult(Object t, int typeId) {

    }
}
