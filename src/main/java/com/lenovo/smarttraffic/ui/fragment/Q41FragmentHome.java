package com.lenovo.smarttraffic.ui.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetCarParkConsumptionRecord;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;
import com.lenovo.smarttraffic.ui.adapter.Q41Adapter;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q41FragmentHome extends SupportFragment implements MyCallBack {

    Unbinder unbinder;
    @BindView(R.id.time1)
    TextView time1;
    @BindView(R.id.time2)
    TextView time2;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.btn_quit)
    Button btnQuit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q41, container, false);

        unbinder = ButterKnife.bind(this, v);
        HashMap<String, Object> req = new HashMap<>();
        req.put("UserName", "user1");
        OkHttpUtil.doPost("GetCarParkConsumptionRecord", req, GetCarParkConsumptionRecord.class, this, 1);

       Item11Activity activity = (Item11Activity) getActivity();
        activity.initToolBar(activity.getToolbar(),true,"车辆收费查询");
        initAction();


        return v;
    }

    private void initAction() {
        String t1 = time1.getText().toString();

        time1.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String time = year+"-"+month+"-"+dayOfMonth;
                    time1.post(new Runnable() {
                        @Override
                        public void run() {
                            time1.setText(time);
                        }
                    });
                }
            }, 2017, 5, 1);

            datePickerDialog.show();
        });

        time2.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String time = year+"-"+month+"-"+dayOfMonth;
                    time2.post(new Runnable() {
                        @Override
                        public void run() {
                            time2.setText(time);
                        }
                    });
                }
            }, 2017, 8, 1);

            datePickerDialog.show();
        });


        btnSearch.setOnClickListener(v ->{
            List<GetCarParkConsumptionRecord.ROWSDETAILBean> data = new ArrayList<>();
            if(lists == null){
                return;
            }
            //遍历对象，比较时间。产生新的容器
            for(GetCarParkConsumptionRecord.ROWSDETAILBean da : lists){
                if(chooseTime(da.getOutTime())){
                    data.add(da);
                }
            }
            //容器填充数组
            Q41Adapter q41Adapter = new Q41Adapter();
            q41Adapter.data = data;
            rv.setAdapter(q41Adapter);
            rv.setLayoutManager(new LinearLayoutManager(getContext()));
            rv.invalidate();
        });

        btnQuit.setOnClickListener(v ->{
            getActivity().finish();
        });
    }

    private boolean chooseTime(String outTime) {
        String t1 = time1.getText().toString();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String t2 = time2.getText().toString();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Log.e("datatatat", "chooseTime: "+t1+">>>" + t2+">>>" + outTime );
        try {
            Date date1 = simpleDateFormat.parse(t1);
            Date date2 = simpleDateFormat.parse(t2);
            Date out = simpleDateFormat2.parse(outTime);
            Log.e("datatatat", "chooseTime: "+out.before(date2)+">>>" + out.after(date1)+">>>"  );
            if(out.before(date2) && out.after(date1)){
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    List<GetCarParkConsumptionRecord.ROWSDETAILBean> lists = new ArrayList<>();
    @Override
    public void sendResult(Object t, int typeId) {
        /**
         * Id : 1
         * CarId : 1
         * InTime : 2017-06-04 03:19:21
         * OutTime : 2017-06-04 04:19:21
         * Money : 5
         * CarParkId : 1
         */
        //  获取数据，填充list
        GetCarParkConsumptionRecord bean = (GetCarParkConsumptionRecord)t;
        lists =  bean.getROWS_DETAIL();

    }
}
