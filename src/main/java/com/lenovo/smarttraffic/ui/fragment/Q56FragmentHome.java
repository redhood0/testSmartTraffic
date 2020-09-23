package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q56FragmentHome extends SupportFragment implements MyCallBack {

    Unbinder unbinder;
    GetBusInfoBean busInfoBean;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_clear)
    TextView tvClear;
    @BindView(R.id.ll_history)
    LinearLayout llHistory;
    List<GetBusInfoBean.ROWSDETAILBean> lists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q56_home, container, false);
        unbinder = ButterKnife.bind(this, v);

        doPost();

        initAction();
        return v;
    }

    private void initAction() {
        btnSearch.setOnClickListener(v -> {
            String num = etSearch.getText().toString();
            if(num == null || "".equals(num)){
                return;
            }
            llHistory.setVisibility(View.VISIBLE);
            tvHistory.setText(num+"路");
            //  跳转
            if(lists == null || lists.size() == 0){
                return;
            }
            Q56FragmentDetial q56FragmentDetial  = new Q56FragmentDetial();
            q56FragmentDetial.setData(lists,num);
            start(q56FragmentDetial);

        });

        tvClear.setOnClickListener(v ->{
            llHistory.setVisibility(View.INVISIBLE);
        });
        tvHistory.setOnClickListener(v ->{
            etSearch.setText(tvHistory.getText().toString().split("路")[0]);
        });
    }

    private void doPost() {
        HashMap<String, Object> hashMap = new HashMap();
        //{"Line":0,"UserName":"user1"}
        hashMap.put("Line", 0);
        hashMap.put("UserName", "user1");

        OkHttpUtil.doPost("GetBusInfo.do", hashMap, GetBusInfoBean.class, this, 1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object t, int typeId) {
        busInfoBean = (GetBusInfoBean) t;
        lists = busInfoBean.getROWS_DETAIL();


    }
}
