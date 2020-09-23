package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.MessageEvent;
import com.lenovo.smarttraffic.bean.Q59Bean;
import com.lenovo.smarttraffic.ui.activity.Item11Activity;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q59HomeFragment extends SupportFragment implements MyCallBack {

    @BindView(R.id.tv_num)
    EditText tvNum;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.tv_notice)
    TextView tvNotice;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_q59_item1, container, false);
        unbinder = ButterKnife.bind(this, v);
        Item11Activity item11Activity = (Item11Activity) getActivity();
        item11Activity.initToolBar(item11Activity.getToolbar(),true,"车辆违章");
        initAction();
        return v;
    }

    private void initAction() {
        btnSearch.setOnClickListener(v ->{

            String text = tvNum.getText().toString();

            HashMap<String,String> req = new HashMap<>();
            req.put("UserName","user1");
            req.put("carnumber","鲁"+text);
            OkHttpUtil.doPost("GetCarPeccancy.do",req, Q59Bean.class,this,1);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object t, int typeId) {
        Q59Bean bean =(Q59Bean)t;
        if(bean.getROWS_DETAIL().size() == 0){

            tvNotice.post(new Runnable() {
                @Override
                public void run() {
                    tvNotice.setVisibility(View.VISIBLE);
                    tvNotice.setText("车牌号不存在");
                }
            });
            return;
        }else {
            tvNotice.post(new Runnable() {
                @Override
                public void run() {
                    tvNotice.setVisibility(View.INVISIBLE);
                }
            });
        }
        Q59ResultFragment q59ResultFragment = new Q59ResultFragment();
        q59ResultFragment.setQ59Bean(bean);
        start(q59ResultFragment);
        Log.e("sss", "sendResult: "+bean.getROWS_DETAIL().size());
    }
}
