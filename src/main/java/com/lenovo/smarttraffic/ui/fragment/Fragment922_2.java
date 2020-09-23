package com.lenovo.smarttraffic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.lenovo.smarttraffic.R;
import com.lenovo.smarttraffic.bean.ExpandableBean;
import com.lenovo.smarttraffic.ui.adapter.ExpandableAdapter922;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public class Fragment922_2 extends SupportFragment {

    @BindView(R.id.expandLv)
    ExpandableListView expandableListView;
    @BindView(R.id.btn_refresh)
    Button btn_refresh;

    //group数据
    private ArrayList<String> mGroupList;
    //item数据
    private ArrayList<ArrayList<ExpandableBean>> mItemSet;
    ExpandableAdapter922 expandableAdapter922;

    private void initData() {
        mGroupList = new ArrayList<>();
        mGroupList.add("a1站");
        mGroupList.add("a2站");
        mGroupList.add("a3站");

        mItemSet = new ArrayList<>();
        ArrayList<ExpandableBean> itemList1 = new ArrayList<>();
        itemList1.add(new ExpandableBean("1号",20,3,100));
        itemList1.add(new ExpandableBean("2号",20,4,200));

        ArrayList<ExpandableBean> itemList2 = new ArrayList<>();
        itemList2.add(new ExpandableBean("1号",22,7,230));
        itemList2.add(new ExpandableBean("2号",25,5,130));

        ArrayList<ExpandableBean> itemList3 = new ArrayList<>();
        itemList3.add(new ExpandableBean("1号",22,7,230));
        itemList3.add(new ExpandableBean("2号",25,5,130));

        mItemSet.add(itemList1);
        mItemSet.add(itemList2);
        mItemSet.add(itemList3);
    }

    private void initData2() {
        mGroupList = new ArrayList<>();
        mGroupList.add("a1站");
        mGroupList.add("a2站");
        mGroupList.add("a3站");

        mItemSet = new ArrayList<>();
        ArrayList<ExpandableBean> itemList1 = new ArrayList<>();
        itemList1.add(new ExpandableBean("1号",33,3,100));
        itemList1.add(new ExpandableBean("2号",44,4,200));

        ArrayList<ExpandableBean> itemList2 = new ArrayList<>();
        itemList2.add(new ExpandableBean("1号",11,7,230));
        itemList2.add(new ExpandableBean("2号",111,5,130));

        ArrayList<ExpandableBean> itemList3 = new ArrayList<>();
        itemList3.add(new ExpandableBean("1号",2,7,230));
        itemList3.add(new ExpandableBean("2号",15,5,130));

        mItemSet.add(itemList1);
        mItemSet.add(itemList2);
        mItemSet.add(itemList3);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_922_2,container,false);
        ButterKnife.bind(this,v);
        initData();
        initView();
        return v;
    }

    private void initView() {
        expandableAdapter922 = new ExpandableAdapter922(mGroupList,mItemSet,getContext());
        expandableListView.setAdapter(expandableAdapter922);
        expandableListView.expandGroup(1);


        btn_refresh.setOnClickListener(v ->{
            initData2();
            expandableAdapter922 = new ExpandableAdapter922(mGroupList,mItemSet,getContext());
            expandableListView.setAdapter(expandableAdapter922);
            expandableListView.expandGroup(0);
//            expandableAdapter922.

        });

    }
}
