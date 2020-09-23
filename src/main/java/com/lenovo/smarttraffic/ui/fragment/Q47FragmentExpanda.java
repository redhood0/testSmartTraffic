package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.GetBusInfoBean;
import com.lenovo.smarttraffic.ui.activity.Q47HomeActivity;
import com.lenovo.smarttraffic.ui.adapter.MyExpandableAdapter;
import com.lenovo.smarttraffic.util.MyCallBack;
import com.lenovo.smarttraffic.util.OkHttpUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

public class Q47FragmentExpanda extends SupportFragment implements MyCallBack {
    @BindView(R.id.expandable)
    ExpandableListView expandable;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_q47_expandable, container, false);
        unbinder = ButterKnife.bind(this, v);

        HashMap<String,Object> req = new HashMap<>();
        req.put("Line",0);
        req.put("UserName","user1");
        //获取数据
        OkHttpUtil.doPost("GetBusInfo.do",req, GetBusInfoBean.class,this,1);
        //填充适配器

        //填充expandablelistview

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void sendResult(Object t, int typeId) {
        MyExpandableAdapter myExpandableAdapter = new MyExpandableAdapter();
        GetBusInfoBean bean = (GetBusInfoBean) t;
        Q47HomeActivity q = (Q47HomeActivity) getActivity();
        q.bean =  (GetBusInfoBean) t;
        myExpandableAdapter.beans = bean.getROWS_DETAIL();


        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                expandable.setAdapter(myExpandableAdapter);

            }
        });

        expandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.e("ss", "onChildClick: "+ groupPosition + "---"+childPosition);
                HashMap<String,Integer> hashMap = new HashMap<>();
                hashMap.put("groupPosition",groupPosition);
                hashMap.put("childPosition",childPosition);
                Q47FragmentChild1 f = new Q47FragmentChild1();
                f.setPos(hashMap);
                start(f);
                return false;
            }
        });

    }
}
